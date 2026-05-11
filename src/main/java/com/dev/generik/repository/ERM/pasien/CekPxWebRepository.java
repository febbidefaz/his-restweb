package com.dev.generik.repository.ERM.pasien;

//import java.util.Date;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.generik.entities.ERM.Pasien.CekPxWeb;


public interface CekPxWebRepository extends JpaRepository<CekPxWeb, UUID> {
//	Optional<CekPxWeb> findByIdnAndRmAndTgl(String idn, String rm, Date tgl);
//	Optional<CekPxWeb> findByIdnAndRm(String idn, String rm);
	Optional<CekPxWeb> findByIdn(UUID idn);
}
