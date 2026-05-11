package com.dev.generik.repository.JadwalOP;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.generik.entities.JadwalOP.JadOPBPJS;

public interface JadOPBPJSRepository extends JpaRepository<JadOPBPJS, Long> {
	List<JadOPBPJS> findByTanggaloperasiBetween(Date bdate, Date edate);
}
