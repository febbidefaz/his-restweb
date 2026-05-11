package com.dev.generik.repository.HaloRSA;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.generik.entities.HaloRSA.RiwayatReg;

public interface RiwayatRegRepository extends JpaRepository<RiwayatReg, Long> {
	List<RiwayatReg> findByuserid(String userid);
}
