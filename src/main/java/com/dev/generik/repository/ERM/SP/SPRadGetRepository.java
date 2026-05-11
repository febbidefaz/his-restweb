package com.dev.generik.repository.ERM.SP;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dev.generik.entities.ERM.SP.SPRadGet;

public interface SPRadGetRepository extends JpaRepository<SPRadGet, Long> {
	
	//<SPLab>findByNo(Long no);
		
}