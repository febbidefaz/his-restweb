package com.dev.generik.repository.ERM.JadOp;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.dev.generik.entities.ERM.JadOp.JadOpDiag;

public interface JadOpDiagRepository extends JpaRepository<JadOpDiag, Long> {
	
	List<JadOpDiag> findTop20ByOrderByNamaAsc();
	List<JadOpDiag> findByNamaContainingIgnoreCaseOrderByNamaAsc(String initial);
	List<JadOpDiag> findByInitialContainingIgnoreCaseOrderByInitialAsc(String keyword);
	

}
