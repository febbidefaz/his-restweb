package com.dev.generik.repository.Dokter;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.generik.entities.Dokter.VisitDokter;

public interface VisitDokterRepository extends JpaRepository<VisitDokter, String> {
	List<VisitDokter> findByIdpx(Long idpx);
}
