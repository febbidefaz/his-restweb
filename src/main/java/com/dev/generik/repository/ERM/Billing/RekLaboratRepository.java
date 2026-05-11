package com.dev.generik.repository.ERM.Billing;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dev.generik.entities.ERM.Billing.RekLaborat;

public interface RekLaboratRepository extends JpaRepository<RekLaborat, Long>{
	

	@Query(value = "EXEC wsLaboratRawatInap_SP:ID", nativeQuery = true)
	List<RekLaborat> findByid(@Param("ID") Long ID);
}
