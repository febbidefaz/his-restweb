package com.dev.generik.repository.ERM.PA;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dev.generik.entities.ERM.PA.SPPADet;

public interface SPPADetRepository extends JpaRepository<SPPADet, Long> {
	List<SPPADet>findByNo(Long No);
	List<SPPADet>findByid(Long id);

}