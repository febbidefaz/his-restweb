package com.dev.generik.repository.ERM.Billing;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.dev.generik.entities.ERM.Billing.RekOperasi;

public interface RekOperasiRepository extends JpaRepository<RekOperasi, Long>{
	

	@Query(value = "EXEC wsOperasiRawatInap_SP:ID", nativeQuery = true)
	List<RekOperasi> findByid(@Param("ID") Long ID);
}
