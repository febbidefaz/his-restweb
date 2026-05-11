package com.dev.generik.repository.JadwalOP;

//import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.generik.entities.JadwalOP.JadwalOperasiPen;

public interface JadOperasiPenRepository extends JpaRepository<JadwalOperasiPen, Long> {
//	List<JadOPBPJS> findByTanggaloperasiBetween(Date bdate, Date edate);
	List<JadwalOperasiPen> findBylayanan(String lay);

	List<JadwalOperasiPen> findBydokter(String dr);
}
