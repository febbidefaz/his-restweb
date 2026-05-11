package com.dev.generik.repository.Resep;

import java.util.List;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.query.Procedure;
//import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Modifying;

import com.dev.generik.entities.ERM.Resep.ObAtRsp;
import com.dev.generik.entities.ERM.Resep.ObAtRspClass;

import jakarta.transaction.Transactional;



public interface ObAtRspRepository extends JpaRepository<ObAtRsp, ObAtRspClass> {
	// List<FlowDet> findById(FlowDet key);
/*	@Procedure(name = "UpdateLogGiziFlowDet")
	FlowDet updateFlowDet(
			@Param("id") Long id, 
			@Param("productID") String productID, 
			@Param("qty") Long qty  

			); */
	List<ObAtRsp>findById(Long id);
	@Modifying
    @Transactional 
	void deleteById(Long id);
}
