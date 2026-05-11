package com.dev.generik.repository.ERM.IGD;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.generik.entities.ERM.IGD.ERMIGDObservasi;

public interface ERMIGDObservasiRepository extends JpaRepository<ERMIGDObservasi, Long> {
	List<ERMIGDObservasi> findByNo(Long no);
}
