package com.dev.generik.repository.JadwalDokter;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.generik.entities.JadwalDokter.JadwalDokterPrak;

public interface JadwalDokterPrakRepository extends JpaRepository<JadwalDokterPrak, Long> {
	List<JadwalDokterPrak> findByDrAndHr(Long dr, Long hr);

}
