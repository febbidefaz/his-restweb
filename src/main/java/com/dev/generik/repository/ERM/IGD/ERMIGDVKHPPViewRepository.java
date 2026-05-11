package com.dev.generik.repository.ERM.IGD;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.generik.entities.ERM.IGD.SkriningHPPVK.ERMIGDVKHPPView;

public interface ERMIGDVKHPPViewRepository extends JpaRepository<ERMIGDVKHPPView, Long> {
	List<ERMIGDVKHPPView> findByKode(Long kode);
}
