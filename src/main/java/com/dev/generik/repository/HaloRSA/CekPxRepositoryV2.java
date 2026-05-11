package com.dev.generik.repository.HaloRSA;

import java.util.Date;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.generik.entities.HaloRSA.CekPx;

public interface CekPxRepositoryV2 extends JpaRepository<CekPx, String> {
	Optional<CekPx> findByPatientidAndDate(String patientid, Date date);
}
