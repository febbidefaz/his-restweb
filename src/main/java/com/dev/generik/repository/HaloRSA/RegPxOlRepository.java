package com.dev.generik.repository.HaloRSA;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.generik.entities.HaloRSA.RegPxOLNew;

public interface RegPxOlRepository extends JpaRepository<RegPxOLNew, Long> {
	List<RegPxOLNew> findByuserid(String userid);
}
