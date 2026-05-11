package com.dev.generik.repository.ERM.SP;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dev.generik.entities.ERM.SP.SPRadCek;

public interface SPRadCekRepository extends JpaRepository<SPRadCek, Long> {
	
	//<SPLab>findByNo(Long no);

}