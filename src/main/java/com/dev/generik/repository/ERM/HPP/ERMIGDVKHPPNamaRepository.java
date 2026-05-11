package com.dev.generik.repository.ERM.HPP;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.dev.generik.entities.ERM.IGD.SkriningHPPVK.ERMIGDVKHPPNama;
import com.dev.generik.entities.ERM.IGD.SkriningHPPVK.ERMIGDVKHPPNamaClass;

public interface ERMIGDVKHPPNamaRepository extends JpaRepository<ERMIGDVKHPPNama, ERMIGDVKHPPNamaClass> {
	// List<FlowDet> findById(FlowDet key);
	/*@Procedure(name = "UpdateLogGiziFlowDet")
	FlowDet updateFlowDet(
			@Param("id") Long id, 
			@Param("productID") String productID, 
			@Param("qty") Long qty 

			);*/
	List<ERMIGDVKHPPNama>findByidKel(Long id);
	List<ERMIGDVKHPPNama>findByid(Long id);
}
