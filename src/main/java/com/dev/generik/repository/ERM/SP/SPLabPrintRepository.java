package com.dev.generik.repository.ERM.SP;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.dev.generik.entities.ERM.SP.SPLabPrint;

public interface SPLabPrintRepository extends JpaRepository<SPLabPrint, Long> {
	
	//@Query(value = "CALL wsLabHasilBatas_SP", nativeQuery = true)
	@Query(value = "EXEC LapSPLaboratWS_SP:N", nativeQuery = true)
	List<SPLabPrint> findByNo(@Param("N") Long no);
}
