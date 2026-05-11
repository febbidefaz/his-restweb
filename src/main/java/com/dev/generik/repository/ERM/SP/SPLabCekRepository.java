package com.dev.generik.repository.ERM.SP;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dev.generik.entities.ERM.SP.SPLabCek;

public interface SPLabCekRepository extends JpaRepository<SPLabCek, Long> {
	
	//<SPLab>findByNo(Long no);

}