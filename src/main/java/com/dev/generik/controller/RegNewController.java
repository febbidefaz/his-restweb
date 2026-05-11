package com.dev.generik.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.dev.generik.exception.PxInapNotFound;
import com.dev.generik.exception.PxRadNotFound;
import com.dev.generik.exception.RadiologiNotFound;
import com.dev.generik.exception.BeritaNotFound;
import com.dev.generik.exception.CustomException;
import com.dev.generik.exception.CustomExceptionS;
import com.dev.generik.models.Metadata;
import com.dev.generik.models.PxInapModel;
import com.dev.generik.models.CekPxModel;
import com.dev.generik.models.LoginDokModel;
import com.dev.generik.models.CekIdRmTglLahirModel;
import com.dev.generik.models.CekPasienModel;
import com.dev.generik.models.ResponseX;
import com.dev.generik.models.VisiteModel;
//import com.dev.generik.models.Gizi.FlowModel;
import com.dev.generik.models.Gizi.FlowModelList;
import com.dev.generik.models.Lab.LabListModel;
import com.dev.generik.models.Lab.LabListRMModel;
import com.dev.generik.models.TaskIDIRJDrDateModel;
import com.dev.generik.models.TaskIDIRJKlinikDateModel;
import com.dev.generik.models.TracerPXPlgTanggalModel;
import com.dev.generik.models.TracerPXRITanggalModel;
import com.dev.generik.models.TBScreaningRJDateModel;
import com.dev.generik.models.TBScreaningRIDateModel;
import com.dev.generik.models.TB06DateModel;
import com.dev.generik.models.TB03DateModel;
import com.dev.generik.models.CekRMTglLahirModel;
import com.dev.generik.entities.Inacbg;
import com.dev.generik.entities.Dokter.Dokter;
import com.dev.generik.entities.Dokter.DokterOp;
import com.dev.generik.entities.Dokter.LoginDokter;
import com.dev.generik.entities.Dokter.Specialist;
import com.dev.generik.entities.Dokter.SpecialistB;
import com.dev.generik.entities.Dokter.SpecialistOL;
import com.dev.generik.entities.Dokter.SpecialistSKDP;
import com.dev.generik.entities.Dokter.VisiteDokterOnsite;
import com.dev.generik.entities.ERM.IGD.ERMIGDObservasi;
import com.dev.generik.entities.ERM.IGD.ERMIGDObservasiCPPT;
import com.dev.generik.entities.ERM.IGD.ERMIGDPengkajianAwalAnalisaNRencana;
import com.dev.generik.entities.ERM.IGD.ERMIGDPengkajianAwalAnalisaNRencanaKep;
import com.dev.generik.entities.ERM.IGD.ERMIGDPengkajianAwalDischargePlanning;
import com.dev.generik.entities.ERM.IGD.ERMIGDPengkajianAwalFungJatuhPopulasiEdukasi;
import com.dev.generik.entities.ERM.IGD.ERMIGDPengkajianAwalKep;
import com.dev.generik.entities.ERM.IGD.ERMIGDPengkajianAwalMedis;
import com.dev.generik.entities.ERM.IGD.ERMIGDPengkajianAwalNyeri;
import com.dev.generik.entities.ERM.IGD.ERMIGDPengkajianAwalPsikoEkoNut;
import com.dev.generik.entities.ERM.IGD.ERMIGDPengkajianAwalTriage;
import com.dev.generik.entities.ERM.IGD.PxIGD;
import com.dev.generik.entities.ERM.IGD.SkriningCovid.ERMIGDSkriningCovid;
import com.dev.generik.entities.ERM.IGD.SkriningCovid.ERMIGDSkriningCovidPost;
import com.dev.generik.entities.ERM.IGD.SkriningHPPVK.ERMIGDVKHPPView;
import com.dev.generik.entities.ERM.IGD.SkriningTB.ERMIGDSkriningTB;
import com.dev.generik.entities.ERM.IGD.SkriningTB.ERMIGDSkriningTBPost;
import com.dev.generik.entities.ERM.IGD.SkriningTB.ERMIGDSkriningTBKet;
import com.dev.generik.entities.ERM.Lab.LabHasilBatasList;
import com.dev.generik.entities.ERM.Lab.LabHasilBatasListRM;
import com.dev.generik.entities.ERM.Lab.LabHasilBatasPX;
import com.dev.generik.entities.ERM.Lab.LabHasilBatasPXCek;
//import com.dev.generik.entities.ERM.Lab.LabHasilBatas;
import com.dev.generik.entities.ERM.Lab.LabHasilBatasSP;
import com.dev.generik.entities.ERM.Lab.LabHasilKultur;
import com.dev.generik.entities.ERM.PA.PAHasil;
import com.dev.generik.entities.ERM.PA.PAHasilListRM;
import com.dev.generik.entities.ERM.Pasien.CekIDIDN;
import com.dev.generik.entities.ERM.Pasien.CekPxWeb;
import com.dev.generik.entities.ERM.Rad.RadHasil;
import com.dev.generik.entities.ERM.Rad.RadHasilList;
import com.dev.generik.entities.ERM.Rad.RadHasilListRM;
import com.dev.generik.entities.ERM.Rad.RadHasilPX;
import com.dev.generik.entities.ERM.Rad.RadHasilPXCek;
import com.dev.generik.entities.ERM.Rad.Radiologi;
import com.dev.generik.entities.ERM.Rad.RadiologiBaca;
import com.dev.generik.entities.ERM.SP.SPLab;
import com.dev.generik.entities.ERM.SP.SPLabCek;
import com.dev.generik.entities.ERM.SP.SPLabGet;
import com.dev.generik.entities.ERM.SP.SPLabPrint;
import com.dev.generik.entities.ERM.SP.SPRad;
import com.dev.generik.entities.ERM.SP.SPRadCek;
import com.dev.generik.entities.ERM.SP.SPRadGet;
import com.dev.generik.entities.ERM.SP.SPRadPrint;
import com.dev.generik.entities.ERM.DokterERM;
import com.dev.generik.entities.Gizi.Flow;
import com.dev.generik.entities.Gizi.FlowCek;
import com.dev.generik.entities.Gizi.FlowDet;
import com.dev.generik.entities.Gizi.FlowDetClass;
import com.dev.generik.entities.Gizi.LogGiziProduct;
import com.dev.generik.entities.HaloRSA.CekPx;
import com.dev.generik.entities.HaloRSA.NoWaAndroid;
import com.dev.generik.entities.HaloRSA.NonUSGXRayCT;
import com.dev.generik.entities.Inap.Paviliun;
import com.dev.generik.entities.Inap.PxInapOnsite;
import com.dev.generik.entities.Inap.TracerPXPlg;
import com.dev.generik.entities.Inap.TracerPXRI;
import com.dev.generik.entities.Other.SensusIRJ;
import com.dev.generik.entities.Other.UPx;
import com.dev.generik.entities.PSDI.Diklat;
import com.dev.generik.entities.PSDI.DiklatNew;
import com.dev.generik.entities.Que.AntrianKORJ;
import com.dev.generik.entities.RJ.ListPxRJNow;
import com.dev.generik.entities.RJ.PxRJ;
import com.dev.generik.entities.RJ.TaskIDIRJ;
import com.dev.generik.entities.Rad.RadiologiBacaPeriksa;
import com.dev.generik.entities.TB.TB03;
import com.dev.generik.entities.TB.TB06;
import com.dev.generik.entities.TB.TBICD;
import com.dev.generik.entities.TB.TBScreaningRI;
import com.dev.generik.entities.TB.TBScreaningRJ;
import com.dev.generik.repository.Dokter.DokterRepository;
import com.dev.generik.repository.Dokter.LoginDokterRepository;
import com.dev.generik.repository.Dokter.SpecialistBRepository;
import com.dev.generik.repository.Dokter.SpecialistOLRepository;
import com.dev.generik.repository.Dokter.SpecialistRepository;
import com.dev.generik.repository.Dokter.SpecialistSKDPRepository;
import com.dev.generik.repository.Dokter.VisiteDokterOnsiteRepository;
import com.dev.generik.repository.ERM.DokterERMRepository;
import com.dev.generik.repository.ERM.IGD.ERMIGDObservasiCPPTRepository;
import com.dev.generik.repository.ERM.IGD.ERMIGDObservasiRepository;
import com.dev.generik.repository.ERM.IGD.ERMIGDPengkajianAwalAnalisaNRencanaKepRepository;
import com.dev.generik.repository.ERM.IGD.ERMIGDPengkajianAwalAnalisaNRencanaRepository;
import com.dev.generik.repository.ERM.IGD.ERMIGDPengkajianAwalDischargePlanningRepository;
import com.dev.generik.repository.ERM.IGD.ERMIGDPengkajianAwalFungJatuhPopulasiEdukasiRepository;
import com.dev.generik.repository.ERM.IGD.ERMIGDPengkajianAwalKepRepository;
import com.dev.generik.repository.ERM.IGD.ERMIGDPengkajianAwalMedisRepository;
import com.dev.generik.repository.ERM.IGD.ERMIGDPengkajianAwalNyeriRepository;
import com.dev.generik.repository.ERM.IGD.ERMIGDPengkajianAwalPsikoEkoNutRepository;
import com.dev.generik.repository.ERM.IGD.ERMIGDPengkajianAwalTriageRepository;
import com.dev.generik.repository.ERM.IGD.ERMIGDSkriningCovidPostRepository;
import com.dev.generik.repository.ERM.IGD.ERMIGDSkriningCovidRepository;
import com.dev.generik.repository.ERM.IGD.ERMIGDSkriningTBKetRepository;
import com.dev.generik.repository.ERM.IGD.ERMIGDSkriningTBRepository;
import com.dev.generik.repository.ERM.IGD.ERMIGDSkriningTBPostRepository;
import com.dev.generik.repository.ERM.IGD.ERMIGDVKHPPViewRepository;
import com.dev.generik.repository.ERM.IGD.PxIGDRepository;
import com.dev.generik.repository.ERM.Lab.LabHasilBatasCekRepository;
import com.dev.generik.repository.ERM.Lab.LabHasilBatasPXRepository;
import com.dev.generik.repository.ERM.Lab.LabHasilBatasRepository;
import com.dev.generik.repository.ERM.Lab.LabHasilBatasSPRepository;
import com.dev.generik.repository.ERM.Rad.RadHasilPXRepository;
import com.dev.generik.repository.ERM.Rad.RadHasilRepository;
import com.dev.generik.repository.ERM.Rad.RadHasilPXCekRepository;
import com.dev.generik.repository.ERM.SP.SPLabCekRepository;
import com.dev.generik.repository.ERM.SP.SPLabGetRepository;
import com.dev.generik.repository.ERM.SP.SPLabListRepository;
import com.dev.generik.repository.ERM.SP.SPLabRepository;
import com.dev.generik.repository.ERM.SP.SPRadCekRepository;
import com.dev.generik.repository.ERM.SP.SPRadGetRepository;
import com.dev.generik.repository.ERM.SP.SPRadListRepository;
import com.dev.generik.repository.ERM.SP.SPRadRepository;
import com.dev.generik.repository.ERM.pasien.CekIDIDNRepository;
import com.dev.generik.repository.ERM.pasien.CekPxWebRepository;
import com.dev.generik.repository.Gizi.FlowCekRepository;
import com.dev.generik.repository.Gizi.FlowDetRepository;
import com.dev.generik.repository.Gizi.FlowDetViewRepository;
import com.dev.generik.repository.Gizi.FlowRepository;
import com.dev.generik.repository.Gizi.FlowViewRepository;
import com.dev.generik.repository.Gizi.LogGiziProductRepository;
import com.dev.generik.repository.HaloRSA.CekPxRepository;
import com.dev.generik.repository.HaloRSA.CekPxRepositoryV2;
import com.dev.generik.repository.HaloRSA.NoWaAndroidRepository;
import com.dev.generik.repository.Inap.PaviliunRepository;
import com.dev.generik.repository.Inap.TracerPXPlgRepository;
import com.dev.generik.repository.Inap.TracerPXRIRepository;
import com.dev.generik.repository.Other.SensusIRJRepository;
import com.dev.generik.repository.Other.UPxRepository;
import com.dev.generik.repository.PSDI.DiklatNewRepository;
import com.dev.generik.repository.PSDI.DiklatRepository;
import com.dev.generik.repository.PX.PxInapOnsiteRepository;
import com.dev.generik.repository.InacbgRepository;
import com.dev.generik.repository.Que.AntrianKORJRepository;
import com.dev.generik.repository.RJ.ListPXRJNowRepository;
import com.dev.generik.repository.RJ.PxRJRepository;
import com.dev.generik.repository.RJ.TaskIDIRJRepository;
import com.dev.generik.repository.Rad.NonUSGXRayCTRepository;
import com.dev.generik.repository.Rad.RadiologiBacaPeriksaRepository;
import com.dev.generik.repository.Rad.RadiologiBacaRepository;
import com.dev.generik.repository.Rad.RadiologiRepository;
import com.dev.generik.repository.TB.TB03Repository;
import com.dev.generik.repository.TB.TB06Repository;
import com.dev.generik.repository.TB.TBICDRepository;
import com.dev.generik.repository.TB.TBScreaningRIRepository;
import com.dev.generik.repository.TB.TBScreaningRJRepository;
import com.dev.generik.service.Dokter.DokterOpService;
import com.dev.generik.service.Lab.LabHasilBatasListRMService;
import com.dev.generik.service.Lab.LabHasilBatasListService;
import com.dev.generik.service.Lab.LabHasilBatasSPService;
import com.dev.generik.service.Lab.LabHasilKulturService;
import com.dev.generik.service.Lab.SPLabPrintService;
import com.dev.generik.service.PA.PAHasilListRMService;
import com.dev.generik.service.PA.PAHasilService;
import com.dev.generik.service.Rad.RadHasilListRMService;
import com.dev.generik.service.Rad.RadHasilListService;
import com.dev.generik.service.Rad.SPRadPrintService;

@RestController
@RequestMapping("his/new")
public class RegNewController {
	
	@Autowired
	SpecialistRepository specialistRepository;
	@Autowired
	SpecialistSKDPRepository specialistSKDPRepository;
	@Autowired
	SpecialistOLRepository specialistOLRepository;
	@Autowired
	SpecialistBRepository specialistBRepository;
	@Autowired
	DiklatRepository diklatRepository;
	@Autowired
	DiklatNewRepository diklatNewRepository;
	@Autowired
	DokterRepository dokterRepository;
	@Autowired
	CekPxRepository cekPxRepository;
	@Autowired
	CekPxRepositoryV2 cekPxRepositoryV2;
	@Autowired
	NoWaAndroidRepository noWaAndroidRepository;
	@Autowired
	RadiologiBacaRepository radiologiBacaRepository;
	@Autowired
	RadiologiBacaPeriksaRepository radiologiBacaPeriksaRepository;
	@Autowired
	NonUSGXRayCTRepository nonUSGXRayCTRepository;
	@Autowired
	RadiologiRepository radiologiRepository;
	@Autowired
	ListPXRJNowRepository listPXRJNowRepository;
	@Autowired
	LoginDokterRepository loginDokterRepository;
	@Autowired
	PxInapOnsiteRepository pxInapOnsiteRepository;
	@Autowired
	PxRJRepository pxRJRepository;
	@Autowired
	VisiteDokterOnsiteRepository visitDokterOnsiteRepository;
	@Autowired
	TaskIDIRJRepository taskIDIRJRepository;
	@Autowired
	TracerPXPlgRepository tracerPXPlgRepository;
	@Autowired
	PaviliunRepository paviliunRepository;
	@Autowired
	TracerPXRIRepository tracerPXRIRepository;
	@Autowired
	TBScreaningRJRepository tBScreaningRJRepository;
	@Autowired
	TBScreaningRIRepository tBScreaningRIRepository;
	@Autowired
	TB06Repository tB06Repository;
	@Autowired
	TB03Repository tB03Repository;
	@Autowired
	TBICDRepository tBICDRepository;
	@Autowired
	InacbgRepository inacbgRepository;
	@Autowired
	ERMIGDPengkajianAwalTriageRepository eRMIGDPengkajianAwalTriageRepository;
	@Autowired
	ERMIGDPengkajianAwalKepRepository eRMIGDPengkajianAwalKepRepository;
	@Autowired
	ERMIGDPengkajianAwalPsikoEkoNutRepository eRMIGDPengkajianAwalPsikoEkoNutRepository;
	@Autowired
	ERMIGDPengkajianAwalNyeriRepository eRMIGDPengkajianAwalNyeriRepository;
	@Autowired
	ERMIGDPengkajianAwalFungJatuhPopulasiEdukasiRepository eRMIGDPengkajianAwalFungJatuhPopulasiEdukasiRepository;
	@Autowired
	ERMIGDPengkajianAwalMedisRepository eRMIGDPengkajianAwalMedisRepository;
	@Autowired
	ERMIGDPengkajianAwalAnalisaNRencanaRepository eRMIGDPengkajianAwalAnalisaNRencanaRepository;
	@Autowired
	ERMIGDPengkajianAwalAnalisaNRencanaKepRepository eRMIGDPengkajianAwalAnalisaNRencanaKepRepository;
	@Autowired
	ERMIGDPengkajianAwalDischargePlanningRepository eRMIGDPengkajianAwalDischargePlanningRepository;
	@Autowired
	ERMIGDObservasiRepository eRMIGDObservasiRepository;
	@Autowired
	ERMIGDObservasiCPPTRepository eRMIGDObservasiCPPTRepository;
	@Autowired
	ERMIGDSkriningCovidRepository eRMIGDSkriningCovidRepository;
	@Autowired
	ERMIGDSkriningCovidPostRepository eRMIGDSkriningCovidPostRepository;
	@Autowired
	ERMIGDSkriningTBRepository eRMIGDSkriningTBRepository;
	@Autowired
	ERMIGDSkriningTBPostRepository eRMIGDSkriningTBPostRepository;
	@Autowired
	ERMIGDSkriningTBKetRepository eRMIGDSkriningTBKetRepository;
	@Autowired
	AntrianKORJRepository antrianKORJRepository;
	@Autowired
	LabHasilBatasRepository labHasilBatasRepository;
	@Autowired
	LabHasilBatasCekRepository labHasilBatasCekRepository;
	@Autowired
	LabHasilBatasPXRepository labHasilBatasPXRepository;
	@Autowired
	LabHasilBatasSPRepository labHasilBatasSPRepository;	
	@Autowired
	SPLabRepository sPLabRepository;
	@Autowired
	SPLabGetRepository sPLabGetRepository;
	@Autowired
	SPLabCekRepository sPLabCekRepository;
	@Autowired
	SPLabListRepository sPLabListRepository;
	@Autowired
	RadHasilListService radHasilListService;
	@Autowired
	RadHasilListRMService radHasilListRMService;
	@Autowired
	RadHasilRepository radHasilRepository;
	@Autowired
	RadHasilPXRepository radHasilPXRepository;
	@Autowired
	RadHasilPXCekRepository radHasilPXCekRepository;
	@Autowired
	ERMIGDVKHPPViewRepository eRMIGDVKHPPRepository;
	@Autowired
	LogGiziProductRepository logGiziProductRepository;
	@Autowired
	SPRadRepository sPRadRepository;
	@Autowired
	SPRadGetRepository sPRadGetRepository;
	@Autowired
	SPRadCekRepository sPRadCekRepository;
	@Autowired
	SPRadListRepository sPRadListRepository;
	@Autowired
	DokterERMRepository dokterERMRepository;
	@Autowired
	LabHasilBatasListService labHasilBatasListService;
	@Autowired
	LabHasilBatasListRMService labHasilBatasListRMService;
	@Autowired
	PAHasilListRMService pAHasilListRMService;
	@Autowired
	PAHasilService pAHasilService;
	@Autowired
	LabHasilBatasSPService labHasilBatasSPService;
	@Autowired
	LabHasilKulturService labHasilKulturService;
	@Autowired
	FlowDetRepository flowDetRepository;
	@Autowired
	FlowRepository flowRepository;
	@Autowired
	FlowCekRepository flowCekRepository;
	@Autowired
	FlowDetViewRepository flowDetViewRepository;
	@Autowired
	FlowViewRepository flowViewRepository;
	@Autowired
	PxIGDRepository pxIGDRepository;
	@Autowired
	CekPxWebRepository cekPxWebRepository;
	@Autowired
	CekIDIDNRepository cekIDIDNRepository;
	@Autowired
	UPxRepository uPxRepository;
	@Autowired
	SensusIRJRepository sensusIRJRepository;
	@Autowired
	DokterOpService dokterOpService;
	@Autowired
	SPLabPrintService sPLabPrintService;
	@Autowired
	SPRadPrintService sPRadPrintService;
	
	@GetMapping("/Specialist")
	List<Specialist> Specialist() {
		return specialistRepository.findAll();
	}
	
	@GetMapping("/Spesialis")
	public ResponseEntity<?> Spesialis(
	        @RequestParam(required = false) Long id,
	        @RequestParam(required = false) String nama,
	        @RequestParam(required = false) String kdBPJS) {

	    if (id != null) {
	        return specialistSKDPRepository.findById(id)
	                .map(ResponseEntity::ok)
	                .orElseGet(() -> ResponseEntity.notFound().build());
	    }

	    if (kdBPJS != null && !kdBPJS.isEmpty()) {
	        return specialistSKDPRepository.findByKdBPJSIgnoreCase(kdBPJS)
	                .map(ResponseEntity::ok)
	                .orElseGet(() -> ResponseEntity.notFound().build());
	    }

	    List<SpecialistSKDP> result;

	    if (nama != null && !nama.isEmpty()) {
	        result = specialistSKDPRepository.findByNameContainingIgnoreCaseOrderByNameAsc(nama);
	    } else {
	        result = specialistSKDPRepository.findTop20ByOrderByNameAsc();
	    }

	    return ResponseEntity.ok(result);
	}
	

	@GetMapping("/Specialist/sp")
	CollectionModel<EntityModel<Dokter>> DokterBySpesialis(@RequestParam(name = "sp") Long sp) {

		List<EntityModel<Dokter>> rd = dokterRepository.findBySp(sp).stream().map(dokter -> EntityModel.of(dokter))// ,
				// linkTo(methodOn(CollectionInfoController.class).listJadwalDokter()).withRel("jadwaldokter")))
				.collect(Collectors.toList());

		return CollectionModel.of(rd, linkTo(methodOn(RegNewController.class).Specialist()).withSelfRel());
	}

	@GetMapping("/DokterOp")
	public ResponseEntity<?> getDokterOp(
	        @RequestParam(required = false) Long id,
	        @RequestParam(required = false) String nama,
	        @RequestParam(required = false) String namaOp,
	        @RequestParam(required = false) String kdBPJS) {

	    // 1. By ID
	    if (id != null) {
	        return dokterOpService.findById(id)
	                .map(ResponseEntity::ok)
	                .orElseGet(() -> ResponseEntity.notFound().build());
	    }

	    // 2. By kdBPJS
	    if (kdBPJS != null && !kdBPJS.isEmpty()) {
	        return dokterOpService.findByKdBPJS(kdBPJS)
	                .map(ResponseEntity::ok)
	                .orElseGet(() -> ResponseEntity.notFound().build());
	    }

	    List<DokterOp> result;

	    // 3. By nama
	    if (nama != null && !nama.isEmpty()) {
	        result = dokterOpService.findByNamaContains(nama);
	    }
	    // 4. By namaOp
	    else if (namaOp != null && !namaOp.isEmpty()) {
	        result = dokterOpService.findByNamaOpContains(namaOp);
	    }
	    // 5. Default top 20
	    else {
	        result = dokterOpService.getTop20();
	    }

	    return ResponseEntity.ok(result);
	}

	
	@GetMapping("/SpecialistOL")
	List<SpecialistOL> SpecialistOL() {
		return specialistOLRepository.findAll();
	}

	@GetMapping("/SpecialistB")
	List<SpecialistB> SpecialistB() {
		return specialistBRepository.findAll();
	}

	@GetMapping("/Diklat")
	List<Diklat> Diklat() {
		return diklatRepository.findAll();
	}

	@GetMapping("/Radiologi")
	List<Radiologi> Radiologi() {
		return radiologiRepository.findAll();
	}

	@GetMapping("/Radiologi/p")
	List<Radiologi> ListRadiologi(String periksa) {
		return radiologiRepository.findAll();
	}

	@GetMapping("/TaskIDIRJ")
	List<TaskIDIRJ> TaskIDIRJ() {
		return taskIDIRJRepository.findAll();
	}

	@GetMapping("/Paviliun")
	List<Paviliun> Paviliun() {
		return paviliunRepository.findAll();
	}

	@GetMapping("/TBScreaningRJPeriode")
	ResponseEntity<ResponseX<List<TBScreaningRJ>, Metadata>> TBScreaningRJByRangeDate(
			@RequestBody TBScreaningRJDateModel taskIDIRJDrDat) {

		Optional<List<TBScreaningRJ>> taskIDIRJ = tBScreaningRJRepository
				.findByTanggalBetween(taskIDIRJDrDat.getbDate(), taskIDIRJDrDat.geteDate());
		if (taskIDIRJ.isEmpty()) {
			final String msg = "Listing data empty";
			throw new CustomException(HttpStatus.NOT_FOUND.value(), msg, HttpStatus.NOT_FOUND);
		} else {
			ResponseX<List<TBScreaningRJ>, Metadata> responseX = new ResponseX<>(taskIDIRJ.get(),
					new Metadata(ResponseEntity.of(Optional.of(taskIDIRJ)).getStatusCode().value(),
							ResponseEntity.of(Optional.of(taskIDIRJ)).getStatusCode().toString()));
			return ResponseEntity.ok(responseX);
		}
	}

	@GetMapping("/TBScreaningRIPeriode")
	ResponseEntity<ResponseX<List<TBScreaningRI>, Metadata>> TBScreaningRIByRIAndRangeDate(
			@RequestBody TBScreaningRIDateModel taskIDIRJDrDat) {

		Optional<List<TBScreaningRI>> taskIDIRJ = tBScreaningRIRepository.findByRiAndTanggalBetween(
				taskIDIRJDrDat.getRi(), taskIDIRJDrDat.getbDate(), taskIDIRJDrDat.geteDate());
		if (taskIDIRJ.isEmpty()) {
			final String msg = "Listing data empty";
			throw new CustomException(HttpStatus.NOT_FOUND.value(), msg, HttpStatus.NOT_FOUND);
		} else {
			ResponseX<List<TBScreaningRI>, Metadata> responseX = new ResponseX<>(taskIDIRJ.get(),
					new Metadata(ResponseEntity.of(Optional.of(taskIDIRJ)).getStatusCode().value(),
							ResponseEntity.of(Optional.of(taskIDIRJ)).getStatusCode().toString()));
			return ResponseEntity.ok(responseX);
		}
	}

	@GetMapping("/TaskIDIRJ/DokterIdPeriode")
	ResponseEntity<ResponseX<List<TaskIDIRJ>, Metadata>> TaskIDIRJByDokterIdAndRangeDate(
			@RequestBody TaskIDIRJDrDateModel taskIDIRJDrDat) {

		Optional<List<TaskIDIRJ>> taskIDIRJ = taskIDIRJRepository.findByDokteridAndDateBetween(
				taskIDIRJDrDat.getDokterid(), taskIDIRJDrDat.getbDate(), taskIDIRJDrDat.geteDate());
		if (taskIDIRJ.isEmpty()) {
			final String msg = "Listing data empty";
			throw new CustomException(HttpStatus.NOT_FOUND.value(), msg, HttpStatus.NOT_FOUND);
		} else {
			ResponseX<List<TaskIDIRJ>, Metadata> responseX = new ResponseX<>(taskIDIRJ.get(),
					new Metadata(ResponseEntity.of(Optional.of(taskIDIRJ)).getStatusCode().value(),
							ResponseEntity.of(Optional.of(taskIDIRJ)).getStatusCode().toString()));
			return ResponseEntity.ok(responseX);
		}
	}

	@GetMapping("/TaskIDIRJ/KlinikPeriode")
	ResponseEntity<ResponseX<List<TaskIDIRJ>, Metadata>> TaskIDIRJByKlinikAndRangeDate(
			@RequestBody TaskIDIRJKlinikDateModel taskIDIRJDrDat) {

		Optional<List<TaskIDIRJ>> taskIDIRJ = taskIDIRJRepository.findBySublayananidAndDateBetween(
				taskIDIRJDrDat.getSublayananid(), taskIDIRJDrDat.getbDate(), taskIDIRJDrDat.geteDate());
		if (taskIDIRJ.isEmpty()) {
			final String msg = "Listing data empty";
			throw new CustomException(HttpStatus.NOT_FOUND.value(), msg, HttpStatus.NOT_FOUND);
		} else {
			ResponseX<List<TaskIDIRJ>, Metadata> responseX = new ResponseX<>(taskIDIRJ.get(),
					new Metadata(ResponseEntity.of(Optional.of(taskIDIRJ)).getStatusCode().value(),
							ResponseEntity.of(Optional.of(taskIDIRJ)).getStatusCode().toString()));
			return ResponseEntity.ok(responseX);
		}
	}

	@GetMapping("/TracerPXPlg/Paviliun")
	ResponseEntity<ResponseX<List<TracerPXPlg>, Metadata>> TracerPXPlgByPaviliunAndRangeTanggal(
			@RequestBody TracerPXPlgTanggalModel taskIDIRJDrDat) {

		Optional<List<TracerPXPlg>> taskIDIRJ = tracerPXPlgRepository.findByPavidAndTanggalBetween(
				taskIDIRJDrDat.getPaviliunid(), taskIDIRJDrDat.getbDate(), taskIDIRJDrDat.geteDate());
		if (taskIDIRJ.isEmpty()) {
			final String msg = "Listing data empty";
			throw new CustomException(HttpStatus.NOT_FOUND.value(), msg, HttpStatus.NOT_FOUND);
		} else {
			ResponseX<List<TracerPXPlg>, Metadata> responseX = new ResponseX<>(taskIDIRJ.get(),
					new Metadata(ResponseEntity.of(Optional.of(taskIDIRJ)).getStatusCode().value(),
							ResponseEntity.of(Optional.of(taskIDIRJ)).getStatusCode().toString()));
			return ResponseEntity.ok(responseX);
		}
	}

	@GetMapping("/TracerPXRI")
	ResponseEntity<ResponseX<List<TracerPXRI>, Metadata>> TracerPXRIByPaviliunAndRangeTanggal(
			@RequestBody TracerPXRITanggalModel taskIDIRJDrDat) {

		Optional<List<TracerPXRI>> taskIDIRI = tracerPXRIRepository.findByTanggalBetween(
				// taskIDIRJDrDat.getPaviliunid(),
				taskIDIRJDrDat.getbDate(), taskIDIRJDrDat.geteDate());
		if (taskIDIRI.isEmpty()) {
			final String msg = "Listing data empty";
			throw new CustomException(HttpStatus.NOT_FOUND.value(), msg, HttpStatus.NOT_FOUND);
		} else {
			ResponseX<List<TracerPXRI>, Metadata> responseX = new ResponseX<>(taskIDIRI.get(),
					new Metadata(ResponseEntity.of(Optional.of(taskIDIRI)).getStatusCode().value(),
							ResponseEntity.of(Optional.of(taskIDIRI)).getStatusCode().toString()));
			return ResponseEntity.ok(responseX);
		}
	}

	@GetMapping("/NewDiklat/Diklatid")
	EntityModel<DiklatNew> getDiklatNew(@RequestParam Long id) {
		DiklatNew dik = diklatNewRepository.findById(id).orElseThrow(() -> new PxInapNotFound(id));
		return EntityModel.of(dik, linkTo(methodOn(RegNewController.class).getDiklatNew(id)).withSelfRel());
	}

	@GetMapping("/Radiologi/id")
	EntityModel<Radiologi> getRadiologi(@RequestParam Long id) {
		Radiologi rad = radiologiRepository.findById(id).orElseThrow(() -> new PxInapNotFound(id));
		return EntityModel.of(rad, linkTo(methodOn(RegNewController.class).getRadiologi(id)).withSelfRel());
	}

	@GetMapping("/Radiologi/periksa")
	EntityModel<Radiologi> getRadiologi(@RequestParam String periksa) {
		Radiologi rad = radiologiRepository.findByPeriksa(periksa).orElseThrow(() -> new RadiologiNotFound(periksa));
		return EntityModel.of(rad, linkTo(methodOn(RegNewController.class).getRadiologi(periksa)).withSelfRel());
	}
	/*
	 * @GetMapping("/Radiologi/periksa") EntityModel<Radiologi>
	 * getRadiologi(@RequestParam String periksa) { Radiologi rad =
	 * radiologiRepository.searchByPeriksaLike(periksa).orElseThrow(() -> new
	 * RadiologiNotFound(periksa)); return EntityModel.of(rad,
	 * linkTo(methodOn(RegNewController.class).getRadiologi(periksa)).withSelfRel())
	 * ; }
	 */
	@GetMapping("/RadiologiBacaPeriksa/IDRadN")
	EntityModel<RadiologiBacaPeriksa> getRadiologiBacaPeriksa(@RequestParam String id) {
		RadiologiBacaPeriksa rad = radiologiBacaPeriksaRepository.findById(id).orElseThrow(() -> new PxRadNotFound(id));
		return EntityModel.of(rad, linkTo(methodOn(RegNewController.class).getRadiologiBacaPeriksa(id)).withSelfRel());
	}

	/*
	 * @GetMapping("/ListPXRJNow") EntityModel<ListPxRJNow>
	 * getListPxRJNow(@RequestParam Long jp) { ListPxRJNow lispx =
	 * listPXRJNowRepository.findByJP(jp) .orElseThrow( () -> new
	 * PxInapNotFound(jp)); return
	 * EntityModel.of(lispx,linkTo(methodOn(RegNewController.class).getListPxRJNow(
	 * jp)).withSelfRel()); }
	 */

	@GetMapping("/ListPXRJNow")
	CollectionModel<EntityModel<ListPxRJNow>> ListPxRJNowByJp(@RequestParam(name = "jp") Long jp) {

		List<EntityModel<ListPxRJNow>> rd = listPXRJNowRepository.findByJp(jp).stream()
				.map(listPxRJNow -> EntityModel.of(listPxRJNow))// ,
				// linkTo(methodOn(CollectionInfoController.class).listJadwalDokter()).withRel("jadwaldokter")))
				.collect(Collectors.toList());

		return CollectionModel.of(rd, linkTo(methodOn(RegNewController.class).Specialist()).withSelfRel());
	}

	@PostMapping("/NewDiklat")
	ResponseEntity<EntityModel<DiklatNew>> addNewDiklat(@RequestBody DiklatNew diklatNew) throws URISyntaxException {
		DiklatNew diklatSave = diklatNewRepository.save(diklatNew);
		EntityModel<DiklatNew> resource = EntityModel.of(diklatSave,
				linkTo(methodOn(RegNewController.class).getDiklatNew(diklatSave.getId())).withSelfRel());

		return ResponseEntity.created(resource.getRequiredLink(IanaLinkRelations.SELF).toUri()).body(resource);
	}

	@GetMapping("/NonUSGXRayCT/id")
	EntityModel<NonUSGXRayCT> getNonUSGXRayCT(@RequestParam Long idrad) {
		NonUSGXRayCT dik = nonUSGXRayCTRepository.findByIdrad(idrad).orElseThrow(() -> new PxInapNotFound(idrad));
		return EntityModel.of(dik, linkTo(methodOn(RegNewController.class).getNonUSGXRayCT(idrad)).withSelfRel());
	}

	@PostMapping("/NonUSGXRayCT")
	ResponseEntity<ResponseX<NonUSGXRayCT, Metadata>> addNonUSGXRayCT(@RequestBody NonUSGXRayCT nonUSGXRayCT) {
		NonUSGXRayCT regSave;
		if (nonUSGXRayCTRepository.findByIdradAndJenisid(nonUSGXRayCT.getIdrad(), nonUSGXRayCT.getJenisid())
				.isPresent()) {
			final String msg = "Data Sudah Di Input ...!";
			throw new CustomException(HttpStatus.BAD_REQUEST.value(), msg, HttpStatus.BAD_REQUEST);
		} else {
			try {
				regSave = nonUSGXRayCTRepository.save(nonUSGXRayCT);
			} catch (IllegalArgumentException e) {
				final String msg = "Payload Tidak Valid ...";
				throw new CustomException(HttpStatus.BAD_REQUEST.value(), msg, HttpStatus.BAD_REQUEST);
			}
		}

		final String messageOk = "Ok";
		Metadata metadata = new Metadata(HttpStatus.OK.value(), messageOk);
		ResponseX<NonUSGXRayCT, Metadata> responseX = new ResponseX<>(regSave, metadata);
		return ResponseEntity.ok(responseX);

	}

	@PutMapping("/UpdateDiklat")
	ResponseEntity<EntityModel<DiklatNew>> updateDiklat(@RequestParam(name = "diklatid") Long diklatid,
			@RequestBody DiklatNew diklatNew) throws URISyntaxException {

		DiklatNew diklatUpdate = diklatNewRepository.findById(diklatid).map(diklat -> {
			diklat.setJudul(diklatNew.getJudul());
			diklat.setTanggal(diklatNew.getTanggal());
			diklat.setIsi(diklatNew.getIsi());
			diklat.setFotojudul(diklatNew.getFotojudul());
			diklat.setFoto1(diklatNew.getFoto1());
			diklat.setFoto2(diklatNew.getFoto2());
			diklat.setFoto3(diklatNew.getFoto3());
			diklat.setFoto4(diklatNew.getFoto4());
			diklat.setPdf1(diklatNew.getPdf1());
			diklat.setPdf2(diklatNew.getPdf2());
			diklat.setPdf3(diklatNew.getPdf3());
			diklat.setPdf4(diklatNew.getPdf4());
			return diklatNewRepository.save(diklat);
		}).get();
		// .orElseGet(() -> {
//                    pxNew.setId(pxid);
//                    return beritaNewRepository.save(beritaNew);
//                });

		EntityModel<DiklatNew> resource = EntityModel.of(diklatUpdate,
				linkTo(methodOn(RegNewController.class).getDiklatNew(diklatUpdate.getId())).withSelfRel());

		return ResponseEntity.created(resource.getRequiredLink(IanaLinkRelations.SELF).toUri()).body(resource);
	}

	@PutMapping("/UpdateNonUSGXRayCT")
	ResponseEntity<EntityModel<NonUSGXRayCT>> updateNonUSGXRayCT(@RequestParam(name = "idrad") Long idrad,
			@RequestParam(name = "jenisid") Long jenisid, @RequestBody NonUSGXRayCT nonUSGXRayCT)
			throws URISyntaxException {

		NonUSGXRayCT nonUSGXRayCTUpdate = nonUSGXRayCTRepository.findByIdradAndJenisid(idrad, jenisid).map(nonUSG -> {
			// nonUSG.setIdrad(nonUSGXRayCT.getIdrad());
			// nonUSG.setJenisid(nonUSGXRayCT.getJenisid());
			nonUSG.setResult(nonUSGXRayCT.getResult());
			nonUSG.setKesimpulan(nonUSGXRayCT.getKesimpulan());
			return nonUSGXRayCTRepository.save(nonUSG);
		}).get();
		// .orElseGet(() -> {
//                    pxNew.setId(pxid);
//                    return beritaNewRepository.save(beritaNew);
//                });

		EntityModel<NonUSGXRayCT> resource = EntityModel.of(nonUSGXRayCTUpdate,
				linkTo(methodOn(RegNewController.class).getNonUSGXRayCT(nonUSGXRayCTUpdate.getIdrad())).withSelfRel());

		return ResponseEntity.created(resource.getRequiredLink(IanaLinkRelations.SELF).toUri()).body(resource);
	}

	@PutMapping("/UpdateRadiologi")
	ResponseEntity<EntityModel<Radiologi>> updateRadiologi(@RequestParam(name = "id") Long id,
			@RequestBody Radiologi radiologi) throws URISyntaxException {

		Radiologi radiologiUpdate = radiologiRepository.findById(id).map(nonUSG -> {
			nonUSG.setNormlv(radiologi.getNormlv());
			nonUSG.setKesimpulan(radiologi.getKesimpulan());
			return radiologiRepository.save(nonUSG);
		}).get();
		// .orElseGet(() -> {
//                    pxNew.setId(pxid);
//                    return beritaNewRepository.save(beritaNew);
//                });

		EntityModel<Radiologi> resource = EntityModel.of(radiologiUpdate,
				linkTo(methodOn(RegNewController.class).getRadiologi(radiologiUpdate.getId())).withSelfRel());

		return ResponseEntity.created(resource.getRequiredLink(IanaLinkRelations.SELF).toUri()).body(resource);
	}

	@DeleteMapping("/DeleteDiklat")
	void deleteDiklatNew(@RequestParam(name = "diklatid") Long diklatid) {
		diklatNewRepository.deleteById(diklatid);
		System.out.println("delete record Diklat ....");
	}

	@PostMapping("/CekPx")
	public ResponseEntity<ResponseX<CekPxModel, Metadata>> getPx(@RequestBody CekPx nope) {

		Optional<List<CekPx>> px = cekPxRepository.findByPatientidAndDate(nope.getPatientid(), nope.getDate());
		if (px.isPresent()) {
			final List<CekPasienModel> pxList = new ArrayList<>();
			px.get().forEach(p -> pxList.add(new CekPasienModel(p.getName(), p.getUpx())));

			ResponseEntity<List<CekPx>> ok = ResponseEntity.of(px);
			String messageOk = "Ok";
			Metadata metadata = new Metadata(ok.getStatusCode().value(), messageOk);
			ResponseX<CekPxModel, Metadata> responseX = new ResponseX<>(new CekPxModel(pxList), metadata);
			return ResponseEntity.ok(responseX);
		} else {
			final String msg = "Nomor Rekam Medis atau Tanggal Lahir ada yang salah";
			throw new CustomException(HttpStatus.NOT_FOUND.value(), msg, HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/CekPxV2")
	public ResponseEntity<ResponseX<CekPx, Metadata>> getDok(@RequestBody CekRMTglLahirModel nope) {

		Optional<CekPx> cpx = cekPxRepositoryV2.findByPatientidAndDate(nope.getPatientid(), nope.getDate());
		if (cpx.isPresent()) {

			ResponseEntity<CekPx> ok = ResponseEntity.of(cpx);
			String messageOk = "Ok";
			Metadata metadata = new Metadata(ok.getStatusCode().value(), messageOk);
			ResponseX<CekPx, Metadata> responseX = new ResponseX<>(cpx.get(), metadata);
			return ResponseEntity.ok(responseX);

		} else {
			final String msg = "Nomor Rekam Medis atau Tanggal Lahir ada yang salah";
			throw new CustomException(HttpStatus.NOT_FOUND.value(), msg, HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/pxinap/visite")
	public ResponseEntity<ResponseX<List<PxInapModel>, Metadata>> getVisitPxInap() {

		List<PxInapOnsite> lstInap = pxInapOnsiteRepository.findAll();

		List<PxInapModel> arrayPxInap = new ArrayList<>();
		for (PxInapOnsite px : lstInap) {
			PxInapModel pim = new PxInapModel();
			pim.setKelas(px.getKelas());
			pim.setNamaPx(px.getNamaPx());
			pim.setNoRm(px.getNoRm());
			pim.setPav(px.getPav());
			pim.setPxId(px.getPxId());
			pim.setRoomName(px.getRoomName());
			pim.setTglMsk(px.getTglMsk());
			List<VisiteModel> arrayVisite = new ArrayList<>();
			List<VisiteDokterOnsite> lstVisit = visitDokterOnsiteRepository.findByPxIdAndKlasIdAndRoomId(px.getPxId(),
					px.getKlasId(), px.getRoomId());
			for (VisiteDokterOnsite vdo : lstVisit) {
				VisiteModel vm = new VisiteModel();
				vm.setDokterId(vdo.getDokterId());
				vm.setNadok(vdo.getNadok());
				vm.setTglVisit(vdo.getTglVisit());
				arrayVisite.add(vm);
			}
			pim.setLstVisite(arrayVisite);
			arrayPxInap.add(pim);
		}
		Metadata metadata = new Metadata(HttpStatus.OK.value(), "Ok");
		ResponseX<List<PxInapModel>, Metadata> responseX = new ResponseX<>(arrayPxInap, metadata);
		return ResponseEntity.ok(responseX);
	}

	@PostMapping("/LoginDokter")
	public ResponseEntity<ResponseX<LoginDokter, Metadata>> getDok(@RequestBody LoginDokModel logdo) {

		if (logdo.getUser().isBlank() || logdo.getUser().isEmpty()) {
			String msg = "Username Tidak Boleh Kosong";
			System.out.println(msg);
			throw new CustomException(HttpStatus.UNPROCESSABLE_ENTITY.value(), msg, HttpStatus.UNPROCESSABLE_ENTITY);

		}

		if (logdo.getPass().isBlank() || logdo.getPass().isEmpty()) {
			String msg = "Password Tidak Boleh Kosong";
			System.out.println(msg);
			throw new CustomException(HttpStatus.UNPROCESSABLE_ENTITY.value(), msg, HttpStatus.UNPROCESSABLE_ENTITY);

		}

		Optional<LoginDokter> logd = loginDokterRepository.findByNameAndPass(logdo.getUser(), logdo.getPass());
		if (logd.isPresent()) {
			/*
			 * final List<LoginDokterModel> logList = new ArrayList<>();
			 * logd.get().forEach(p -> logList.add(new LoginDokterModel( p.getId(),
			 * p.getDokter(), p.getSpesialis())));
			 */

			ResponseEntity<LoginDokter> ok = ResponseEntity.of(logd);
			String messageOk = "Ok";
			Metadata metadata = new Metadata(ok.getStatusCode().value(), messageOk);
			ResponseX<LoginDokter, Metadata> responseX = new ResponseX<>(logd.get(), metadata);
			return ResponseEntity.ok(responseX);

		} else {
			final String msg = "User dan Password ada yang salah";
			// throw new
			// CustomException(HttpStatus.BAD_REQUEST.value(),msg,HttpStatus.BAD_REQUEST);
			throw new CustomException(HttpStatus.UNPROCESSABLE_ENTITY.value(), msg, HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}

	@GetMapping("/NoWAAndroid")
	List<NoWaAndroid> NoWaAndroid() {
		return noWaAndroidRepository.findAll();
	}

	@GetMapping("/RadiologiBaca")
	List<RadiologiBaca> RadiologiBaca() {
		return radiologiBacaRepository.findAll();
	}

	@GetMapping("/RadiologiBacaAll")
	CollectionModel<EntityModel<RadiologiBaca>> listPCRRekanan() {
		List<EntityModel<RadiologiBaca>> pcrrek = radiologiBacaRepository.findAll().stream()
				.map(pcrre -> EntityModel.of(pcrre)).collect(Collectors.toList());

		return CollectionModel.of(pcrrek, linkTo(methodOn(RegController.class).listAsuransi()).withSelfRel());
	}

	@GetMapping("/RadiologiBacaAll/Iddokter")
	CollectionModel<EntityModel<RadiologiBaca>> RadiologiBacaByIddokter(
			@RequestParam(name = "iddokter") Long iddokter) {

		List<EntityModel<RadiologiBaca>> rb = radiologiBacaRepository.findByIddokter(iddokter).stream()
				.map(radiologiBaca -> EntityModel.of(radiologiBaca)).collect(Collectors.toList());

		return CollectionModel.of(rb, linkTo(methodOn(RegNewController.class).RadiologiBaca()).withSelfRel());
	}

	@GetMapping("/RadiologiBacaPeriksa/IDRad")
	CollectionModel<EntityModel<RadiologiBacaPeriksa>> RadiologiBacaPeriksaByIdrad(
			@RequestParam(name = "idrad") Long idrad) {

		List<EntityModel<RadiologiBacaPeriksa>> rh = radiologiBacaPeriksaRepository.findByIdrad(idrad).stream()
				.map(radiologiBacaPeriksa -> EntityModel.of(radiologiBacaPeriksa))// ,
				// linkTo(methodOn(RegNewController.class).RadiologiBaca()).withRel("jadwaldokter")))
				.collect(Collectors.toList());

		return CollectionModel.of(rh, linkTo(methodOn(RegNewController.class).RadiologiBaca()).withSelfRel());
	}

	@GetMapping("/TB06Date")
	ResponseEntity<ResponseX<List<TB06>, Metadata>> TB06ByRangeDate(@RequestBody TB06DateModel taskIDIRJDrDat) {

		Optional<List<TB06>> taskIDIRJ = tB06Repository.findByTanggalBetween(taskIDIRJDrDat.getbDate(),
				taskIDIRJDrDat.geteDate());
		if (taskIDIRJ.isEmpty()) {
			final String msg = "Listing data empty";
			throw new CustomException(HttpStatus.NOT_FOUND.value(), msg, HttpStatus.NOT_FOUND);
		} else {
			ResponseX<List<TB06>, Metadata> responseX = new ResponseX<>(taskIDIRJ.get(),
					new Metadata(ResponseEntity.of(Optional.of(taskIDIRJ)).getStatusCode().value(),
							ResponseEntity.of(Optional.of(taskIDIRJ)).getStatusCode().toString()));
			return ResponseEntity.ok(responseX);
		}
	}

	@GetMapping("/TB03Date")
	ResponseEntity<ResponseX<List<TB03>, Metadata>> TB03ByRangeDate(@RequestBody TB03DateModel TB03Date) {

		Optional<List<TB03>> taskIDIRJ = tB03Repository.findByTanggalBetween(TB03Date.getbDate(), TB03Date.geteDate());
		if (taskIDIRJ.isEmpty()) {
			final String msg = "Listing data empty";
			throw new CustomException(HttpStatus.NOT_FOUND.value(), msg, HttpStatus.NOT_FOUND);
		} else {
			ResponseX<List<TB03>, Metadata> responseX = new ResponseX<>(taskIDIRJ.get(),
					new Metadata(ResponseEntity.of(Optional.of(taskIDIRJ)).getStatusCode().value(),
							ResponseEntity.of(Optional.of(taskIDIRJ)).getStatusCode().toString()));
			return ResponseEntity.ok(responseX);
		}
	}

	@GetMapping("/TB06all")
	List<TB06> TB06() {
		return tB06Repository.findAll();
	}

	@GetMapping("/TB03all")
	List<TB03> TB03() {
		return tB03Repository.findAll();
	}

	@GetMapping("/TBICDAll")
	List<TBICD> TBICD() {
		return tBICDRepository.findAll();
	}

	@GetMapping("/Inacbg/{id}")
	EntityModel<Inacbg> inacbgById(@PathVariable Long id) {
		Inacbg ina = inacbgRepository.findById(id).orElseThrow(() -> new PxInapNotFound(id));
		return EntityModel.of(ina, linkTo(methodOn(RegNewController.class).inacbgById(id)).withSelfRel());
	}

	@GetMapping("/TB06/{id}")
	EntityModel<TB06> tB06ById(@PathVariable Long id) {
		TB06 jad = tB06Repository.findById(id).orElseThrow(() -> new BeritaNotFound(id));
		return EntityModel.of(jad, linkTo(methodOn(RegNewController.class).tB06ById(id)).withSelfRel());
	}

	@GetMapping("/TB06/id")
	EntityModel<TB06> getTB06(@RequestParam Long id) {
		TB06 tb06 = tB06Repository.findById(id).orElseThrow(() -> new PxInapNotFound(id));
		return EntityModel.of(tb06, linkTo(methodOn(RegNewController.class).getTB06(id)).withSelfRel());
	}

	@GetMapping("/TB03/id")
	EntityModel<TB03> getTB03(@RequestParam Long id) {
		TB03 tb03 = tB03Repository.findById(id).orElseThrow(() -> new PxInapNotFound(id));
		return EntityModel.of(tb03, linkTo(methodOn(RegNewController.class).getTB03(id)).withSelfRel());
	}

	/*
	 * @PostMapping("/lab/labantigen") public ResponseEntity<ResponseX<LabModel,
	 * Metadata>> getLab(@RequestBody LabIdModel nope) {
	 * 
	 * Optional<List<LabAntigen>> px =
	 * labAntigenRepository.findByIdregAndRmAndTgllhr(nope.getIdreg(), nope.getRm(),
	 * nope.getTgllhr()); if (px.isPresent()) { final List<LaboratModel> pxList =
	 * new ArrayList<>(); px.get().forEach(p -> pxList.add(new
	 * LaboratModel(p.getId(), p.getIdreg(), p.getTlab(), p.getJamambil(),
	 * p.getJamcek(), p.getDokter(), p.getRm(), p.getNama(), p.getTgllhr(),
	 * p.getJk(), p.getAddr(), p.getKelas(), p.getGrplab(), p.getRoom(), p.getTh(),
	 * p.getBln(), p.getHr())));
	 * 
	 * ResponseEntity<List<LabAntigen>> ok = ResponseEntity.of(px); String messageOk
	 * = "Ok"; Metadata metadata = new Metadata(ok.getStatusCodeValue(), messageOk);
	 * ResponseX<LabModel, Metadata> responseX = new ResponseX<>(new
	 * LabModel(pxList), metadata); return ResponseEntity.ok(responseX); } else {
	 * final String msg = "ID, No RM, Tanggal Lahir ada yang salah"; throw new
	 * CustomException(HttpStatus.NOT_FOUND.value(), msg, HttpStatus.NOT_FOUND); } }
	 */
	/*
	 * @PostMapping("/TB06id") //@GetMapping("/TB06id") public
	 * ResponseEntity<ResponseX<TB6Model, Metadata>> getLab(@RequestBody TB06IdModel
	 * nope) {
	 * 
	 * Optional<TB06> px = tB06Repository.findById(nope.getId()); if
	 * (px.isPresent()) { final List<TB06Model> pxList = new ArrayList<>();
	 * px.get().forEach(p -> pxList.add(new TB06Model(p.getId(), p.getNoDahak(),
	 * p.getTqlSITB(), p.getUmur(), p.getDirujuk())));
	 * 
	 * ResponseEntity<TB06> ok = ResponseEntity.of(px); String messageOk = "Ok";
	 * Metadata metadata = new Metadata(ok.getStatusCodeValue(), messageOk);
	 * ResponseX<TB6Model, Metadata> responseX = new ResponseX<>(new
	 * TB6Model(pxList), metadata); return ResponseEntity.ok(responseX); } else {
	 * final String msg = "ID Tidak ada"; throw new
	 * CustomException(HttpStatus.NOT_FOUND.value(), msg, HttpStatus.NOT_FOUND); } }
	 */
	@GetMapping("/TB06id")
	ResponseEntity<TB06> getById(@PathVariable long id) {
		Optional<TB06> tb06 = tB06Repository.findById(id);
		if (tb06.isPresent()) {
			return new ResponseEntity<>(tb06.get(), HttpStatus.OK);
		} else {
			final String msg = "Data tidak ada";
			throw new CustomException(HttpStatus.BAD_REQUEST.value(), msg, HttpStatus.BAD_REQUEST);
		}

	}

	@GetMapping("/TB6")
	ResponseEntity<ResponseX<TB06, Metadata>> getTB06(@RequestBody TB06 tB06) {
		TB06 regSave;
		if (tB06Repository.findById(tB06.getId()).isPresent()) {
			final String msg = "Data Sudah Di Input ...!";
			// regSave = tB06Repository.findById(tB06.getId());
			// return new ResponseEntity<>(tb06.get(), HttpStatus.OK);
			throw new CustomException(HttpStatus.BAD_REQUEST.value(), msg, HttpStatus.BAD_REQUEST);
		} else {
			try {
				regSave = tB06Repository.save(tB06);
			} catch (IllegalArgumentException e) {
				final String msg = "Payload Tidak Valid ...";
				throw new CustomException(HttpStatus.BAD_REQUEST.value(), msg, HttpStatus.BAD_REQUEST);
			}
		}

		final String messageOk = "Ok";
		Metadata metadata = new Metadata(HttpStatus.OK.value(), messageOk);
		ResponseX<TB06, Metadata> responseX = new ResponseX<>(regSave, metadata);
		return ResponseEntity.ok(responseX);

	}

	@PostMapping("/NewTB06")
	ResponseEntity<ResponseX<TB06, Metadata>> addTB06(@RequestBody TB06 tB06) {
		TB06 regSave;
		if (tB06Repository.findById(tB06.getId()).isPresent()) {
			final String msg = "Data Sudah Di Input ...!";
			throw new CustomException(HttpStatus.BAD_REQUEST.value(), msg, HttpStatus.BAD_REQUEST);
		} else {
			try {
				regSave = tB06Repository.save(tB06);
			} catch (IllegalArgumentException e) {
				final String msg = "Payload Tidak Valid ...";
				throw new CustomException(HttpStatus.BAD_REQUEST.value(), msg, HttpStatus.BAD_REQUEST);
			}
		}

		final String messageOk = "Ok";
		Metadata metadata = new Metadata(HttpStatus.OK.value(), messageOk);
		ResponseX<TB06, Metadata> responseX = new ResponseX<>(regSave, metadata);
		return ResponseEntity.ok(responseX);

	}

	@PostMapping("/NewTB03")
	ResponseEntity<ResponseX<TB03, Metadata>> addTB03(@RequestBody TB03 tB03) {
		TB03 regSave;
		if (tB03Repository.findById(tB03.getId()).isPresent()) {
			final String msg = "Data Sudah Di Input ...!";
			throw new CustomException(HttpStatus.BAD_REQUEST.value(), msg, HttpStatus.BAD_REQUEST);
		} else {
			try {
				regSave = tB03Repository.save(tB03);
			} catch (IllegalArgumentException e) {
				final String msg = "Payload Tidak Valid ...";
				throw new CustomException(HttpStatus.BAD_REQUEST.value(), msg, HttpStatus.BAD_REQUEST);
			}
		}

		final String messageOk = "Ok";
		Metadata metadata = new Metadata(HttpStatus.OK.value(), messageOk);
		ResponseX<TB03, Metadata> responseX = new ResponseX<>(regSave, metadata);
		return ResponseEntity.ok(responseX);

	}

	@PutMapping("/UpdateTB06")
	ResponseEntity<EntityModel<TB06>> updateTB06(@RequestParam(name = "id") Long id, @RequestBody TB06 tb06)
			throws URISyntaxException {

		TB06 tb06Update = tB06Repository.findById(id).map(tb6 -> {
			tb6.setNodahak(tb06.getNodahak());
			tb6.setTglsitb(tb06.getTglsitb());
			tb6.setUmur(tb06.getUmur());
			tb6.setDirujuk(tb06.getDirujuk());
			tb6.setLokasiAnatomiPenyakit(tb06.getLokasiAnatomiPenyakit());
			tb6.setTotalSkoringTBAnak(tb06.getTotalSkoringTBAnak());
			tb6.setHasilPemeriksaanFotoToraks(tb06.getHasilPemeriksaanFotoToraks());
			tb6.setStatusHIV(tb06.getStatusHIV());
			tb6.setRiwayatDM(tb06.getRiwayatDM());
			tb6.setTglPengambilanA(tb06.getTglPengambilanA());
			tb6.setTglPengambilanB(tb06.getTglPengambilanB());
			tb6.setTglPengambilanC(tb06.getTglPengambilanC());
			tb6.setMikroskopisTgl(tb06.getMikroskopisTgl());
			tb6.setMikroskopisHA(tb06.getMikroskopisHA());
			tb6.setMikroskopisHB(tb06.getMikroskopisHB());
			tb6.setMikroskopisHC(tb06.getMikroskopisHC());
			tb6.setXpertMtbRifTgl(tb06.getXpertMtbRifTgl());
			tb6.setXpertMtbRifHasil(tb06.getXpertMtbRifHasil());
			tb6.setBiakanTgl(tb06.getBiakanTgl());
			tb6.setBiakanHasil(tb06.getBiakanHasil());
			tb6.setNoRegLabTb04(tb06.getNoRegLabTb04());
			tb6.setTindakLanjutPengobatanTgl(tb06.getTindakLanjutPengobatanTgl());
			tb6.setTindakLanjutPengobatanDirujuk(tb06.getTindakLanjutPengobatanDirujuk());

			return tB06Repository.save(tb6);
		}).get();

		EntityModel<TB06> resource = EntityModel.of(tb06Update,
				linkTo(methodOn(RegNewController.class).getTB06(tb06Update.getId())).withSelfRel());

		return ResponseEntity.created(resource.getRequiredLink(IanaLinkRelations.SELF).toUri()).body(resource);
	}

	@PutMapping("/UpdateTB03")
	ResponseEntity<EntityModel<TB03>> updateTB03(@RequestParam(name = "id") Long id, @RequestBody TB03 tb03)
			throws URISyntaxException {

		TB03 tb03Update = tB03Repository.findById(id).map(tb3 -> {
			/*
			 * tb3.setIdtb03(tb03.getIdtb03()); tb3.setKdPasien(tb03.getKdPasien());
			 * tb3.setNik(tb03.getNik()); tb3.setJenisKelamin(tb03.getJenisKelamin());
			 * tb3.setAlamatLengkap(tb03.getAlamatLengkap());
			 */
			tb3.setIdPropinsiFaskes(tb03.getIdPropinsiFaskes());
			tb3.setKdKabupatenFaskes(tb03.getKdKabupatenFaskes());
			tb3.setIdPropinsiPasien(tb03.getIdPropinsiPasien());
			tb3.setKdKabupatenPasien(tb03.getKdKabupatenPasien());
			tb3.setKdFasyankes(tb03.getKdFasyankes());
			tb3.setKodeIcdX(tb03.getKodeIcdX());
			tb3.setTipeDiagnosa(tb03.getTipeDiagnosa());
			tb3.setKlasifikasiLokasiAnatomi(tb03.getKlasifikasiLokasiAnatomi());
			tb3.setKlasifikasiRiwayatPengobatan(tb03.getKlasifikasiRiwayatPengobatan());
			tb3.setTanggalMulaiPengobatan(tb03.getTanggalMulaiPengobatan());
			tb3.setPanduanObat(tb03.getPanduanObat());
			tb3.setSebelumPengobatanHasilMikroskopis(tb03.getSebelumPengobatanHasilMikroskopis());
			tb3.setSebelumPengobatanHasilTesCepat(tb03.getSebelumPengobatanHasilTesCepat());
			tb3.setSebelumPengobatanHasilBiakan(tb03.getSebelumPengobatanHasilBiakan());
			tb3.setHasilMikroskopisBulan2(tb03.getHasilMikroskopisBulan2());
			tb3.setHasilMikroskopisBulan3(tb03.getHasilMikroskopisBulan3());
			tb3.setHasilMikroskopisBulan5(tb03.getHasilMikroskopisBulan5());
			tb3.setAkhirPengobatanHasilMikroskopis(tb03.getAkhirPengobatanHasilMikroskopis());
			tb3.setTanggalHasilAkhirPengobatan(tb03.getTanggalHasilAkhirPengobatan());
			tb3.setHasilAkhirPengobatan(tb03.getHasilAkhirPengobatan());
			tb3.setFotoToraks(tb03.getFotoToraks());

			return tB03Repository.save(tb3);
		}).get();

		EntityModel<TB03> resource = EntityModel.of(tb03Update,
				linkTo(methodOn(RegNewController.class).getTB03(tb03Update.getId())).withSelfRel());

		return ResponseEntity.created(resource.getRequiredLink(IanaLinkRelations.SELF).toUri()).body(resource);
	}

	@DeleteMapping("/DeleteTB06")
	void deleteTB06(@RequestParam(name = "id") Long id) {
		tB06Repository.deleteById(id);
		System.out.println("delete record TB06 ....");
	}

	@DeleteMapping("/DeleteTB03")
	void deleteTB03(@RequestParam(name = "id") Long id) {
		tB03Repository.deleteById(id);
		System.out.println("delete record TB03 ....");
	}

	@DeleteMapping("/DeleteNonUSGXRayCT")
	void deleteNonUSGXRayCT(@RequestParam(name = "idrad") Long idrad, @RequestParam(name = "jenisid") Long jenisid) {
		nonUSGXRayCTRepository.deleteByIdradAndJenisid(idrad, jenisid);
		System.out.println("delete record NonUSGXRayCT ....");
	}

	/*@GetMapping("/ERMPengkajianAwalIGDTriage/{id}")
	EntityModel<ERMIGDPengkajianAwalTriage> eRMIGDPengkajianAwalIGDTRiageById(@PathVariable Long id) {
		ERMIGDPengkajianAwalTriage ina = eRMIGDPengkajianAwalTriageRepository.findById(id)
				.orElseThrow(() -> new PxInapNotFound(id));
		return EntityModel.of(ina,
				linkTo(methodOn(RegNewController.class).eRMIGDPengkajianAwalIGDTRiageById(id)).withSelfRel());
	}*/
	
	@GetMapping("/ERMPengkajianAwalIGDTriage/{id}")
	ResponseEntity<EntityModel<ERMIGDPengkajianAwalTriage>> eRMIGDPengkajianAwalIGDTRiageById(@PathVariable Long id) {

	    return eRMIGDPengkajianAwalTriageRepository.findById(id)
	        .map(ina -> ResponseEntity.ok(
	            EntityModel.of(ina,
	                linkTo(methodOn(RegNewController.class)
	                    .eRMIGDPengkajianAwalIGDTRiageById(id)).withSelfRel())))
	        .orElseGet(() -> {
	            ERMIGDPengkajianAwalTriage empty = new ERMIGDPengkajianAwalTriage();
	            empty.setId(id); // field lain biarkan null
	            return ResponseEntity.ok(
	                EntityModel.of(empty,
	                    linkTo(methodOn(RegNewController.class)
	                        .eRMIGDPengkajianAwalIGDTRiageById(id)).withSelfRel()));
	        });
	}


	/*@GetMapping("/ERMPengkajianAwalIGDKep/{id}")
	EntityModel<ERMIGDPengkajianAwalKep> eRMIGDPengkajianAwalIGDKepById(@PathVariable Long id) {
		ERMIGDPengkajianAwalKep ina = eRMIGDPengkajianAwalKepRepository.findById(id)
				.orElseThrow(() -> new PxInapNotFound(id));
		return EntityModel.of(ina,
				linkTo(methodOn(RegNewController.class).eRMIGDPengkajianAwalIGDKepById(id)).withSelfRel());
	}*/
	
	@GetMapping("/ERMPengkajianAwalIGDKep/{id}")
	ResponseEntity<EntityModel<ERMIGDPengkajianAwalKep>> eRMIGDPengkajianAwalIGDKepById(@PathVariable Long id) {

	    return eRMIGDPengkajianAwalKepRepository.findById(id)
	        .map(kep -> ResponseEntity.ok(
	            EntityModel.of(kep,
	                linkTo(methodOn(RegNewController.class)
	                    .eRMIGDPengkajianAwalIGDKepById(id)).withSelfRel())))
	        .orElseGet(() -> {
	            ERMIGDPengkajianAwalKep empty = new ERMIGDPengkajianAwalKep();
	            empty.setId(id); // sisanya biarkan null
	            return ResponseEntity.ok(
	                EntityModel.of(empty,
	                    linkTo(methodOn(RegNewController.class)
	                        .eRMIGDPengkajianAwalIGDKepById(id)).withSelfRel()));
	        });
	}


	/*@GetMapping("/ERMPengkajianAwalIGDPsikoEkoNut/{id}")
	EntityModel<ERMIGDPengkajianAwalPsikoEkoNut> eRMIGDPengkajianAwalIGDPsikoEkoNutById(@PathVariable Long id) {
		ERMIGDPengkajianAwalPsikoEkoNut ina = eRMIGDPengkajianAwalPsikoEkoNutRepository.findById(id)
				.orElseThrow(() -> new PxInapNotFound(id));
		return EntityModel.of(ina,
				linkTo(methodOn(RegNewController.class).eRMIGDPengkajianAwalIGDPsikoEkoNutById(id)).withSelfRel());
	}*/
	
	@GetMapping("/ERMPengkajianAwalIGDPsikoEkoNut/{id}")
	ResponseEntity<EntityModel<ERMIGDPengkajianAwalPsikoEkoNut>>
	eRMIGDPengkajianAwalIGDPsikoEkoNutById(@PathVariable Long id) {

	    return eRMIGDPengkajianAwalPsikoEkoNutRepository.findById(id)
	        .map(ent -> ResponseEntity.ok(
	            EntityModel.of(ent,
	                linkTo(methodOn(RegNewController.class)
	                    .eRMIGDPengkajianAwalIGDPsikoEkoNutById(id)).withSelfRel())))
	        .orElseGet(() -> {
	            // buat model kosong: semua field null; id boleh diisi dari path kalau kamu mau
	            ERMIGDPengkajianAwalPsikoEkoNut empty = new ERMIGDPengkajianAwalPsikoEkoNut();
	            empty.setId(id); // opsional, biar "id" muncul; field lain biarkan null
	            return ResponseEntity.ok(
	                EntityModel.of(empty,
	                    linkTo(methodOn(RegNewController.class)
	                        .eRMIGDPengkajianAwalIGDPsikoEkoNutById(id)).withSelfRel()));
	        });
	}


	/*@GetMapping("/ERMPengkajianAwalIGDNyeri/{id}")
	EntityModel<ERMIGDPengkajianAwalNyeri> eRMIGDPengkajianAwalIGDNyeriById(@PathVariable Long id) {
		ERMIGDPengkajianAwalNyeri ina = eRMIGDPengkajianAwalNyeriRepository.findById(id)
				.orElseThrow(() -> new PxInapNotFound(id));
		return EntityModel.of(ina,
				linkTo(methodOn(RegNewController.class).eRMIGDPengkajianAwalIGDPsikoEkoNutById(id)).withSelfRel());
	} */
	
	@GetMapping("/ERMPengkajianAwalIGDNyeri/{id}")
	EntityModel<ERMIGDPengkajianAwalNyeri> eRMIGDPengkajianAwalIGDNyeriById(@PathVariable Long id) {

	    // JANGAN orElseThrow → buat objek kosong saat tidak ada
	    ERMIGDPengkajianAwalNyeri nyeri = eRMIGDPengkajianAwalNyeriRepository.findById(id)
	        .orElseGet(() -> {
	            ERMIGDPengkajianAwalNyeri empty = new ERMIGDPengkajianAwalNyeri();
	            empty.setId(id);           // opsional: supaya "id" tetap tampil
	            return empty;              // field lain biar null
	        });

	    // perbaiki self-link: arahkan ke method Nyeri (bukan PsikoEkoNut)
	    return EntityModel.of(
	        nyeri,
	        linkTo(methodOn(RegNewController.class)
	            .eRMIGDPengkajianAwalIGDNyeriById(id)).withSelfRel()
	    );
	}

	/*
	@GetMapping("/ERMPengkajianAwalIGDFungJatuhPopulasiEdukasi/{id}")
	EntityModel<ERMIGDPengkajianAwalFungJatuhPopulasiEdukasi> eRMIGDPengkajianAwalIGDFungJatuhPopulasiEdukasiById(
			@PathVariable Long id) {
		ERMIGDPengkajianAwalFungJatuhPopulasiEdukasi ina = eRMIGDPengkajianAwalFungJatuhPopulasiEdukasiRepository
				.findById(id).orElseThrow(() -> new PxInapNotFound(id));
		return EntityModel.of(ina,
				linkTo(methodOn(RegNewController.class).eRMIGDPengkajianAwalIGDFungJatuhPopulasiEdukasiById(id))
						.withSelfRel());
	}*/
	
	@GetMapping("/ERMPengkajianAwalIGDFungJatuhPopulasiEdukasi/{id}")
	EntityModel<ERMIGDPengkajianAwalFungJatuhPopulasiEdukasi>
	eRMIGDPengkajianAwalIGDFungJatuhPopulasiEdukasiById(@PathVariable Long id) {

	    ERMIGDPengkajianAwalFungJatuhPopulasiEdukasi model =
	        eRMIGDPengkajianAwalFungJatuhPopulasiEdukasiRepository.findById(id)
	            .orElseGet(() -> {
	                ERMIGDPengkajianAwalFungJatuhPopulasiEdukasi empty =
	                    new ERMIGDPengkajianAwalFungJatuhPopulasiEdukasi();
	                empty.setId(id); // opsional: tampilkan id; field lain biarkan null
	                return empty;
	            });

	    return EntityModel.of(
	        model,
	        linkTo(methodOn(RegNewController.class)
	            .eRMIGDPengkajianAwalIGDFungJatuhPopulasiEdukasiById(id)).withSelfRel()
	    );
	}


	/*@GetMapping("/ERMPengkajianAwalIGDMedis/{id}")
	EntityModel<ERMIGDPengkajianAwalMedis> eRMIGDPengkajianAwalIGDMedisById(@PathVariable Long id) {
		ERMIGDPengkajianAwalMedis ina = eRMIGDPengkajianAwalMedisRepository.findById(id)
				.orElseThrow(() -> new PxInapNotFound(id));
		return EntityModel.of(ina,
				linkTo(methodOn(RegNewController.class).eRMIGDPengkajianAwalIGDMedisById(id)).withSelfRel());
	}*/
	
	@GetMapping("/ERMPengkajianAwalIGDMedis/{id}")
	EntityModel<ERMIGDPengkajianAwalMedis> eRMIGDPengkajianAwalIGDMedisById(@PathVariable Long id) {

	    ERMIGDPengkajianAwalMedis body = eRMIGDPengkajianAwalMedisRepository.findById(id)
	        .orElseGet(() -> {
	            ERMIGDPengkajianAwalMedis empty = new ERMIGDPengkajianAwalMedis();
	            empty.setId(id);           // <-- id tetap tampil; field lain biarkan null
	            return empty;
	        });

	    return EntityModel.of(
	        body,
	        linkTo(methodOn(RegNewController.class)
	            .eRMIGDPengkajianAwalIGDMedisById(id)).withSelfRel()
	    );
	}

	/*@GetMapping("/ERMPengkajianAwalIGDAnalisaNrencana/{id}")
	EntityModel<ERMIGDPengkajianAwalAnalisaNRencana> eRMIGDPengkajianAwalIGDAnalisaNRencanaById(@PathVariable Long id) {
		ERMIGDPengkajianAwalAnalisaNRencana ina = eRMIGDPengkajianAwalAnalisaNRencanaRepository.findById(id)
				.orElseThrow(() -> new PxInapNotFound(id));
		return EntityModel.of(ina,
				linkTo(methodOn(RegNewController.class).eRMIGDPengkajianAwalIGDAnalisaNRencanaById(id)).withSelfRel());
	}*/
	
	@GetMapping("/ERMPengkajianAwalIGDAnalisaNrencana/{id}")
	EntityModel<ERMIGDPengkajianAwalAnalisaNRencana>
	eRMIGDPengkajianAwalIGDAnalisaNRencanaById(@PathVariable Long id) {

	    ERMIGDPengkajianAwalAnalisaNRencana body =
	        eRMIGDPengkajianAwalAnalisaNRencanaRepository.findById(id)
	            .orElseGet(() -> {
	                ERMIGDPengkajianAwalAnalisaNRencana empty = new ERMIGDPengkajianAwalAnalisaNRencana();
	                empty.setId(id); // kalau mau id tetap tampil; field lain biarkan null
	                return empty;
	            });

	    return EntityModel.of(
	        body,
	        linkTo(methodOn(RegNewController.class)
	            .eRMIGDPengkajianAwalIGDAnalisaNRencanaById(id)).withSelfRel()
	    );
	}


	/*@GetMapping("/ERMPengkajianAwalIGDAnalisaNRencanaKep")
	public ResponseEntity<List<ERMIGDPengkajianAwalAnalisaNRencanaKep>> ERMIGDPengkajianAwalAnalisaNRencanaKepByno(
			@RequestParam(name = "no") Long no) {
		return new ResponseEntity<List<ERMIGDPengkajianAwalAnalisaNRencanaKep>>(
				eRMIGDPengkajianAwalAnalisaNRencanaKepRepository.findByNo(no), HttpStatus.OK);
	}*/
	
	@GetMapping("/ERMPengkajianAwalIGDAnalisaNRencanaKep")
	public ResponseEntity<List<ERMIGDPengkajianAwalAnalisaNRencanaKep>>
	ERMIGDPengkajianAwalAnalisaNRencanaKepByno(@RequestParam("no") Long no) {

	    List<ERMIGDPengkajianAwalAnalisaNRencanaKep> data =
	        eRMIGDPengkajianAwalAnalisaNRencanaKepRepository.findByNo(no);

	    if (data == null || data.isEmpty()) {
	        return ResponseEntity.ok().build();   // 200, body null (kosong)
	    }
	    return ResponseEntity.ok(data);           // 200, body = list
	}


	/*@GetMapping("/ERMPengkajianAwalIGDDischargePlanning/{id}")
	EntityModel<ERMIGDPengkajianAwalDischargePlanning> eRMIGDPengkajianAwalIGDDischargePlanningById(
			@PathVariable Long id) {
		ERMIGDPengkajianAwalDischargePlanning ina = eRMIGDPengkajianAwalDischargePlanningRepository.findById(id)
				.orElseThrow(() -> new PxInapNotFound(id));
		return EntityModel.of(ina,
				linkTo(methodOn(RegNewController.class).eRMIGDPengkajianAwalIGDDischargePlanningById(id))
						.withSelfRel());
	}*/
	
	@GetMapping("/ERMPengkajianAwalIGDDischargePlanning/{id}")
	EntityModel<ERMIGDPengkajianAwalDischargePlanning>
	eRMIGDPengkajianAwalIGDDischargePlanningById(@PathVariable Long id) {

	    ERMIGDPengkajianAwalDischargePlanning body =
	        eRMIGDPengkajianAwalDischargePlanningRepository.findById(id)
	            .orElseGet(() -> {
	                ERMIGDPengkajianAwalDischargePlanning empty =
	                    new ERMIGDPengkajianAwalDischargePlanning();
	                empty.setId(id); // opsional: biar "id" tetap muncul; field lain biarkan null
	                return empty;
	            });

	    return EntityModel.of(
	        body,
	        linkTo(methodOn(RegNewController.class)
	            .eRMIGDPengkajianAwalIGDDischargePlanningById(id)).withSelfRel()
	    );
	}


	@GetMapping("/ERMIGDObservasi/")
	public ResponseEntity<List<ERMIGDObservasi>> ERMIGDObservasiByno(@RequestParam(name = "no") Long no) {
		return new ResponseEntity<List<ERMIGDObservasi>>(eRMIGDObservasiRepository.findByNo(no), HttpStatus.OK);
	}

	@GetMapping("/ERMIGDObservasiCPPT/")
	public ResponseEntity<List<ERMIGDObservasiCPPT>> ERMIGDObservasiCPPTByno(@RequestParam(name = "no") Long no) {
		return new ResponseEntity<List<ERMIGDObservasiCPPT>>(eRMIGDObservasiCPPTRepository.findByNo(no), HttpStatus.OK);
	}

	@GetMapping("/ERMSkriningCovid/{id}")
	EntityModel<ERMIGDSkriningCovid> eRMIGDSkriningCovidById(@PathVariable Long id) {
	    ERMIGDSkriningCovid data = eRMIGDSkriningCovidRepository.findById(id)
	        .orElseGet(() -> {
	            ERMIGDSkriningCovid kosong = new ERMIGDSkriningCovid();
	            // jika ingin id tetap muncul di body:
	            try { kosong.setId(id); } catch (Exception ignore) {}
	            return kosong;
	        });

	    return EntityModel.of(
	        data,
	        linkTo(methodOn(RegNewController.class).eRMIGDSkriningCovidById(id)).withSelfRel()
	    );
	}
	
	@PostMapping("/NewERMSkriningCovid")
	ResponseEntity<ResponseX<ERMIGDSkriningCovidPost, Metadata>> addNewERMIGDSkriningCovidPost(@RequestBody ERMIGDSkriningCovidPost eRMIGDSkriningCovidPost) {
		ERMIGDSkriningCovidPost regSave;
		if (eRMIGDSkriningCovidPost.getId() == null)  {
			String msg = "ID = IDReg(Px) Tidak Boleh Kosong Atau PX Sudah Pulang";
			System.out.println(msg);
			throw new CustomException(HttpStatus.UNPROCESSABLE_ENTITY.value(), msg, HttpStatus.UNPROCESSABLE_ENTITY);
		}
		if (eRMIGDSkriningCovidPost.getIdDokter() == null)  {
			String msg = "ID Dokter Tidak Boleh Kosong";
			System.out.println(msg);
			throw new CustomException(HttpStatus.UNPROCESSABLE_ENTITY.value(), msg, HttpStatus.UNPROCESSABLE_ENTITY);
		}
		Optional<DokterERM> cek = dokterERMRepository.findById(eRMIGDSkriningCovidPost.getIdDokter());
		if (cek.isEmpty()) {
			String msg = "ID (Kode) Dokter tidak diketahui, silahkan Hub EDP..!!";
			System.out.println(msg);
			throw new CustomException(HttpStatus.UNPROCESSABLE_ENTITY.value(), msg, HttpStatus.UNPROCESSABLE_ENTITY);
		}
		if (eRMIGDSkriningCovidPostRepository.findById(eRMIGDSkriningCovidPost.getId()).isPresent()) {
			final String msg = "Data Sudah Di Input ...!";
			throw new CustomException(HttpStatus.BAD_REQUEST.value(), msg, HttpStatus.BAD_REQUEST);
		} else {
			try {
				regSave = eRMIGDSkriningCovidPostRepository.save(eRMIGDSkriningCovidPost);
			} catch (IllegalArgumentException e) {
				final String msg = "Payload Tidak Valid ...";
				throw new CustomException(HttpStatus.BAD_REQUEST.value(), msg, HttpStatus.BAD_REQUEST);
			}
		}

		final String messageOk = "Ok";
		Metadata metadata = new Metadata(HttpStatus.OK.value(), messageOk);
		ResponseX<ERMIGDSkriningCovidPost, Metadata> responseX = new ResponseX<>(regSave, metadata);
		return ResponseEntity.ok(responseX);
	}	
	
	@PutMapping("/NewERMSkriningCovid")
	ResponseEntity<EntityModel<ERMIGDSkriningCovidPost>> updateERMSkriningCovid(@RequestParam(name = "id") Long id, @RequestBody ERMIGDSkriningCovidPost eRMIGDSkriningCovidPost)
			throws URISyntaxException 
	{	
		if (eRMIGDSkriningCovidPostRepository.findById(id).isPresent()) {
			
			//Optional<ERMIGDSkriningCovidPost> cek = eRMIGDSkriningCovidPostRepository.findById(id);
			ERMIGDSkriningCovidPost eRMIGDSkriningCovidPostUpdate = eRMIGDSkriningCovidPostRepository.findById(id).map(sPLb -> {
				sPLb.setId(eRMIGDSkriningCovidPost.getId());
				sPLb.setTanggal(eRMIGDSkriningCovidPost.getTanggal());
				sPLb.setIdDokter(eRMIGDSkriningCovidPost.getIdDokter());
				sPLb.setTandaNGejala(eRMIGDSkriningCovidPost.getTandaNGejala());
				sPLb.setRiwayat(eRMIGDSkriningCovidPost.getRiwayat());
				sPLb.setDemam(eRMIGDSkriningCovidPost.getDemam());
				sPLb.setUsia(eRMIGDSkriningCovidPost.getUsia());
				sPLb.setKel(eRMIGDSkriningCovidPost.getKel());
				sPLb.setSuhu(eRMIGDSkriningCovidPost.getSuhu());
				sPLb.setGejala(eRMIGDSkriningCovidPost.getGejala());
				sPLb.setRatio(eRMIGDSkriningCovidPost.getRatio());
				
				return eRMIGDSkriningCovidPostRepository.save(sPLb);
			}).get();

			EntityModel<ERMIGDSkriningCovidPost> resource = EntityModel.of(eRMIGDSkriningCovidPostUpdate,
					linkTo(methodOn(RegNewController.class).eRMIGDSkriningCovidById(eRMIGDSkriningCovidPostUpdate.getId())).withSelfRel());

			return ResponseEntity.created(resource.getRequiredLink(IanaLinkRelations.SELF).toUri()).body(resource);
		
		} else {
			try {
				final String msg = "ID Pasien Tidak ada atau sudah pulang...!";
				throw new CustomException(HttpStatus.BAD_REQUEST.value(), msg, HttpStatus.BAD_REQUEST);			
					
				} catch (IllegalArgumentException e) {
				final String msg = "Payload Tidak Valid ...";
				throw new CustomException(HttpStatus.BAD_REQUEST.value(), msg, HttpStatus.BAD_REQUEST);
			}
		}	
	}
	
	@GetMapping("/ERMSkriningTB/{id}")
	EntityModel<ERMIGDSkriningTB> eRMIGDSkriningTBById(@PathVariable Long id) {
	    ERMIGDSkriningTB ina = eRMIGDSkriningTBRepository.findById(id)
	        .orElseGet(() -> {
	            ERMIGDSkriningTB e = new ERMIGDSkriningTB();
	            // opsional: tampilkan id meski data kosong
	            try { e.setId(id); } catch (Exception ignore) {}
	            return e; // semua field lain null
	        });

	    return EntityModel.of(
	        ina,
	        linkTo(methodOn(RegNewController.class).eRMIGDSkriningTBById(id)).withSelfRel()
	    );
	}
	
	@PostMapping("/NewERMSkriningTB")
	ResponseEntity<ResponseX<ERMIGDSkriningTBPost, Metadata>> addNewERMIGDSkriningTBPost(@RequestBody ERMIGDSkriningTBPost eRMIGDSkriningTBPost) {
		ERMIGDSkriningTBPost regSave;
		if (eRMIGDSkriningTBPost.getId() == null)  {
			String msg = "(TB) ID = IDReg(Px) Tidak Boleh Kosong Atau PX Sudah Pulang";
			System.out.println(msg);
			throw new CustomException(HttpStatus.UNPROCESSABLE_ENTITY.value(), msg, HttpStatus.UNPROCESSABLE_ENTITY);
		}
		if (eRMIGDSkriningTBPost.getIdDokter() == null)  {
			String msg = "ID Dokter Tidak Boleh Kosong";
			System.out.println(msg);
			throw new CustomException(HttpStatus.UNPROCESSABLE_ENTITY.value(), msg, HttpStatus.UNPROCESSABLE_ENTITY);
		}
		Optional<DokterERM> cek = dokterERMRepository.findById(eRMIGDSkriningTBPost.getIdDokter());
		if (cek.isEmpty()) {
			String msg = "ID (Kode) Dokter tidak diketahui, silahkan Hub EDP..!!";
			System.out.println(msg);
			throw new CustomException(HttpStatus.UNPROCESSABLE_ENTITY.value(), msg, HttpStatus.UNPROCESSABLE_ENTITY);
		}
		//if (eRMIGDSkriningTBRepository.findById(eRMIGDSkriningTBPost.getId()).isPresent()) {
		//	final String msg = "Data Sudah Di Input ...!";
		//	throw new CustomException(HttpStatus.BAD_REQUEST.value(), msg, HttpStatus.BAD_REQUEST);
		//} 
		else {
			try {
				regSave = eRMIGDSkriningTBPostRepository.save(eRMIGDSkriningTBPost);
			} catch (IllegalArgumentException e) {
				final String msg = "Payload Tidak Valid ...";
				throw new CustomException(HttpStatus.BAD_REQUEST.value(), msg, HttpStatus.BAD_REQUEST);
			}
		}

		final String messageOk = "Ok";
		Metadata metadata = new Metadata(HttpStatus.OK.value(), messageOk);
		ResponseX<ERMIGDSkriningTBPost, Metadata> responseX = new ResponseX<>(regSave, metadata);
		return ResponseEntity.ok(responseX);
	}	
	
	@PutMapping("/ERMSkriningTB")
	ResponseEntity<EntityModel<ERMIGDSkriningTBPost>> updateERMSkriningTB(@RequestParam(name = "id") Long id, @RequestBody ERMIGDSkriningTBPost eRMIGDSkriningTBPost)
			throws URISyntaxException 
	{	
		if (eRMIGDSkriningTBPostRepository.findById(id).isPresent()) {
			
			//Optional<ERMIGDSkriningCovidPost> cek = eRMIGDSkriningCovidPostRepository.findById(id);
			ERMIGDSkriningTBPost eRMIGDSkriningTBPostUpdate = eRMIGDSkriningTBPostRepository.findById(id).map(sPLb -> {
				sPLb.setId(eRMIGDSkriningTBPost.getId());
				sPLb.setTanggal(eRMIGDSkriningTBPost.getTanggal());
				sPLb.setIdDokter(eRMIGDSkriningTBPost.getIdDokter());
				sPLb.setBatuk(eRMIGDSkriningTBPost.getBatuk());
				sPLb.setRontgen(eRMIGDSkriningTBPost.getRontgen());
				sPLb.setKontak(eRMIGDSkriningTBPost.getKontak());
				sPLb.setKet(eRMIGDSkriningTBPost.getKet());
				sPLb.setRi(eRMIGDSkriningTBPost.getRi());
				sPLb.setDm(eRMIGDSkriningTBPost.getDm());
				sPLb.setHiv(eRMIGDSkriningTBPost.getHiv());
		//		sPLb.setGejala(eRMIGDSkriningTBPost.getGejala());
				
				return eRMIGDSkriningTBPostRepository.save(sPLb);
			}).get();

			EntityModel<ERMIGDSkriningTBPost> resource = EntityModel.of(eRMIGDSkriningTBPostUpdate,
					linkTo(methodOn(RegNewController.class).eRMIGDSkriningTBById(eRMIGDSkriningTBPostUpdate.getId())).withSelfRel());

			return ResponseEntity.created(resource.getRequiredLink(IanaLinkRelations.SELF).toUri()).body(resource);
		
		} else {
			try {
				final String msg = "(TB) ID Pasien Inap Tidak ada Atau PX Sudah Pulang...!";
				throw new CustomException(HttpStatus.BAD_REQUEST.value(), msg, HttpStatus.BAD_REQUEST);			
					
				} catch (IllegalArgumentException e) {
				final String msg = "Payload Tidak Valid ...";
				throw new CustomException(HttpStatus.BAD_REQUEST.value(), msg, HttpStatus.BAD_REQUEST);
			}
		}	
	}
	
	@GetMapping("/ERMSkriningTBKet")
	List<ERMIGDSkriningTBKet> ERMIGDSkriningTBKet() {
		return eRMIGDSkriningTBKetRepository.findAll();
	}
	
	@GetMapping("/AntrianKORJ")
	List<AntrianKORJ> AntrianKORJ() {
		return antrianKORJRepository.findAll();
	}
	
/*	@GetMapping("/ERMLabHasilV/")
	public ResponseEntity<List<LabHasilBatas>> labHasilBataslByIDLab(@RequestParam(name = "idlab") Long idlab) {
		return new ResponseEntity<List<LabHasilBatas>>(labHasilBatasRepository.findByidlab(idlab), HttpStatus.OK);
	}
	
	@GetMapping("/ERMLabHasilB/")
	public ResponseEntity<List<LabHasilBatasSP>> labHasilBatasSPByIDLab(@RequestParam(name = "idlab") Long idlab) {
		return new ResponseEntity<List<LabHasilBatasSP>>(labHasilBatasSPRepository.findByidlab(idlab), HttpStatus.OK);
	}	*/
	

	@GetMapping("/ERMPAListRM/")
	List<PAHasilListRM> getLabPAListByRM(@RequestParam(name = "rm") String rm) {
		return pAHasilListRMService.getByrm(rm);
	}
	
	@GetMapping("/ERMPAHasil/")
	List<PAHasil> getPAHasilBypadoc(@RequestParam(name = "padoc") String padoc) {
		return pAHasilService.getBypadoc(padoc);
	}	
	
	@GetMapping("/ERMLabList/")
	List<LabHasilBatasList> getLabListByidreg(@RequestParam(name = "idreg") Long idreg) {
		return labHasilBatasListService.getByidreg(idreg);
	}
	
	@GetMapping("/ERMLabListRM/")
	List<LabHasilBatasListRM> getLabListByRM(@RequestParam(name = "rm") String rm) {
		return labHasilBatasListRMService.getByrm(rm);
	}
	
	@GetMapping("/ERMLabListRMV2/")
	public List<LabListRMModel> getLabHeaderAndDetailByRM(@RequestParam(name = "rm") String rm) {
	    // Ambil semua header berdasarkan RM
	    List<LabHasilBatasListRM> headerList = labHasilBatasListRMService.getByrm(rm);
	    List<LabListRMModel> responseList = new ArrayList<>();

	    for (LabHasilBatasListRM header : headerList) {
	    	LabListRMModel data = new LabListRMModel();
	        data.setId(header.getId());              // ID = idreg
	        data.setTgl(header.getTgl());            // contoh: "19 August 2025"
	        data.setKet(header.getKet());            // "INAP" atau "JALAN"
	        data.setRm(header.getRm());

	        // Ambil detail lab berdasarkan idreg
	        List<LabHasilBatasList> detailList = labHasilBatasListService.getByidreg(header.getId());
	        List<LabListModel> labItems = detailList.stream().map(d -> {
	        	LabListModel item = new LabListModel();
	            item.setIdlab(d.getIdlab());
	            item.setIdreg(d.getIdreg());
	            item.setTlab(d.getTlab());
	            return item;
	        }).collect(Collectors.toList());

	        data.setListLab(labItems);
	        responseList.add(data);
	    }

	    return responseList;
	} 


	@GetMapping("/ERMLabHasil/")
	List<LabHasilBatasSP> getByidlab(@RequestParam(name = "idlab") Long idlab) {
		return labHasilBatasSPService.getByidlab(idlab);
	}
	
	@GetMapping("/ERMLabHasilPX/")
	public ResponseEntity<List<LabHasilBatasSP>> getPXByidlab(@RequestParam(name = "idlab") Long idlab) {
		List<LabHasilBatasPX> cek = labHasilBatasPXRepository.findByidlab(idlab);
		List<LabHasilBatasPXCek> cek1 = labHasilBatasCekRepository.findByidlab(idlab);
	//	return labHasilBatasSPService.getByidlab(idlab);
	//}
	if (cek.isEmpty()) {
			String msg = "ID Laborat = " + idlab + " Tidak ada bisa di cek kembali..!!";
			System.out.println(msg);
			throw new CustomException(HttpStatus.NOT_FOUND.value(), msg, HttpStatus.NOT_FOUND);
		}	
	if (cek1.isEmpty()) {
		String msg = "ID Laborat = " + idlab + " Belum jadi bisa di cek kembali..!!";
		System.out.println(msg);
		throw new CustomException(HttpStatus.NOT_FOUND.value(), msg, HttpStatus.NOT_FOUND);
	} else {
	
	return new ResponseEntity<List<LabHasilBatasSP>>(labHasilBatasSPService.getByidlab(idlab), HttpStatus.OK);
		}
	}
	
	@GetMapping("/ERMLabHasilKultur/")
	List<LabHasilKultur> getByidreg(@RequestParam(name = "idreg") Long idreg) {
		return labHasilKulturService.getByidreg(idreg);
	}		

	@GetMapping("/ListSPLabID/")
	public ResponseEntity<?> SPLabById(@RequestParam(name = "id") Long id) {
	    List<SPLabGet> cek = sPLabListRepository.findByid(id);

	    if (cek == null || cek.isEmpty()) {
	        // 200 dengan body: []
	        return ResponseEntity.ok(Collections.emptyList());
	    }

	    // Data ada → kembalikan list apa adanya (200)
	    return ResponseEntity.ok(cek);
	}

	
	@GetMapping("/ListSPRadID/")
	public ResponseEntity<?> SPRadbById(@RequestParam(name = "id") Long id) {
	    List<SPRadGet> cek = sPRadListRepository.findByid(id);

	    if (cek == null || cek.isEmpty()) {
	        // 200 dengan body: []
	        return ResponseEntity.ok(Collections.emptyList());
	    }
	    
	    return ResponseEntity.ok(cek);
	}
	
	@GetMapping("/NewSPLab/No")
	EntityModel<SPLabGet> getSPLab(@RequestParam Long no) {
	    SPLabGet dik = sPLabGetRepository.findById(no)
	        .orElseGet(() -> {
	            SPLabGet empty = new SPLabGet();
	            // opsional: tampilkan id/no meski data kosong
	            try { 
	                // ganti setId(no) → setNo(no) jika nama field-nya "no"
	                empty.setId(no); 
	            } catch (Exception ignored) {}
	            return empty; // field lainnya biarkan null
	        });

	    return EntityModel.of(
	        dik,
	        linkTo(methodOn(RegNewController.class).getSPLab(no)).withSelfRel()
	    );
	}
	
	@GetMapping("/NewSPRad/No")
	EntityModel<SPRadGet> getSPRad(@RequestParam Long no) {
	    SPRadGet dik = sPRadGetRepository.findById(no)
	        .orElseGet(() -> {
	            SPRadGet empty = new SPRadGet();
	            // opsional: tampilkan id/no meski data kosong
	            try { empty.setId(no); } catch (Exception ignored) {}
	            // atau jika field-nya bernama 'no': try { empty.setNo(no); } catch (Exception ignored) {}
	            return empty; // field lain biarkan null
	        });

	    return EntityModel.of(
	        dik,
	        linkTo(methodOn(RegNewController.class).getSPRad(no)).withSelfRel()
	    );
	}
	
	@PostMapping("/NewSPLab")
	ResponseEntity<ResponseX<SPLab, Metadata>> addNewSPLab(@RequestBody SPLab sPLab) {
		SPLab regSave;
		if (sPLab.getDiagnosa().isBlank() || sPLab.getDiagnosa().isEmpty()) {
			String msg = "Diagnosa SP Lab Tidak Boleh Kosong";
			System.out.println(msg);
			throw new CustomException(HttpStatus.UNPROCESSABLE_ENTITY.value(), msg, HttpStatus.UNPROCESSABLE_ENTITY);
		}
		if (sPLab.getId() == null)  {
			String msg = "ID = IDReg(Px) SP Lab Tidak Boleh Kosong Atau PX Sudah Pulang";
			System.out.println(msg);
		//	System.out.println(sPLab);
			throw new CustomException(HttpStatus.UNPROCESSABLE_ENTITY.value(), msg, HttpStatus.UNPROCESSABLE_ENTITY);
		}
		if (sPLab.getIdDokter() == null)  {
			String msg = "ID = ID Dokter SP Lab Tidak Boleh Kosong";
			System.out.println(msg);
			throw new CustomException(HttpStatus.UNPROCESSABLE_ENTITY.value(), msg, HttpStatus.UNPROCESSABLE_ENTITY);
		}
		Optional<DokterERM> cek = dokterERMRepository.findById(sPLab.getIdDokter());
		if (cek.isEmpty()) {
			String msg = "ID (Kode) Dokter SP Lab tidak diketahui, silahkan Hub EDP..!!";
			System.out.println(msg);
			throw new CustomException(HttpStatus.UNPROCESSABLE_ENTITY.value(), msg, HttpStatus.UNPROCESSABLE_ENTITY);
		}
		if (sPLab.getKelasID() == null)  {
			String msg = "IDKelas SP Lab Tidak Boleh Kosong";
			System.out.println(msg);
			throw new CustomException(HttpStatus.UNPROCESSABLE_ENTITY.value(), msg, HttpStatus.UNPROCESSABLE_ENTITY);
		}		
		if (sPLab.getRoomID() == null) {
			String msg = "IDRoom SP Lab Tidak Boleh Kosong";
			System.out.println(msg);
			throw new CustomException(HttpStatus.UNPROCESSABLE_ENTITY.value(), msg, HttpStatus.UNPROCESSABLE_ENTITY);
		}
		if (sPLab.getFginKre() != null)  {
			if (sPLab.getBb() == null) {
				String msg = "BB SP Lab Tidak Boleh Kosong";
				System.out.println(msg);
				throw new CustomException(HttpStatus.UNPROCESSABLE_ENTITY.value(), msg, HttpStatus.UNPROCESSABLE_ENTITY);
			}
		//	String msg = "ID = ID Dokter SP Lab Tidak Boleh Kosong";
		//	System.out.println(msg);
		//	throw new CustomException(HttpStatus.UNPROCESSABLE_ENTITY.value(), msg, HttpStatus.UNPROCESSABLE_ENTITY);
		}
		if (sPLabRepository.findById(sPLab.getId()).isPresent()) {
			final String msg = "SP Lab Data Sudah Di Input ...!";
			throw new CustomException(HttpStatus.BAD_REQUEST.value(), msg, HttpStatus.BAD_REQUEST);
		} else {
			try {
				regSave = sPLabRepository.save(sPLab);
			} catch (IllegalArgumentException e) {
				final String msg = "Payload Tidak Valid ...";
				throw new CustomException(HttpStatus.BAD_REQUEST.value(), msg, HttpStatus.BAD_REQUEST);
			}
		}

		final String messageOk = "Ok";
		Metadata metadata = new Metadata(HttpStatus.OK.value(), messageOk);
		ResponseX<SPLab, Metadata> responseX = new ResponseX<>(regSave, metadata);
		return ResponseEntity.ok(responseX);
	}
	

	
	@PostMapping("/NewSPRad")
	ResponseEntity<ResponseX<SPRad, Metadata>> addNewSPRad(@RequestBody SPRad sPRad) {
		SPRad regSave;		
		if (sPRad.getDiagnosa().isBlank() || sPRad.getDiagnosa().isEmpty()) {
			String msg = "Diagnosa SP Rad Tidak Boleh Kosong";
			System.out.println(msg);
			throw new CustomException(HttpStatus.UNPROCESSABLE_ENTITY.value(), msg, HttpStatus.UNPROCESSABLE_ENTITY);
		}
		if (sPRad.getId() == null)  {
			String msg = "ID = IDReg(Px) SP Rad Tidak Boleh Kosong Atau PX Sudah Pulang";
			System.out.println(msg);
			throw new CustomException(HttpStatus.UNPROCESSABLE_ENTITY.value(), msg, HttpStatus.UNPROCESSABLE_ENTITY);
		}
		if (sPRad.getIdDokter() == null)  {
			String msg = "ID = ID Dokter SP Rad Tidak Boleh Kosong";
			System.out.println(msg);
			throw new CustomException(HttpStatus.UNPROCESSABLE_ENTITY.value(), msg, HttpStatus.UNPROCESSABLE_ENTITY);
		}
		Optional<DokterERM> cek = dokterERMRepository.findById(sPRad.getIdDokter());
		if (cek.isEmpty()) {
			String msg = "ID (Kode) SP Rad Dokter tidak diketahui, silahkan Hub EDP..!!";
			System.out.println(msg);
			throw new CustomException(HttpStatus.UNPROCESSABLE_ENTITY.value(), msg, HttpStatus.UNPROCESSABLE_ENTITY);
		}
		if (sPRad.getKelasID() == null)  {
			String msg = "IDKelas SP Rad Tidak Boleh Kosong";
			System.out.println(msg);
			throw new CustomException(HttpStatus.UNPROCESSABLE_ENTITY.value(), msg, HttpStatus.UNPROCESSABLE_ENTITY);
		}		
		if (sPRad.getRoomID() == null) {
			String msg = "IDRoom SP Rad Tidak Boleh Kosong";
			System.out.println(msg);
			throw new CustomException(HttpStatus.UNPROCESSABLE_ENTITY.value(), msg, HttpStatus.UNPROCESSABLE_ENTITY);
		}	
		if (sPRadRepository.findById(sPRad.getId()).isPresent()) {
			final String msg = "Data SP Rad Sudah Di Input ...!";
			throw new CustomException(HttpStatus.BAD_REQUEST.value(), msg, HttpStatus.BAD_REQUEST);
		} else {
			try {
				regSave = sPRadRepository.save(sPRad);
			} catch (IllegalArgumentException e) {
				final String msg = "Payload Tidak Valid ...";
				throw new CustomException(HttpStatus.BAD_REQUEST.value(), msg, HttpStatus.BAD_REQUEST);
			}
		}

		final String messageOk = "Ok";
		Metadata metadata = new Metadata(HttpStatus.OK.value(), messageOk);
		ResponseX<SPRad, Metadata> responseX = new ResponseX<>(regSave, metadata);
		return ResponseEntity.ok(responseX);

	}
	
	@PostMapping("/NewSPLabV2")
	public ResponseEntity<ResponseX<SPLab, Metadata>> addNewSPLabV2(@RequestBody SPLab sPLab) {
		SPLab regSave;

		if (sPLab.getDiagnosa() == null || sPLab.getDiagnosa().isBlank()) {
			String msg = "Diagnosa SP Lab Tidak Boleh Kosong";
			return buildErrorResponseLab(sPLab, msg, HttpStatus.UNPROCESSABLE_ENTITY);
		}

		if (sPLab.getId() == null) {
			String msg = "ID = IDReg(Px) SP Lab Tidak Boleh Kosong Atau PX Sudah Pulang";
			return buildErrorResponseLab(sPLab, msg, HttpStatus.UNPROCESSABLE_ENTITY);
		}

		if (sPLab.getIdDokter() == null) {
			String msg = "ID = ID Dokter SP Lab Tidak Boleh Kosong";
			return buildErrorResponseLab(sPLab, msg, HttpStatus.UNPROCESSABLE_ENTITY);
		}

		Optional<DokterERM> cek = dokterERMRepository.findById(sPLab.getIdDokter());
		if (cek.isEmpty()) {
			String msg = "ID (Kode) Dokter SP Lab tidak diketahui, silahkan Hub EDP..!!";
			return buildErrorResponseLab(sPLab, msg, HttpStatus.UNPROCESSABLE_ENTITY);
		}

		if (sPLab.getKelasID() == null) {
			String msg = "IDKelas SP Lab Tidak Boleh Kosong";
			return buildErrorResponseLab(sPLab, msg, HttpStatus.UNPROCESSABLE_ENTITY);
		}

		if (sPLab.getRoomID() == null) {
			String msg = "IDRoom SP Lab Tidak Boleh Kosong";
			return buildErrorResponseLab(sPLab, msg, HttpStatus.UNPROCESSABLE_ENTITY);
		}

		if (sPLab.getFginKre() != null && sPLab.getBb() == null) {
			String msg = "BB SP Lab Tidak Boleh Kosong";
			return buildErrorResponseLab(sPLab, msg, HttpStatus.UNPROCESSABLE_ENTITY);
		}

		if (sPLabRepository.findById(sPLab.getId()).isPresent()) {
			String msg = "SP Lab Data Sudah Di Input ...!";
			return buildErrorResponseLab(sPLab, msg, HttpStatus.BAD_REQUEST);
		}

		try {
			regSave = sPLabRepository.save(sPLab);
		} catch (IllegalArgumentException e) {
			String msg = "Payload Tidak Valid ...";
			return buildErrorResponseLab(sPLab, msg, HttpStatus.BAD_REQUEST);
		}

		Metadata metadata = new Metadata(HttpStatus.OK.value(), "Ok");
		ResponseX<SPLab, Metadata> responseX = new ResponseX<>(regSave, metadata);
		return ResponseEntity.ok(responseX);
	}
	
	private ResponseEntity<ResponseX<SPLab, Metadata>> buildErrorResponseLab(SPLab body, String msg, HttpStatus status) {
		Metadata metadata = new Metadata(status.value(), msg);
		ResponseX<SPLab, Metadata> responseX = new ResponseX<>(body, metadata);
		return ResponseEntity.status(status).body(responseX);
	}

	@PostMapping("/NewSPRadV2")
	public ResponseEntity<ResponseX<SPRad, Metadata>> addNewSPRadV2(@RequestBody SPRad sPRad) {
	    SPRad regSave;

	    if (sPRad.getDiagnosa() == null || sPRad.getDiagnosa().isBlank()) {
	        String msg = "Diagnosa SP Rad Tidak Boleh Kosong";
	        return buildErrorResponseRad(sPRad, msg, HttpStatus.UNPROCESSABLE_ENTITY);
	    }

	    if (sPRad.getId() == null) {
	        String msg = "ID = IDReg(Px) SP Rad Tidak Boleh Kosong Atau PX Sudah Pulang";
	        return buildErrorResponseRad(sPRad, msg, HttpStatus.UNPROCESSABLE_ENTITY);
	    }

	    if (sPRad.getIdDokter() == null) {
	        String msg = "ID = ID Dokter SP Rad Tidak Boleh Kosong";
	        return buildErrorResponseRad(sPRad, msg, HttpStatus.UNPROCESSABLE_ENTITY);
	    }

	    Optional<DokterERM> cek = dokterERMRepository.findById(sPRad.getIdDokter());
	    if (cek.isEmpty()) {
	        String msg = "ID (Kode) SP Rad Dokter tidak diketahui, silahkan Hub EDP..!!";
	        return buildErrorResponseRad(sPRad, msg, HttpStatus.UNPROCESSABLE_ENTITY);
	    }

	    if (sPRad.getKelasID() == null) {
	        String msg = "IDKelas SP Rad Tidak Boleh Kosong";
	        return buildErrorResponseRad(sPRad, msg, HttpStatus.UNPROCESSABLE_ENTITY);
	    }

	    if (sPRad.getRoomID() == null) {
	        String msg = "IDRoom SP Rad Tidak Boleh Kosong";
	        return buildErrorResponseRad(sPRad, msg, HttpStatus.UNPROCESSABLE_ENTITY);
	    }

	    if (sPRadRepository.findById(sPRad.getId()).isPresent()) {
	        String msg = "Data SP Rad Sudah Di Input ...!";
	        return buildErrorResponseRad(sPRad, msg, HttpStatus.BAD_REQUEST);
	    }

	    try {
	        regSave = sPRadRepository.save(sPRad);
	    } catch (IllegalArgumentException e) {
	        String msg = "Payload Tidak Valid ...";
	        return buildErrorResponseRad(sPRad, msg, HttpStatus.BAD_REQUEST);
	    }

	    Metadata metadata = new Metadata(HttpStatus.OK.value(), "Ok");
	    ResponseX<SPRad, Metadata> responseX = new ResponseX<>(regSave, metadata);
	    return ResponseEntity.ok(responseX);
	}

	private ResponseEntity<ResponseX<SPRad, Metadata>> buildErrorResponseRad(SPRad body, String msg, HttpStatus status) {
	    Metadata metadata = new Metadata(status.value(), msg);
	    ResponseX<SPRad, Metadata> responseX = new ResponseX<>(body, metadata);
	    return ResponseEntity.status(status).body(responseX);
	}
	
	@PutMapping("/UpdateSPLab")
	ResponseEntity<EntityModel<SPLab>> updateSPLab(@RequestParam(name = "no") Long no, @RequestBody SPLab sPLab)
		//	throws URISyntaxException 
	{	
		if (sPLabRepository.findById(no).isPresent()) {
			
			Optional<SPLabCek> cek = sPLabCekRepository.findById(no);
			if (cek.isPresent()) {
				String msg = "SP sudah di proses, silhakan buat SP baru..!!";
				System.out.println(msg);
				throw new CustomException(HttpStatus.UNPROCESSABLE_ENTITY.value(), msg, HttpStatus.UNPROCESSABLE_ENTITY);
			}	
			
			SPLab sPLabUpdate = sPLabRepository.findById(no).map(sPLb -> {
				sPLb.setId(sPLab.getId());
				sPLb.setIdDokter(sPLab.getIdDokter());
			//	sPLb.setOk(sPLab.getOk());
				sPLb.setTgl(sPLab.getTgl());
				sPLb.setJam(sPLab.getJam());
				sPLb.setHeDL(sPLab.getHeDL());
				sPLb.setHeHemo(sPLab.getHeHemo());
				sPLb.setHeLeko(sPLab.getHeLeko());
				sPLb.setHeHema(sPLab.getHeHema());
				sPLb.setHeEri(sPLab.getHeEri());
				sPLb.setHeLajuEnDa(sPLab.getHeLajuEnDa());				
				sPLb.setHeTrombo(sPLab.getHeTrombo());
				sPLb.setHeReti(sPLab.getHeReti());
				sPLb.setHeHitung(sPLab.getHeHitung());
				sPLb.setHeSerum(sPLab.getHeSerum());
				sPLb.setHeTIBC(sPLab.getHeTIBC());				
				sPLb.setFhelPPT(sPLab.getFhelPPT());
				sPLb.setFheAPTT(sPLab.getFheAPTT());
				sPLb.setFheCT(sPLab.getFheCT());
				sPLb.setFheBT(sPLab.getFheBT());
				sPLb.setFheINR(sPLab.getFheINR());				
				sPLb.setFheGolDar(sPLab.getFheGolDar());
				sPLb.setFheGolDarRe(sPLab.getFheGolDarRe());
				sPLb.setFheHapusanDar(sPLab.getFheHapusanDar());
				sPLb.setUl(sPLab.getUl());
				sPLb.setFcesFL(sPLab.getFcesFL());				
				sPLb.setFcesBenzi(sPLab.getFcesBenzi());
				sPLb.setFhaBiliTotal(sPLab.getFhaBiliTotal());
				sPLb.setFhaBiliDerek(sPLab.getFhaBiliDerek());
				sPLb.setFhaBiliInDerek(sPLab.getFhaBiliInDerek());
				sPLb.setFhaSGOT(sPLab.getFhaSGOT());				
				sPLb.setFhaSGPT(sPLab.getFhaSGPT());
				sPLb.setFhaAlkali(sPLab.getFhaAlkali());
				sPLb.setFhaTotalPro(sPLab.getFhaTotalPro());
				sPLb.setFhaAlbu(sPLab.getFhaAlbu());
				sPLb.setFhaGlo(sPLab.getFhaGlo());				
				sPLb.setFginKre(sPLab.getFginKre());
				sPLb.setFginUreun(sPLab.getFginUreun());
				sPLb.setFginUridAcid(sPLab.getFginUridAcid());
				sPLb.setLemDarChole(sPLab.getLemDarChole());
				sPLb.setLemDarHDL(sPLab.getLemDarHDL());				
				sPLb.setLemDarLDL(sPLab.getLemDarLDL());
				sPLb.setLemDarTri(sPLab.getLemDarTri());
				sPLb.setGdglu(sPLab.getGdglu());
				sPLb.setGdglu2jam(sPLab.getGdglu2jam());
				sPLb.setGdglusesaat(sPLab.getGdglusesaat());				
				sPLb.setGdhbA1c(sPLab.getGdhbA1c());
				sPLb.setEle(sPLab.getEle());
				sPLb.setEleNat(sPLab.getEleNat());
				sPLb.setEleKal(sPLab.getEleKal());
				sPLb.setEleClo(sPLab.getEleClo());				
				sPLb.setEleCal(sPLab.getEleCal());
				sPLb.setImHBsAg(sPLab.getImHBsAg());
				sPLb.setImAnHBs(sPLab.getImAnHBs());
				sPLb.setImHBsAgTiter(sPLab.getImHBsAgTiter());
				sPLb.setImAnHBsAgTiter(sPLab.getImAnHBsAgTiter());				
				sPLb.setImAnHCV(sPLab.getImAnHCV());
				sPLb.setImAnHAVIgG(sPLab.getImAnHAVIgG());
				sPLb.setImAnIgM(sPLab.getImAnIgM());
				sPLb.setIminWidal(sPLab.getIminWidal());
				sPLb.setIminAntiDhf(sPLab.getIminAntiDhf());				
				sPLb.setIminVDRL(sPLab.getIminVDRL());
				sPLb.setIminAntiHIV(sPLab.getIminAntiHIV());
				sPLb.setIminMala(sPLab.getIminMala());
				sPLb.setIminScreHIV(sPLab.getIminScreHIV());
				sPLb.setIminASO(sPLab.getIminASO());				
				sPLb.setIminCRP(sPLab.getIminCRP());
				sPLb.setIminAna(sPLab.getIminAna());
				sPLb.setIminTubex(sPLab.getIminTubex());
				sPLb.setIminMantoux(sPLab.getIminMantoux());
				sPLb.setIminigGAnToxo(sPLab.getIminigGAnToxo());				
				sPLb.setIminigMAnToxo(sPLab.getIminigMAnToxo());
				sPLb.setIminigGAnRub(sPLab.getIminigGAnRub());
				sPLb.setIminigMAnRub(sPLab.getIminigMAnRub());
				sPLb.setIminigGAnCMV(sPLab.getIminigGAnCMV());
				sPLb.setIminigMAnCMV(sPLab.getIminigMAnCMV());				
				sPLb.setIminigGAnHSV1(sPLab.getIminigGAnHSV1());
				sPLb.setIminigMAnHSV1(sPLab.getIminigMAnHSV1());
				sPLb.setIminigGAnHSV2(sPLab.getIminigGAnHSV2());
				sPLb.setIminigMAnHSV2(sPLab.getIminigMAnHSV2());
				sPLb.setHamPlano(sPLab.getHamPlano());				
				sPLb.setHamTestPack(sPLab.getHamTestPack());
				sPLb.setHamPlanoPengen(sPLab.getHamPlanoPengen());
				sPLb.setTumAFP(sPLab.getTumAFP());
				sPLb.setTumCEA(sPLab.getTumCEA());
				sPLb.setTumPSA(sPLab.getTumPSA());				
				sPLb.setTumCa125(sPLab.getTumCa125());
				sPLb.setTumCa19(sPLab.getTumCa19());
				sPLb.setTirTSH(sPLab.getTirTSH());
				sPLb.setTirFT3(sPLab.getTirFT3());
				sPLb.setTirFT4(sPLab.getTirFT4());				
				sPLb.setJanTrop(sPLab.getJanTrop());
				sPLb.setJanOk(sPLab.getJanOk());
				sPLb.setJanTropI(sPLab.getJanTropI());
				sPLb.setMikZN(sPLab.getMikZN());
				sPLb.setMikNeis(sPLab.getMikNeis());				
				sPLb.setMikGram(sPLab.getMikGram());
				sPLb.setMikMal(sPLab.getMikMal());
				sPLb.setMikKulDar(sPLab.getMikKulDar());
				sPLb.setMikKulUr(sPLab.getMikKulUr());
				sPLb.setMikSpu(sPLab.getMikSpu());				
				sPLb.setGd(sPLab.getGd());
				sPLb.setLainAnSper(sPLab.getLainAnSper());
				sPLb.setLainAnBatGin(sPLab.getLainAnBatGin());
				sPLb.setLainRap(sPLab.getLainRap());
				sPLb.setLainODim(sPLab.getLainODim());				
				sPLb.setInap(sPLab.getInap());
				sPLb.setLain(sPLab.getLain());
				sPLb.setKelasID(sPLab.getKelasID());
				sPLb.setRoomID(sPLab.getRoomID());
				sPLb.setDiagnosa(sPLab.getDiagnosa());
				
				return sPLabRepository.save(sPLb);
			}).get();

			EntityModel<SPLab> resource = EntityModel.of(sPLabUpdate,
					linkTo(methodOn(RegNewController.class).getSPLab(sPLabUpdate.getId())).withSelfRel());

			return ResponseEntity.created(resource.getRequiredLink(IanaLinkRelations.SELF).toUri()).body(resource);
		
		} else {
			try {
				final String msg = "ID data SP Tidak ada...!";
				throw new CustomException(HttpStatus.BAD_REQUEST.value(), msg, HttpStatus.BAD_REQUEST);			
					
				} catch (IllegalArgumentException e) {
				final String msg = "Payload Tidak Valid ...";
				throw new CustomException(HttpStatus.BAD_REQUEST.value(), msg, HttpStatus.BAD_REQUEST);
			}
		}	
	}
	
	@PutMapping("/UpdateSPRad")
	ResponseEntity<EntityModel<SPRad>> updateSPRad(@RequestParam(name = "no") Long no, @RequestBody SPRad sPRad)
		//	throws URISyntaxException 
	{	
		if (sPRadRepository.findById(no).isPresent()) {
			
			Optional<SPRadCek> cek = sPRadCekRepository.findById(no);
			if (cek.isPresent()) {
				String msg = "SP sudah di proses, silhakan buat SP baru..!!";
				System.out.println(msg);
				throw new CustomException(HttpStatus.UNPROCESSABLE_ENTITY.value(), msg, HttpStatus.UNPROCESSABLE_ENTITY);
			}	
			
			SPRad sPRadUpdate = sPRadRepository.findById(no).map(sPRd -> {
				sPRd.setId(sPRad.getId());
				sPRd.setIdDokter(sPRad.getIdDokter());
			//	sPRd.setOk(sPRad.getOk());
				sPRd.setTgl(sPRad.getTgl());
				sPRd.setJam(sPRad.getJam());
				sPRd.setSkullAP(sPRad.getSkullAP());
				sPRd.setSkullLAT(sPRad.getSkullLAT());
				sPRd.setWatersAP(sPRad.getWatersAP());
				sPRd.setWatersLAT(sPRad.getWatersLAT());
				sPRd.setVerCerAP(sPRad.getVerCerAP());
				sPRd.setVerCerLAT(sPRad.getVerCerLAT());
				sPRd.setVerCerOBQ(sPRad.getVerCerOBQ());
				sPRd.setVerThoAP(sPRad.getVerThoAP());
				sPRd.setVerThoLAT(sPRad.getVerThoLAT());
				sPRd.setVerThoOBQ(sPRad.getVerThoOBQ());
				sPRd.setVerLumAP(sPRad.getVerLumAP());
				sPRd.setVerLumLAT(sPRad.getVerLumLAT());
				sPRd.setVerLumOBQ(sPRad.getVerLumOBQ());
				sPRd.setClaAP(sPRad.getClaAP());
				sPRd.setClaLAT(sPRad.getClaLAT());
				sPRd.setThoAP(sPRad.getThoAP());
				sPRd.setThoLAT(sPRad.getThoLAT());
				sPRd.setCosAP(sPRad.getCosAP());
				sPRd.setCosLAT(sPRad.getCosLAT());
				sPRd.setShoAP(sPRad.getShoAP());
				sPRd.setShoLAT(sPRad.getShoLAT());
				sPRd.setHumAP(sPRad.getHumAP());
				sPRd.setHumLAT(sPRad.getHumLAT());
				sPRd.setCubAP(sPRad.getCubAP());
				sPRd.setCubLAT(sPRad.getCubLAT());
				sPRd.setAntAP(sPRad.getAntAP());
				sPRd.setAntLAT(sPRad.getAntLAT());
				sPRd.setWristAP(sPRad.getWristAP());
				sPRd.setWristLAT(sPRad.getWristLAT());
				sPRd.setManAP(sPRad.getManAP());
				sPRd.setManLAT(sPRad.getManLAT());
				sPRd.setAbdoAP(sPRad.getAbdoAP());
				sPRd.setAbdoLAT(sPRad.getAbdoLAT());
				sPRd.setPelAP(sPRad.getPelAP());
				sPRd.setPelLAT(sPRad.getPelLAT());
				sPRd.setFeAP(sPRad.getFeAP());
				sPRd.setFeLAT(sPRad.getFeLAT());
				sPRd.setGeAP(sPRad.getGeAP());
				sPRd.setGeLAT(sPRad.getGeLAT());
				sPRd.setCruAP(sPRad.getCruAP());
				sPRd.setCruLAT(sPRad.getCruLAT());
				sPRd.setAngAP(sPRad.getAngAP());
				sPRd.setAngLAT(sPRad.getAngLAT());
				sPRd.setPedAP(sPRad.getPedAP());
				sPRd.setPedLAT(sPRad.getPedLAT());
				sPRd.setIVP(sPRad.getIVP());
				sPRd.setCysto(sPRad.getCysto());
				sPRd.setUret(sPRad.getUret());
				sPRd.setBarium(sPRad.getBarium());
				sPRd.setKepalaBayi(sPRad.getKepalaBayi());
				sPRd.setMata(sPRad.getMata());
				sPRd.setThyroid(sPRad.getThyroid());
				sPRd.setMammae(sPRad.getMammae());
				sPRd.setUpperAb(sPRad.getUpperAb());
				sPRd.setLowerAb(sPRad.getLowerAb());
				sPRd.setUrologi(sPRad.getUrologi());
				sPRd.setTestis(sPRad.getTestis());
				sPRd.setMuscul(sPRad.getMuscul());
				sPRd.setCTKepala(sPRad.getCTKepala());
				sPRd.setCTKepalaDgKontras(sPRad.getCTKepalaDgKontras());
				sPRd.setCTThorax(sPRad.getCTThorax());
				sPRd.setCTThoraxDgKontras(sPRad.getCTThoraxDgKontras());
				sPRd.setCTUpLoAbdo(sPRad.getCTUpLoAbdo());
				sPRd.setMRIKepala(sPRad.getMRIKepala());
				sPRd.setMRICervical(sPRad.getMRICervical());
				sPRd.setMRIThoracal(sPRad.getMRIThoracal());
				sPRd.setMRILumbal(sPRad.getMRILumbal());
				sPRd.setMRIAbdomenAtBaw(sPRad.getMRIAbdomenAtBaw());
				sPRd.setMRIEkstrem(sPRad.getMRIEkstrem());
				sPRd.setLain(sPRad.getLain());
				sPRd.setKelasID(sPRad.getKelasID());
				sPRd.setRoomID(sPRad.getRoomID());
				sPRd.setDiagnosa(sPRad.getDiagnosa()); 
				sPRd.setClaAPS(sPRad.getClaAPS());
				sPRd.setClaLATS(sPRad.getClaLATS());
				sPRd.setCosAPS(sPRad.getCosAPS());
				sPRd.setCosLATS(sPRad.getCosLATS());
				sPRd.setShoAPS(sPRad.getShoAPS());
				sPRd.setShoLATS(sPRad.getShoLATS());
				sPRd.setHumAPS(sPRad.getHumAPS());
				sPRd.setHumLATS(sPRad.getHumLATS());
				sPRd.setAntAPS(sPRad.getAntAPS());
				sPRd.setAntLATS(sPRad.getAntLATS());
				sPRd.setWristAPS(sPRad.getWristAPS());
				sPRd.setWristLATS(sPRad.getWristLATS());
				sPRd.setManAPS(sPRad.getManAPS());
				sPRd.setManLATS(sPRad.getManLATS());
				sPRd.setFeAPS(sPRad.getFeAPS());
				sPRd.setFeLATS(sPRad.getFeLATS());
				sPRd.setGeAPS(sPRad.getGeAPS());
				sPRd.setGeLATS(sPRad.getGeLATS());
				sPRd.setCruAPS(sPRad.getCruAPS());
				sPRd.setCruLATS(sPRad.getCruLATS());
				sPRd.setAngAPS(sPRad.getAngAPS());
				sPRd.setAngLATS(sPRad.getAngLATS());
				sPRd.setPedAPS(sPRad.getPedAPS());
				sPRd.setPedLATS(sPRad.getPedLATS());
		
				
				return sPRadRepository.save(sPRd);
			}).get();

			EntityModel<SPRad> resource = EntityModel.of(sPRadUpdate,
					linkTo(methodOn(RegNewController.class).getSPRad(sPRadUpdate.getId())).withSelfRel());

			return ResponseEntity.created(resource.getRequiredLink(IanaLinkRelations.SELF).toUri()).body(resource);
		
		} else {
			try {
				final String msg = "ID SP = " +  no + " Tidak ada di Data SP...!";
				throw new CustomException(HttpStatus.BAD_REQUEST.value(), msg, HttpStatus.BAD_REQUEST);			
					
				} catch (IllegalArgumentException e) {
				final String msg = "Payload Tidak Valid ...";
				throw new CustomException(HttpStatus.BAD_REQUEST.value(), msg, HttpStatus.BAD_REQUEST);
			}
		}	
	} 
	
	@GetMapping("/ERMRadList/")
	List<RadHasilList> getRadListByidreg(@RequestParam(name = "idreg") Long idreg) {
		return radHasilListService.getByidreg(idreg);
	}
	
	@GetMapping("/ERMRadListRM/")
	List<RadHasilListRM> getRadListByrm(@RequestParam(name = "rm") String rm) {
		return radHasilListRMService.getByrm(rm);
	}
	
	@GetMapping("/ERMRadHasil/")
	public ResponseEntity<List<RadHasil>> radHasillByIDRad(@RequestParam(name = "idrad") Long idrad) {
		return new ResponseEntity<List<RadHasil>>(radHasilRepository.findByidrad(idrad), HttpStatus.OK);
	}
	
	@GetMapping("/ERMRadHasilPX/")
	public ResponseEntity<List<RadHasil>> radHasillPXByIDRad(@RequestParam(name = "idrad") Long idrad) {
		List<RadHasilPX> cek = radHasilPXRepository.findByidrad(idrad);
		List<RadHasilPXCek> cek1 = radHasilPXCekRepository.findByidrad(idrad);
		if (cek1.isEmpty()) {
			String msg = "ID Radiologi = " + idrad + " Tidak ada bisa di cek kembali..!!";
			System.out.println(msg);
			throw new CustomException(HttpStatus.NOT_FOUND.value(), msg, HttpStatus.NOT_FOUND);
		} else 
		if (cek.isEmpty()) {
			String msg = "ID Radiologi = " + idrad + " Belum jadi bisa di cek kembali..!!";
			System.out.println(msg);
			throw new CustomException(HttpStatus.NOT_FOUND.value(), msg, HttpStatus.NOT_FOUND);
		} else {
		
		return new ResponseEntity<List<RadHasil>>(radHasilRepository.findByidrad(idrad), HttpStatus.OK);
		}
	}
	
	@GetMapping("/ERMVKHPP/")
	public ResponseEntity<List<ERMIGDVKHPPView>> eRMIGDVKHPPById(@RequestParam(name = "kode") Long kode) {
		return new ResponseEntity<List<ERMIGDVKHPPView>>(eRMIGDVKHPPRepository.findByKode(kode), HttpStatus.OK);
	}
	
	@GetMapping("/PXInapID/")
	public ResponseEntity<?> PxInapOnsiteById(@RequestParam(name = "pxid") Long pxid) {
	    // Langsung cari list by PxId
	    List<PxInapOnsite> data = pxInapOnsiteRepository.findByPxId(pxid);

	    if (data == null || data.isEmpty()) {
	        String msg = "ID = " + pxid + " PX Inap Tidak ada atau PX RJ atau sudah pulang..!!";
	        System.out.println(msg);

	        // Jika project Java 9+
	        // return ResponseEntity.ok(Map.of("metadata", new Metadata(404, msg)));

	        // Java 8 compatible:
	        java.util.Map<String, Object> payload = new java.util.HashMap<>();
	        payload.put("metadata", new Metadata(200, msg));
	        return ResponseEntity.ok(payload);
	    }

	    // Data ada → tetap 200 dan kirim list apa adanya
	    return ResponseEntity.ok(data);
	}
	
	@GetMapping("/PXJalanID/")
	public ResponseEntity<?> PxJalanById(@RequestParam(name = "pxid") Long pxid) {
	    List<PxRJ> data = pxRJRepository.findByPxId(pxid);

	    if (data == null || data.isEmpty()) {
	        String msg = "ID = " + pxid + " PX RJ Tidak ada atau PX RI..!!";
	        System.out.println(msg);

	        // bangun payload: { "metadata": { "message": "...", "code": 200 } }
	        Metadata metadata = new Metadata(200, msg); // sesuaikan ctor Metadata(code, message)
	        java.util.Map<String, Object> payload = new java.util.HashMap<>();
	        payload.put("metadata", metadata);

	        return ResponseEntity.ok(payload); // HTTP 200
	    }

	    // Data ada → kembalikan list apa adanya (HTTP 200)
	    return ResponseEntity.ok(data);
	}
	
	@GetMapping("/PXIGD/")
	public ResponseEntity<?> PxIGDById(@RequestParam(name = "pxid") Long pxid) {
	    // Ambil langsung list by PxId (hindari query findById lalu query ulang)
	    List<PxIGD> data = pxIGDRepository.findByPxId(pxid);

	    if (data == null || data.isEmpty()) {
	        String msg = "ID = " + pxid + " PX IGD Tidak ada..!!";
	        System.out.println(msg);

	        // { "metadata": { "message": "...", "code": 200 } }
	        Metadata metadata = new Metadata(200, msg); // sesuaikan ctor Metadata(code, message)
	        java.util.Map<String, Object> payload = new java.util.HashMap<>();
	        payload.put("metadata", metadata);

	        return ResponseEntity.ok(payload); // HTTP 200
	    }

	    // Data ada → kembalikan list apa adanya (HTTP 200)
	    return ResponseEntity.ok(data);
	}
	
	@GetMapping("/LogGiziproduct/")
	List<LogGiziProduct> LogGiziProduct() {
		return logGiziProductRepository.findAll();
	}
	
	/*@GetMapping("/Flow/{id}")
    public FlowModel getFlow(@PathVariable Long id) {
		Optional<Flow> cek = flowRepository.findById(id);
		if (cek.isEmpty()) {
			String msg = "ID Tidak ada..!!";
			System.out.println(msg);
			throw new CustomExceptionS(HttpStatus.NOT_FOUND.value(), msg, HttpStatus.NOT_FOUND);
		} else {
			Flow flow = flowRepository.findById(id).orElse(null);
	        List<FlowDet> flowDet = flowDetRepository.findByid(id);
	        return new FlowModel(flow, flowDet);
			//return new ResponseEntity<List<PxInapOnsite>>(pxInapOnsiteRepository.findByPxId(pxid), HttpStatus.OK);
		}
        
    }*/
	
	@GetMapping("/Flow/{id}")
    public FlowModelList getFlowList(@PathVariable Long id) {
		Optional<Flow> cek = flowRepository.findById(id);
		if (cek.isEmpty()) {
			String msg = "ID Flow = " + id + " Tidak ada..!!";
			System.out.println(msg);
			throw new CustomExceptionS(HttpStatus.NOT_FOUND.value(), msg, HttpStatus.NOT_FOUND);
		} else {
			Flow flow = flowRepository.findById(id).orElse(null);
	        List<FlowDet> flowDet = flowDetRepository.findByid(id);
	        return new FlowModelList(flow.getId(), flow.getFlowTgl(), flow.getJam(), flowDet);
			//return new ResponseEntity<List<PxInapOnsite>>(pxInapOnsiteRepository.findByPxId(pxid), HttpStatus.OK);
		}
        
    }
	
	/*@GetMapping("/Flow/")
    public FlowModelList getFlowD() {
        List<Flow> flow = flowRepository.findAll();
        List<FlowDet> flowDet = flowDetRepository.findByid(flow.getId);
        return new FlowModelList(flow, flowDet);
    }	*/
	
	@GetMapping("/Flow")
    public List<Map<String, Object>> getAllFlowWithDet() {
        List<Flow> flows = flowRepository.findAll();
        
        return flows.stream().map(flow -> {
            Map<String, Object> flowMap = new HashMap<>();
            flowMap.put("flow", flow);
            List<FlowDet> flowDets = flowDetRepository.findByid(flow.getId());
            flowMap.put("flowDet", flowDets);
       //     flowMap.put("Flow", flow);
            return flowMap;
     //   }).toList();
	   }).collect(Collectors.toList());
    }
	
	@GetMapping("/Flow/")
    public List<FlowModelList> getAllFlowWithDets() {
        List<Flow> flows = flowRepository.findAll();
        
        return flows.stream().map(flow -> {
            List<FlowDet> flws = flowDetRepository.findByid(flow.getId());
            return new FlowModelList(flow.getId(), flow.getFlowTgl(), flow.getJam(), flws);
        }).collect(Collectors.toList());
    }
		
	@PostMapping("/NewFlow")
    public Flow saveProduct(@RequestBody Flow flow) {
	//	Date date = (flow.getFlowTgl());
	//	LocalDate tgPx = date.toInstant().atZone(ZoneId.of("Asia/Jakarta")).toLocalDate();
	//	ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.of("Asia/Jakarta"));
	//	ZonedDateTime yesterdayJakarta = zonedDateTime.minusDays(1);
        // Mengambil LocalDate dari ZonedDateTime
    //    LocalDate isNow = yesterdayJakarta.toLocalDate();
	//	 if (isNow.isAfter(tgPx) || isNow.isEqual(tgPx)) {
	//		 	String msg = "Tanggal harus sama atau lebih besar dari hari ini..!!";
	//			System.out.println(msg);
	//			throw new CustomExceptionS(HttpStatus.UNPROCESSABLE_ENTITY.value(), msg, HttpStatus.UNPROCESSABLE_ENTITY);
			
	//        } 
        // Menyimpan langsung ke database menggunakan repository
        return flowRepository.save(flow);
    }
	
	@PutMapping("/UpdateFlow")
	public ResponseEntity<EntityModel<Flow>> updateFlow(@RequestParam(name = "id") Long id, @RequestBody Flow flow) {
	    Optional<Flow> existingFlow = flowRepository.findById(id);
	    
	    if (existingFlow.isPresent()) {  
	        Optional<FlowCek> cek = flowCekRepository.findById(id);
	        if (cek.isPresent()) {
	            String msg = "ID sudah diproses, silakan buat Pemesanan baru..!!";
	            System.out.println(msg);
	            throw new CustomExceptionS(HttpStatus.UNPROCESSABLE_ENTITY.value(), msg, HttpStatus.UNPROCESSABLE_ENTITY);
	        }  

	        // Update Flow
	        Flow flowUpdate = existingFlow.get();
	        flowUpdate.setFlowTgl(flow.getFlowTgl());
	        flowUpdate.setJam(flow.getJam());

	        flowRepository.save(flowUpdate);

	        // Entity Model
	        EntityModel<Flow> resource = EntityModel.of(flowUpdate);//,
	            //    linkTo(methodOn(RegNewController.class).getSPRad(flowUpdate.getId())).withSelfRel());

	        return ResponseEntity.ok(resource);
	    } else {
	        String msg = "ID Tidak ada...!";
	        throw new CustomExceptionS(HttpStatus.BAD_REQUEST.value(), msg, HttpStatus.BAD_REQUEST);
	    }
	}
	
	@PostMapping("/NewFlowDet")
    public List<FlowDet> saveFlowDet(@RequestBody List<FlowDet> flowDets) {
		//  Cek ID Induk
		for (FlowDet flowDet : flowDets) {
				Optional<Flow> cek = flowRepository.findById(flowDet.getId());	
				if (cek.isEmpty()) {
					String msg = "Kode (ID) Induk Tidak ada, Silahkan Buat ID Induk terlebih Dahulu..!!";
					System.out.println(msg);
					throw new CustomExceptionS(HttpStatus.UNPROCESSABLE_ENTITY.value(), msg, HttpStatus.UNPROCESSABLE_ENTITY);
				}	
			}
			
		//  Cek Kode Barang
		for (FlowDet flowDet : flowDets) {
			Optional<LogGiziProduct> cek = logGiziProductRepository.findById(flowDet.getProductID());	
			if (cek.isEmpty()) {
				String msg = "Kode Produk Tidak ada";
				System.out.println(msg);
				throw new CustomExceptionS(HttpStatus.UNPROCESSABLE_ENTITY.value(), msg, HttpStatus.UNPROCESSABLE_ENTITY);
			}	
		}
		
		// Cek Data Sudah Ada
		for (FlowDet flowDet : flowDets) {			
			if (flowDet.getQty() == null || flowDet.getQty() <= 0)  {
				String msg = "Jumlah Tidak Boleh kosong dan Angka harus Positif";
				System.out.println(msg);
				throw new CustomExceptionS(HttpStatus.UNPROCESSABLE_ENTITY.value(), msg, HttpStatus.UNPROCESSABLE_ENTITY);
			}			
			
			FlowDetClass flowDetClass = new FlowDetClass(flowDet.getId(), flowDet.getProductID());
			Optional<FlowDet> foundflowDet = flowDetRepository.findById(flowDetClass);
	
			if (foundflowDet.isPresent()) {
				final String msg = "Data sudah ada, Silahkan Cek Kembali...!";
				throw new CustomExceptionS(HttpStatus.BAD_REQUEST.value(), msg, HttpStatus.BAD_REQUEST);
				} 			
 			}
		return (List<FlowDet>) flowDetRepository.saveAll(flowDets);			
	}
		
	@PutMapping("/UpdateFlowDet")
	public List<FlowDet> updateFlowDets(@RequestBody List<FlowDet> flowDets) {		
			//  Cek ID Induk
			for (FlowDet flowDet : flowDets) {
					Optional<Flow> cek = flowRepository.findById(flowDet.getId());	
					if (cek.isEmpty()) {
						String msg = "Kode (ID) Induk Tidak ada, Silahkan Buat ID Induk terlebih Dahulu..!!";
						System.out.println(msg);
						throw new CustomExceptionS(HttpStatus.UNPROCESSABLE_ENTITY.value(), msg, HttpStatus.UNPROCESSABLE_ENTITY);
					}	
				}
			// ID Induk Sudah di Proses
			for (FlowDet flowDet : flowDets) {
				Optional<FlowCek> cek = flowCekRepository.findById(flowDet.getId());	
				if (cek.isPresent()) {
					String msg = "ID Induk sudah di proses..!!";
					System.out.println(msg);
					throw new CustomExceptionS(HttpStatus.UNPROCESSABLE_ENTITY.value(), msg, HttpStatus.UNPROCESSABLE_ENTITY);
				}	
			}	
				
			//  Cek Kode Barang
			for (FlowDet flowDet : flowDets) {
				Optional<LogGiziProduct> cek = logGiziProductRepository.findById(flowDet.getProductID());	
				if (cek.isEmpty()) {
					String msg = "Kode Produk Tidak ada";
					System.out.println(msg);
					throw new CustomExceptionS(HttpStatus.UNPROCESSABLE_ENTITY.value(), msg, HttpStatus.UNPROCESSABLE_ENTITY);
				}	
			}	
			//Cek Data 
			for (FlowDet flowDet : flowDets) {			
			//	if (flowDet.getQty() == null || flowDet.getQty() <= 0)  {
			//		String msg = "Jumlah Tidak Boleh kosong dan Angka harus Positif";
			//		System.out.println(msg);
			//		throw new CustomExceptionS(HttpStatus.UNPROCESSABLE_ENTITY.value(), msg, HttpStatus.UNPROCESSABLE_ENTITY);
			//	}
			
			FlowDetClass flowDetClass = new FlowDetClass(flowDet.getId(), flowDet.getProductID());
			Optional<FlowDet> foundflowDet = flowDetRepository.findById(flowDetClass);
	
			if (foundflowDet.isEmpty()) {
			final String msg = "Data tidak ada, Silahkan Cek Kembali...!";
				throw new CustomExceptionS(HttpStatus.BAD_REQUEST.value(), msg, HttpStatus.BAD_REQUEST);
				} 			
			flowDetRepository.updateFlowDet(flowDet.getId(), flowDet.getProductID(), flowDet.getQty()
			//		, flowDet.getDiterima(), flowDet.getKet()
					);
		} 
		return flowDets;
	}
	
	@DeleteMapping("/DeleteFlowDet")
	public List<FlowDet> deleteFlowDet(@RequestBody List<FlowDet> flowDets) {
		for (FlowDet flowDet : flowDets) {
			Optional<FlowCek> cek = flowCekRepository.findById(flowDet.getId());	
			if (cek.isPresent()) {
				String msg = "ID Induk sudah di proses..!!";
				System.out.println(msg);
				throw new CustomExceptionS(HttpStatus.UNPROCESSABLE_ENTITY.value(), msg, HttpStatus.UNPROCESSABLE_ENTITY);
			}	
		}	
		
		for (FlowDet flowDet : flowDets) {
			Optional<LogGiziProduct> cek = logGiziProductRepository.findById(flowDet.getProductID());	
			if (cek.isEmpty()) {
				String msg = "Kode Produk Tidak ada";
				System.out.println(msg);
				throw new CustomExceptionS(HttpStatus.UNPROCESSABLE_ENTITY.value(), msg, HttpStatus.UNPROCESSABLE_ENTITY);
			}	
		}	
		for (FlowDet flowDet : flowDets) {	
			FlowDetClass flowDetClass = new FlowDetClass(flowDet.getId(), flowDet.getProductID());			
			Optional<FlowDet> foundflowDet = flowDetRepository.findById(flowDetClass);
			if (foundflowDet.isEmpty()) {
				final String msg = "Data tidak ada, Silahkan Cek Kembali...!";
					throw new CustomExceptionS(HttpStatus.BAD_REQUEST.value(), msg, HttpStatus.BAD_REQUEST);
					} 
			flowDetRepository.deleteById(flowDetClass);		
		}
		String msg = "Berhasil";
		System.out.println("delete record FlowDet");
		throw new CustomExceptionS(HttpStatus.OK.value(), msg, HttpStatus.OK);
	}
	
	@PostMapping("/CekPxWeb")
	public ResponseEntity<ResponseX<CekPxWeb, Metadata>> CekPxWeb(@RequestBody CekIdRmTglLahirModel nope) {
		// Validasi panjang UUID setelah dikonversi ke String
	    if (nope.getIdn() != null && nope.getIdn().toString().length() > 36) {
	        Metadata metadata = new Metadata(HttpStatus.BAD_REQUEST.value(), "terlalu panjang");
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseX<>(null, metadata));
	    }
		
		Optional<CekPxWeb> cpx = cekPxWebRepository.findByIdn(nope.getIdn());
	    // Data input pengguna yang akan dikembalikan sebagai data (termasuk jika data tidak ditemukan)
	    CekPxWeb responseData = null; // Data CekPxWeb yang akan dikembalikan
	    if (cpx.isPresent()) {
	        responseData = cpx.get(); // Ambil data dari database jika ditemukan
	    } else {
	        // Jika tidak ditemukan, tetap tampilkan data input di response
	    	
	        responseData = new CekPxWeb();
	        responseData.setIdn(nope.getIdn());
	    }

	    // Metadata response (pesan kesalahan atau sukses)
	    final String msg = cpx.isPresent() ? "Ok" : "ID tidak ada";
	    Metadata metadata = new Metadata(cpx.isPresent() ? HttpStatus.OK.value() : HttpStatus.NOT_FOUND.value(), msg);

	    // Membuat response yang konsisten
	    ResponseX<CekPxWeb, Metadata> responseX = new ResponseX<>(responseData, metadata);

	    // Mengembalikan respons
	    return cpx.isPresent() ?
	        ResponseEntity.ok(responseX) : 
	        ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseX);
	}		
		
	@GetMapping("/CekIDIDN/")
	public ResponseEntity<CekIDIDN> CekIDIDNById(@RequestParam(name = "id") Long id) {
	    CekIDIDN cek = cekIDIDNRepository.findById(id)
	        .orElseThrow(() -> {
	            String msg = "ID = " + id + " PX RJ Tidak ada atau PX RI..!!";
	            System.out.println(msg);
	            return new CustomException(HttpStatus.NOT_FOUND.value(), msg, HttpStatus.NOT_FOUND);
	        });

	    return ResponseEntity.ok(cek);
	}
	
	@GetMapping("/UPx/")
	 public ResponseEntity<List<UPx>> getUPx() {
        List<UPx> up = uPxRepository.getSP();
        return ResponseEntity.ok(up);
    }
	
	@GetMapping("/SensusIRJ/")
	 public ResponseEntity<List<SensusIRJ>> getSensusIRJ() {
       List<SensusIRJ> up = sensusIRJRepository.getSP();
       return ResponseEntity.ok(up);
   }

	@GetMapping("/SPLabPrinter/")
	List<SPLabPrint> getSPLabPrinterByNo(@RequestParam(name = "no") Long no) {
		return sPLabPrintService.getByNo(no);
	}
	
	@GetMapping("/SPRadPrinter/")
	List<SPRadPrint> getSPRadPrinterByNo(@RequestParam(name = "no") Long no) {
		return sPRadPrintService.getByNo(no);
	}
	
	@DeleteMapping("/SPLab/{id}")
	public ResponseEntity<ResponseX<SPLab, Metadata>> deleteSPLab(@PathVariable("id") Long id) {
	    Optional<SPLab> existingData = sPLabRepository.findById(id);

	    if (existingData.isEmpty()) {
	        String msg = "Data SP Lab tidak ditemukan untuk dihapus";
	        Metadata metadata = new Metadata(200, msg);
	        return ResponseEntity.ok(new ResponseX<>(null, metadata)); // 200 OK
	    }

	    Optional<SPLabCek> cek = sPLabCekRepository.findById(id);
	    if (cek.isPresent()) {
	        String msg = "SP Lab sudah diproses, silakan buat SP baru.";
	        return buildErrorResponseLab(existingData.get(), msg, HttpStatus.UNPROCESSABLE_ENTITY);
	    }

	    try {
	        sPLabRepository.deleteById(id);
	    } catch (Exception e) {
	        String msg = "Gagal menghapus SP Lab: " + e.getMessage();
	        return buildErrorResponseLab(existingData.get(), msg, HttpStatus.INTERNAL_SERVER_ERROR);
	    }

	    String msg = "Data SP Lab berhasil dihapus";
	    Metadata metadata = new Metadata(HttpStatus.OK.value(), msg);
	    ResponseX<SPLab, Metadata> responseX = new ResponseX<>(existingData.get(), metadata);
	    return ResponseEntity.ok(responseX);
	}
	
	@DeleteMapping("/SPRad/{id}")
	public ResponseEntity<ResponseX<SPRad, Metadata>> deleteSPRad(@PathVariable("id") Long id) {
	    Optional<SPRad> existingData = sPRadRepository.findById(id);

	    /*if (existingData.isEmpty()) {
	        String msg = "Data SP Rad tidak ditemukan untuk dihapus";
	        return buildErrorResponseRad(null, msg, HttpStatus.NOT_FOUND);
	    }*/
	    
	    if (existingData.isEmpty()) {
	        String msg = "Data SP Rad tidak ditemukan untuk dihapus";
	        Metadata metadata = new Metadata(200, msg);
	        return ResponseEntity.ok(new ResponseX<>(null, metadata)); // 200 OK
	    }

	    Optional<SPRadCek> cek = sPRadCekRepository.findById(id);
	    if (cek.isPresent()) {
	        String msg = "SP Rad sudah diproses, silakan buat SP baru.";
	        return buildErrorResponseRad(existingData.get(), msg, HttpStatus.UNPROCESSABLE_ENTITY);
	    }

	    try {
	        sPRadRepository.deleteById(id);
	    } catch (Exception e) {
	        String msg = "Gagal menghapus SP Rad: " + e.getMessage();
	        return buildErrorResponseRad(existingData.get(), msg, HttpStatus.INTERNAL_SERVER_ERROR);
	    }

	    String msg = "Data SP Rad berhasil dihapus";
	    Metadata metadata = new Metadata(HttpStatus.OK.value(), msg);
	    ResponseX<SPRad, Metadata> responseX = new ResponseX<>(existingData.get(), metadata);
	    return ResponseEntity.ok(responseX);
	}




}
