package com.dev.generik.repository.Dokter;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dev.generik.entities.Dokter.SpecialistSKDP;

public interface SpecialistSKDPRepository extends JpaRepository<SpecialistSKDP, Long> {
	List<SpecialistSKDP> findTop20ByOrderByNameAsc();
	List<SpecialistSKDP> findByNameContainingIgnoreCaseOrderByNameAsc(String keyword);
//	List<SpecialistSKDP> findByOrderByKdBPJSAsc(String kdBPJS);
	Optional<SpecialistSKDP> findByKdBPJSIgnoreCase(String kdBPJS);

}
