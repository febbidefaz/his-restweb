package com.dev.generik.repository.ERM.Billing;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.dev.generik.entities.ERM.Billing.RekTindakan;

public interface RekTindakanRepository extends JpaRepository<RekTindakan, Long>{
	

	@Query(value = "EXEC wsTindakanRawatInap_SP:ID", nativeQuery = true)
	List<RekTindakan> findByid(@Param("ID") Long ID);
}
