package com.dev.generik.repository.Resep;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import com.dev.generik.entities.ERM.Resep.ContensTab;
import com.dev.generik.entities.ERM.Resep.ContensTabClass;

import jakarta.transaction.Transactional;

public interface ContensTabRepository extends JpaRepository<ContensTab, ContensTabClass> {
	// List<FlowDet> findById(FlowDet key);
/*	@Procedure(name = "UpdateLogGiziFlowDet")
	FlowDet updateFlowDet(
			@Param("id") Long id, 
			@Param("productID") String productID, 
			@Param("qty") Long qty  

			); */
	List<ContensTab>findById(Long id);
//	List<ContensTab>findByMfdtd(String mfdtd);
	//@Query("SELECT c FROM ContensTab c WHERE c.id = :id AND c.mfdtd = :mfdtd")
	List<ContensTab>findByIdAndMfdtd(Long id, String mfdtd);
	//@Query("SELECT c FROM ContensTab c WHERE c.id = :id AND c.kode = :kode")
	//List<ContensTab> findByIdAndKode(Long id, String kode);
	@Modifying
    @Transactional 
	 void deleteById(Long id);
}
