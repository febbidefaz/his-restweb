package com.dev.generik.repository.Gizi;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.dev.generik.entities.Gizi.Flow;

public interface FlowRepository extends JpaRepository<Flow, Long> {
	
	@Procedure(name = "UpdateLogGiziFlow")
	void updateFlow(
			@Param("id") Long id, 
			@Param("flowTgl") Date flowTgl, 
			@Param("jam") Date jam 

			);
}
