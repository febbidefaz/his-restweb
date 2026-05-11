package com.dev.generik.repository.ERM.IGD;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.generik.entities.ERM.IGD.ERMIGDObservasiCPPT;

public interface ERMIGDObservasiCPPTRepository extends JpaRepository<ERMIGDObservasiCPPT, Long> {
	List<ERMIGDObservasiCPPT> findByNo(Long no);
}
