package com.dev.generik.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dev.generik.entities.HaloRSA.QuePx;
import com.dev.generik.entities.PX.Pasien;
import com.dev.generik.entities.PX.PxInfo;
import com.dev.generik.exception.PasienNotFoundException;
import com.dev.generik.exception.PxInfoNotFound;
import com.dev.generik.exception.QueNotFoundException;
import com.dev.generik.repository.HaloRSA.QuePxRepository;
import com.dev.generik.repository.PX.PasienRepository;
import com.dev.generik.repository.PX.PxInfoRepository;
import com.dev.generik.service.HaloRSA.AntrianERMRJService;

@RestController
@RequestMapping("his")
public class PasienController {
	@Autowired
	private PxInfoRepository pxInfoRepository;
	@Autowired
	private PasienRepository pxRepository;
	@Autowired
	private QuePxRepository quePxRepository;
	@Autowired
	private AntrianERMRJService antrianERMRJService;

	@GetMapping("/pasiens")
	CollectionModel<EntityModel<Pasien>> byPage(@RequestParam(defaultValue = "0") int pg,
			@RequestParam(defaultValue = "10") int sz, @RequestParam(defaultValue = "id") String sortBy) {

		List<EntityModel<Pasien>> pasiens = pxRepository.findAll(PageRequest.of(pg, sz, Sort.by(sortBy))).getContent()
				.stream()
				.map(pasien -> EntityModel.of(pasien,
						linkTo(methodOn(PasienController.class).one(pasien.getId())).withSelfRel()))
				.collect(Collectors.toList());

		return CollectionModel.of(pasiens,
				linkTo(methodOn(PasienController.class).byPage(pg, sz, sortBy)).withSelfRel());
	}

	@GetMapping("/pasiens/norm")
	EntityModel<Pasien> one(@RequestParam String id) {
		Pasien pasien = pxRepository.findById(id).orElseThrow(() -> new PasienNotFoundException(id));
		return EntityModel.of(pasien, linkTo(methodOn(PasienController.class).one(id)).withSelfRel());
	}

	@GetMapping("/quepx/dok")
	EntityModel<QuePx> quePxByDokter(@RequestParam String id) {
		QuePx que = quePxRepository.findById(id).orElseThrow(() -> new QueNotFoundException(id));
		return EntityModel.of(que, linkTo(methodOn(PasienController.class).quePxByDokter(id)).withSelfRel());
	}

	@GetMapping("/quepxlm")
	CollectionModel<EntityModel<QuePx>> quePxByPglm() {
		List<EntityModel<QuePx>> quePxs = quePxRepository.findAll().stream()
				.map(quepx -> EntityModel.of(quepx,
						linkTo(methodOn(PasienController.class).quePxByDokter(quepx.getId())).withSelfRel(),
						linkTo(methodOn(PasienController.class).quePxByPg()).withRel("quepx")))
				.collect(Collectors.toList());

		return CollectionModel.of(quePxs, linkTo(methodOn(PasienController.class).quePxByPg()).withSelfRel());
	}
	
	
	
	@GetMapping("/quepx")
	CollectionModel<EntityModel<QuePx>> quePxByPg() {

	    Map<String, Long> totalTerlayaniMap = antrianERMRJService.getTotalTerlayaniMap();

	    List<EntityModel<QuePx>> quePxs = quePxRepository.findAll().stream()
	            .peek(q -> {
	                String key = q.getDocid() + "-" + q.getJp();

	                Long totalTerlayani = totalTerlayaniMap.get(key);

	                if (totalTerlayani != null) {
	                    q.setFinishpx(totalTerlayani);
	                }
	            })
	            .map(quepx -> EntityModel.of(
	                    quepx,
	                    linkTo(methodOn(PasienController.class).quePxByDokter(quepx.getId())).withSelfRel(),
	                    linkTo(methodOn(PasienController.class).quePxByPg()).withRel("quepx")
	            ))
	            .collect(Collectors.toList());

	    return CollectionModel.of(
	            quePxs,
	            linkTo(methodOn(PasienController.class).quePxByPg()).withSelfRel()
	    );
	}
	
	

	@GetMapping("/quepx/jamprak")
	CollectionModel<EntityModel<QuePx>> quePxByJp(@RequestParam(name = "jp") Long jp) {

		List<EntityModel<QuePx>> quePxs = quePxRepository.findByJp(jp).stream()
				.map(quepx -> EntityModel.of(quepx,
						linkTo(methodOn(PasienController.class).quePxByJp(jp)).withSelfRel(),
						linkTo(methodOn(PasienController.class).quePxByDokter(quepx.getId())).withSelfRel(),
						linkTo(methodOn(PasienController.class).quePxByPg()).withRel("quepx")))
				.collect(Collectors.toList());

		return CollectionModel.of(quePxs, linkTo(methodOn(PasienController.class).quePxByPg()).withSelfRel());
	}

	@GetMapping("/pxinfo/pxid")
	EntityModel<PxInfo> infopx(@RequestParam Long id) {
		PxInfo pxInfo = pxInfoRepository.findById(id).orElseThrow(() -> new PxInfoNotFound(id));
		return EntityModel.of(pxInfo, linkTo(methodOn(PasienController.class).infopx(id)).withSelfRel());
	}
}
