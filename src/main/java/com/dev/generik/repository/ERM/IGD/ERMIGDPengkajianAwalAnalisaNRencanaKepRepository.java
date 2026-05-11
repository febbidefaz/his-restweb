package com.dev.generik.repository.ERM.IGD;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.generik.entities.ERM.IGD.ERMIGDPengkajianAwalAnalisaNRencanaKep;

public interface ERMIGDPengkajianAwalAnalisaNRencanaKepRepository extends JpaRepository<ERMIGDPengkajianAwalAnalisaNRencanaKep, Long> {
	List<ERMIGDPengkajianAwalAnalisaNRencanaKep> findByNo(Long no);
}
