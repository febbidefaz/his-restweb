package com.dev.generik.repository.ERM.JadOp;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.dev.generik.entities.ERM.JadOp.JadOpStatus;
public interface JadOpStatusRepository extends JpaRepository<JadOpStatus, Long> {
	
	//@Query(value = "CALL wsLabHasilBatas_SP", nativeQuery = true)
	@Query(value = "EXEC cboStatusOP_SP", nativeQuery = true)
	List<JadOpStatus> findAll();
//	@Query(value = "EXEC wsLabHasilList_SP:idreg", nativeQuery = true)
//	List<JadOpDokter> findByidreg(@Param("idreg") Long idreg);
}
