package com.dev.generik.repository.HaloRSA;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.generik.entities.HaloRSA.CekPx;

public interface CekPxRepository extends JpaRepository<CekPx, String> {
	Optional<List<CekPx>> findByPatientidAndDate(String patientid, Date date);
}
