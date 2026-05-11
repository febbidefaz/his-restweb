package com.dev.generik.repository.Other;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.dev.generik.entities.Other.SensusIRJ;

public interface SensusIRJRepository extends JpaRepository<SensusIRJ, Long> {
	
	@Query(value = "EXEC cboSensusIRJ_sp", nativeQuery = true)
	List<SensusIRJ> getSP();
}
