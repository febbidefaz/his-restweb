package com.dev.generik.repository.JadwalDokter;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.generik.entities.JadwalDokter.JadwalDokterHr;

public interface JadwalDokterHrRepository extends JpaRepository<JadwalDokterHr, Long> {
	List<JadwalDokterHr> findBydr(Long dr);

}
