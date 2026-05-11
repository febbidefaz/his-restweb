package com.dev.generik.repository.PX;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.generik.entities.Inap.PxInapOnsite;

public interface PxInapOnsiteRepository extends JpaRepository<PxInapOnsite, Long> {
	List<PxInapOnsite> findByPxId(Long pxid);
}
