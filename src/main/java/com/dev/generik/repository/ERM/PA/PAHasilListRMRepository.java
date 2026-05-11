package com.dev.generik.repository.ERM.PA;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dev.generik.entities.ERM.PA.PAHasilListRM;

public interface PAHasilListRMRepository extends JpaRepository<PAHasilListRM, Long> {
	
	//@Query(value = "CALL wsLabHasilBatas_SP", nativeQuery = true)
	//@Query(value = "EXEC wsLabHasilList_SP:idreg", nativeQuery = true)
	@Query(value = "EXEC RiwayatLaboratPA_SP:rm", nativeQuery = true)
	List<PAHasilListRM> findByrm(@Param("rm") String rm);
}
