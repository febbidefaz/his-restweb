package com.dev.generik.repository.ERM.HPP;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.dev.generik.entities.ERM.IGD.SkriningHPPVK.ERMIGDVKHPPDet;
import com.dev.generik.entities.ERM.IGD.SkriningHPPVK.ERMIGDVKHPPDetClass;

public interface ERMIGDVKHPPDetRepository extends JpaRepository<ERMIGDVKHPPDet, ERMIGDVKHPPDetClass> {
	// List<FlowDet> findById(FlowDet key);
	@Procedure(name = "UpdateERMRisikoHPPAdmisiNPersalinanDet")
	ERMIGDVKHPPDet UpdateERMRisikoHPPAdmisiNPersalinanDet(
			@Param("id") Long id, 
			@Param("nama") Long nama, 
	//		@Param("kel") Long kel,
			@Param("ket") Boolean ket

			);
	List<ERMIGDVKHPPDet>findByid(Long id);
	Optional<ERMIGDVKHPPDet>findById(Long id);
//	Optional<List<ERMIGDVKHPPDet>>findByidd(Long id);
	List<ERMIGDVKHPPDet>findByKel(Long id);
//	Optional<ERMIGDVKHPPDet>findByIdAndKel(Long id, Long kel );
	List<ERMIGDVKHPPDet>findByIdAndKel(Long id, Long kel );
	List<ERMIGDVKHPPDet>findByNamaAndKel(Long nama, Long kel );
}
