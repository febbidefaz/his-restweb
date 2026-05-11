package com.dev.generik.repository.ERM.HPP;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dev.generik.entities.ERM.IGD.SkriningHPPVK.ERMIGDVKHPPKel;

public interface ERMIGDVKHPPKelRepository extends JpaRepository<ERMIGDVKHPPKel, Long> {
	// List<FlowDet> findById(FlowDet key);
	/*@Procedure(name = "UpdateLogGiziFlowDet")
	FlowDet updateFlowDet(
			@Param("id") Long id, 
			@Param("productID") String productID, 
			@Param("qty") Long qty 

			);*/
//	List<ERMIGDVKHPPNama>findByid(Long id);
}
