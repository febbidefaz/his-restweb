package com.dev.generik.repository.ERM.Billing;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.dev.generik.entities.ERM.Billing.RekLain;

public interface RekLainRepository extends JpaRepository<RekLain, Long>{
	

	@Query(value = "EXEC wsLainRawatInap_SP:ID", nativeQuery = true)
	List<RekLain> findByid(@Param("ID") Long ID);
}
