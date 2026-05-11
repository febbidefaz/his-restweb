package com.dev.generik.repository.ERM.Lab;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dev.generik.entities.ERM.Lab.LabHasilAll;

public interface LabHasilAllRepository extends JpaRepository<LabHasilAll, Long> {
	
	//@Query(value = "CALL wsLabHasilBatas_SP", nativeQuery = true)
	@Query(value = "EXEC LaboratResultKwitIDReg_SP:IDReg", nativeQuery = true)
	List<LabHasilAll> findByIdreg(@Param("IDReg") Long IDReg);
}