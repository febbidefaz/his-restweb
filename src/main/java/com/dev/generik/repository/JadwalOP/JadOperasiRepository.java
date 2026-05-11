package com.dev.generik.repository.JadwalOP;

//import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.generik.entities.JadwalOP.JadwalOperasi;

public interface JadOperasiRepository extends JpaRepository<JadwalOperasi, Long> {
//	List<JadOPBPJS> findByTanggaloperasiBetween(Date bdate, Date edate);
	List<JadwalOperasi> findBylayanan(String lay);

	List<JadwalOperasi> findBydokter(String dr);
}
