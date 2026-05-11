package com.dev.generik.repository.ERM.Rad;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dev.generik.entities.ERM.Rad.RadHasilList;

public interface RadHasilListRepository extends JpaRepository<RadHasilList, Long> {
	
	//@Query(value = "CALL wsLabHasilBatas_SP", nativeQuery = true)
	@Query(value = "EXEC wsRadHasilList_SP:idreg", nativeQuery = true)
	List<RadHasilList> findByidreg(@Param("idreg") Long idreg);
}
