package com.dev.generik.repository.PX;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.generik.entities.PX.Kelurahan;

public interface LurahRepository extends JpaRepository<Kelurahan, Long> {
	List<Kelurahan> findByCamatid(Long camatid);
}
