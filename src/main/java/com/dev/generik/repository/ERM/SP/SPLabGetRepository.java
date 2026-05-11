package com.dev.generik.repository.ERM.SP;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dev.generik.entities.ERM.SP.SPLabGet;

public interface SPLabGetRepository extends JpaRepository<SPLabGet, Long> {
	
	//<SPLab>findByNo(Long no);
		
}