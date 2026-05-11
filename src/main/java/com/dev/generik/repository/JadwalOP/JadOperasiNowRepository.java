package com.dev.generik.repository.JadwalOP;

//import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.generik.entities.JadwalOP.JadwalOperasiNow;

public interface JadOperasiNowRepository extends JpaRepository<JadwalOperasiNow, Long> {
//	List<JadOPBPJS> findByTanggaloperasiBetween(Date bdate, Date edate);
	List<JadwalOperasiNow> findBylayanan(String lay);

	List<JadwalOperasiNow> findBydokter(String dr);
}
