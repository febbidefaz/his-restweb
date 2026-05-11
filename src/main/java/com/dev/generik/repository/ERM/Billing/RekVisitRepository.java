package com.dev.generik.repository.ERM.Billing;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.dev.generik.entities.ERM.Billing.RekVisit;


public interface RekVisitRepository extends JpaRepository<RekVisit, Long>{
	

	@Query(value = "EXEC wsVisitRawatInap_SP:ID", nativeQuery = true)
	List<RekVisit> findByid(@Param("ID") Long ID);
}
