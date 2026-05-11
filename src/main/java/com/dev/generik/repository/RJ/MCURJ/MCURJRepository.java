package com.dev.generik.repository.RJ.MCURJ;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dev.generik.entities.RJ.MCU.MCURJ;

public interface MCURJRepository extends JpaRepository<MCURJ, Long> {
	//List<ListPxRJNow> findByJp(Long jp);

}
