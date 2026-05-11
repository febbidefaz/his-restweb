package com.dev.generik.repository.ERM.Billing;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.dev.generik.entities.ERM.Billing.RekRadiologi;

public interface RekRadiologiRepository extends JpaRepository<RekRadiologi, Long>{
	

	@Query(value = "EXEC wsRadiologiRawatInap_SP:ID", nativeQuery = true)
	List<RekRadiologi> findByid(@Param("ID") Long ID);
}
