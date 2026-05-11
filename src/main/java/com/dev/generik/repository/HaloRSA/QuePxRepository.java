package com.dev.generik.repository.HaloRSA;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.generik.entities.HaloRSA.QuePx;

public interface QuePxRepository extends JpaRepository<QuePx, String> {
	List<QuePx> findByJp(Long jp);
}
