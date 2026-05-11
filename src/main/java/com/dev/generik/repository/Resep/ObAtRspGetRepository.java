package com.dev.generik.repository.Resep;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import com.dev.generik.entities.ERM.Resep.ObAtRspClass;
import com.dev.generik.entities.ERM.Resep.ObAtRspGet;
import jakarta.transaction.Transactional;

public interface ObAtRspGetRepository extends JpaRepository<ObAtRspGet, ObAtRspClass> {

	List<ObAtRspGet>findById(Long id);
	@Modifying
    @Transactional 
	void deleteById(Long id);
}
