package com.dev.generik.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.dev.generik.entities.RM.ListRJ;
import com.dev.generik.repository.RM.ListRJRepository;

@RestController
@RequestMapping("his/rm")
public class RMController {
	
	@Autowired
	ListRJRepository listRJRepository;

	@GetMapping("/ListRJ")
	public Page<ListRJ> getAllListRJ(
	    @PageableDefault(page = 0, size = 5, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
	    return listRJRepository.findAll(pageable);
	}
	
	@GetMapping("/ListRJ/top10")
	public List<ListRJ> getTop10ListRJ() {
	    return listRJRepository.findTop10ByOrderByIdDesc();
	}
	
	@GetMapping("/ListRJ/{id}")
	public ResponseEntity<ListRJ> getListRJById(@PathVariable Long id) {
	    return listRJRepository.findById(id)
	        .map(ResponseEntity::ok)
	        .orElse(ResponseEntity.notFound().build());

	}
}

