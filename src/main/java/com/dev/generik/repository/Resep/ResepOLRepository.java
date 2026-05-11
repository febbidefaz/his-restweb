package com.dev.generik.repository.Resep;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.query.Procedure;
//import org.springframework.data.repository.query.Param;

import com.dev.generik.entities.ERM.Resep.ResepOL;

public interface ResepOLRepository extends JpaRepository<ResepOL, Long> {
	
	/*@Procedure(name = "UpdateLogGiziFlow")
	void updateFlow(
			@Param("id") Long id, 
			@Param("flowTgl") Date flowTgl, 
			@Param("jam") Date jam 

			);*/
	//<ResepOL>findById(Long id);
	List<ResepOL>findByIdReg(Long idReg);
}
