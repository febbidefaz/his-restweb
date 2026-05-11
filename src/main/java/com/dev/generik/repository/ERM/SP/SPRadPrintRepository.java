package com.dev.generik.repository.ERM.SP;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.dev.generik.entities.ERM.SP.SPRadPrint;

public interface SPRadPrintRepository extends JpaRepository<SPRadPrint, Long> {
	
	//@Query(value = "CALL wsLabHasilBatas_SP", nativeQuery = true)
	@Query(value = "EXEC LapSPRadiologiWS_SP:N", nativeQuery = true)
	List<SPRadPrint> findByNo(@Param("N") Long no);
}
