package com.dev.generik.repository.ERM.Billing;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.dev.generik.entities.ERM.Billing.RekObat;

public interface RekObatRepository extends JpaRepository<RekObat, Long>{
	

	@Query(value = "EXEC wsObatRawatInap_SP:ID", nativeQuery = true)
	List<RekObat> findByid(@Param("ID") Long ID);
}
