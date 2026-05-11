package com.dev.generik.repository.Other;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.dev.generik.entities.Other.UPx;

public interface UPxRepository extends JpaRepository<UPx, Long> {
	
	@Query(value = "EXEC cboUpx_sp", nativeQuery = true)
	List<UPx> getSP();
}
