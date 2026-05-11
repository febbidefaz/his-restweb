package com.dev.generik.repository.ERM.PPRA;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dev.generik.entities.ERM.PPRA.ObatPPRA;


public interface ObatPPRARepository extends JpaRepository<ObatPPRA, Long> {
	
	//@Query(value = "CALL wsLabHasilBatas_SP", nativeQuery = true)
	@Query(value = "wsObatPPRA_SP:idreg", nativeQuery = true)
	List<ObatPPRA> findByid(@Param("idreg") Long idreg);
	
	//@Query(value = "EXEC wsLabHasilBatas_SP:idlab", nativeQuery = true)
	//List<LabHasilBatasSP> findByidlab(@Param("idlab") Long idlab);
}
