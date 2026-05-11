package com.dev.generik.repository.ERM.PA;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dev.generik.entities.ERM.PA.PAHasil;

public interface PAHasilRepository extends JpaRepository<PAHasil, Long> {
	
	//@Query(value = "CALL wsLabHasilBatas_SP", nativeQuery = true)
	//@Query(value = "EXEC wsLabHasilList_SP:idreg", nativeQuery = true)
	//@Query(value = "EXEC PAResultSourceSimply:docno", nativeQuery = true)
	@Query(value = "EXEC PAResultSourceSimply_sp:padoc", nativeQuery = true)
	List<PAHasil> findBypadoc(@Param("padoc") String padoc);
}
