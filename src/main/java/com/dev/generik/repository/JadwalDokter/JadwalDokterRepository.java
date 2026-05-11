package com.dev.generik.repository.JadwalDokter;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.generik.entities.JadwalDokter.JadwalDokter;

public interface JadwalDokterRepository extends JpaRepository<JadwalDokter, Long> {
	List<JadwalDokter> findByhr(Long hr);

	List<JadwalDokter> findBydr(Long dr);

}
