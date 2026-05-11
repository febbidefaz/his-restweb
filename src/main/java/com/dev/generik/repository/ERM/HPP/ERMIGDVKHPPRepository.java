package com.dev.generik.repository.ERM.HPP;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.dev.generik.entities.ERM.IGD.SkriningHPPVK.ERMIGDVKHPP;

public interface ERMIGDVKHPPRepository extends JpaRepository<ERMIGDVKHPP, Long> {
	// List<FlowDet> findById(FlowDet key);
	@Procedure(name = "UpdateERMIGDVKHPP")
	ERMIGDVKHPP UpdateERMIGDVKHPP(
			@Param("id") Long id, 
			@Param("tanggal") Date tanggal, 
			@Param("kel") Long kel 

			);
//	List<ERMIGDVKHPPNama>findByid(Long id);
	List<ERMIGDVKHPP>findByIdAndKel(Long id, Long kel);
}
