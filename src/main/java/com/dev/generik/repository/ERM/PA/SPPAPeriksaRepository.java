package com.dev.generik.repository.ERM.PA;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.dev.generik.entities.ERM.PA.SPPAPeriksa;

public interface SPPAPeriksaRepository extends JpaRepository<SPPAPeriksa, Long> {
	
	List<SPPAPeriksa>findByid(Long id);
	List<SPPAPeriksa> findTop20ByOrderByPerikAsc();
	List<SPPAPeriksa> findByPerikContainingIgnoreCaseOrderByPerikAsc(String keyword);


}