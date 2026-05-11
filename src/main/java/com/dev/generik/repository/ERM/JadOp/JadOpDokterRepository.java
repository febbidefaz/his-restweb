package com.dev.generik.repository.ERM.JadOp;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.dev.generik.entities.ERM.JadOp.JadOpDokter;

public interface JadOpDokterRepository extends JpaRepository<JadOpDokter, Long> {
	
	//@Query(value = "CALL wsLabHasilBatas_SP", nativeQuery = true)
	@Query(value = "EXEC cboDokter_SP", nativeQuery = true)
	List<JadOpDokter> findAll();
//	@Query(value = "EXEC wsLabHasilList_SP:idreg", nativeQuery = true)
//	List<JadOpDokter> findByidreg(@Param("idreg") Long idreg);
}
