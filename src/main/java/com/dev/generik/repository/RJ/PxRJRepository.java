package com.dev.generik.repository.RJ;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.generik.entities.RJ.PxRJ;

public interface PxRJRepository extends JpaRepository<PxRJ, Long> {
	List<PxRJ> findByPxId(Long pxid);
}
