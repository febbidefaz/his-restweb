package com.dev.generik.repository.JadwalDokter;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.generik.entities.JadwalDokter.JadwalDokterPrakLab;

public interface JadwalDokterPrakLabRepository extends JpaRepository<JadwalDokterPrakLab, Long> {
	List<JadwalDokterPrakLab> findByDrAndHr(Long dr, Long hr);

}
