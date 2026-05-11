package com.dev.generik.repository.ERM.Lab;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dev.generik.entities.ERM.Lab.LabHasilBatasList;

public interface LabHasilBatasListRepository extends JpaRepository<LabHasilBatasList, Long> {
	
	//@Query(value = "CALL wsLabHasilBatas_SP", nativeQuery = true)
	@Query(value = "EXEC wsLabHasilList_SP:idreg", nativeQuery = true)
	List<LabHasilBatasList> findByidreg(@Param("idreg") Long idreg);
}
