package com.dev.generik.repository.Inap;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dev.generik.entities.Inap.InfoBill;

public interface InfoBillRepository extends JpaRepository<InfoBill, Integer> {
	@Query(value = "{call infoBill_sp(:idpx)}", nativeQuery = true)
	public List<InfoBill> findAllBetweenStoredProcedure(@Param("idpx") Long id);
}
