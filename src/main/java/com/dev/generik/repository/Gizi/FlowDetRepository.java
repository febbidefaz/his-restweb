package com.dev.generik.repository.Gizi;

import java.util.List;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;


import com.dev.generik.entities.Gizi.FlowDet;
import com.dev.generik.entities.Gizi.FlowDetClass;


public interface FlowDetRepository extends JpaRepository<FlowDet, FlowDetClass> {
	// List<FlowDet> findById(FlowDet key);
	@Procedure(name = "UpdateLogGiziFlowDet")
	FlowDet updateFlowDet(
			@Param("id") Long id, 
			@Param("productID") String productID, 
			@Param("qty") Long qty//, 
	//		@Param("diterima") String diterima, 
	//		@Param("ket") String ket 
			);
	List<FlowDet>findByid(Long id);
}
