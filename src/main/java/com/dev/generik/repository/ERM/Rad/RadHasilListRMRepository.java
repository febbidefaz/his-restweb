package com.dev.generik.repository.ERM.Rad;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dev.generik.entities.ERM.Rad.RadHasilListRM;

public interface RadHasilListRMRepository extends JpaRepository<RadHasilListRM, Long> {
	
	//@Query(value = "CALL wsLabHasilBatas_SP", nativeQuery = true)
	//@Query(value = "EXEC wsLabHasilList_SP:idreg", nativeQuery = true)
	@Query(value = "EXEC RiwayatRadiologi_SP:rm", nativeQuery = true)
	List<RadHasilListRM> findByrm(@Param("rm") String rm);
}
