package com.dev.generik.repository.ERM.Lab;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dev.generik.entities.ERM.Lab.LabHasilBatasSP;

public interface LabHasilBatasSPRepository extends JpaRepository<LabHasilBatasSP, Long> {
	
	//@Query(value = "CALL wsLabHasilBatas_SP", nativeQuery = true)
	@Query(value = "EXEC wsLabHasilBatas_SP:idlab", nativeQuery = true)
	List<LabHasilBatasSP> findByidlab(@Param("idlab") Long idlab);
}
