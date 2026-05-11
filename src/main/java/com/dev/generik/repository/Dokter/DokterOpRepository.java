package com.dev.generik.repository.Dokter;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dev.generik.entities.Dokter.DokterOp;

public interface DokterOpRepository extends JpaRepository<DokterOp, Long> {
	List<DokterOp> findTop20ByOrderByDokterAsc();
	List<DokterOp> findTop20ByDokterContainingIgnoreCaseOrderByDokterAsc(String keyword);
	List<DokterOp> findTop20ByDokterOpContainingIgnoreCaseOrderByDokterAsc(String keywordOp);
	Optional<DokterOp> findByKdBPJSIgnoreCase(String kdBPJS);
}
