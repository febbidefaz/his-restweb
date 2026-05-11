package com.dev.generik.repository.ERM.Rad;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.dev.generik.entities.ERM.Rad.RadHasilAll;

public interface RadHasilAllRepository extends JpaRepository<RadHasilAll, Long> {
	
	//@Query(value = "CALL wsLabHasilBatas_SP", nativeQuery = true)
	@Query(value = "EXEC RadiologiResultKwitAllTes_SP:ID", nativeQuery = true)
	List<RadHasilAll> findByIdreg(@Param("ID") Long ID);
}