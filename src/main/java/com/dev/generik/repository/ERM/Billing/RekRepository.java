package com.dev.generik.repository.ERM.Billing;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.dev.generik.entities.ERM.Billing.Rek;

public interface RekRepository extends JpaRepository<Rek, Long> {
	
	//@Query(value = "CALL wsLabHasilBatas_SP", nativeQuery = true)
	@Query(value = "EXEC RekeningRawatInap_SP:ID", nativeQuery = true)
	Optional<Rek> findById(@Param("ID") Long ID);
}