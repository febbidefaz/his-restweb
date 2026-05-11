package com.dev.generik.repository.HaloRSA;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.generik.entities.HaloRSA.Reg;

public interface RegRepository extends JpaRepository<Reg, Long> {
	List<Reg> findByreg(String reg);
}
