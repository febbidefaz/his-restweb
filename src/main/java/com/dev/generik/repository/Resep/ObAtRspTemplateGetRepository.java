package com.dev.generik.repository.Resep;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import com.dev.generik.entities.ERM.Resep.ObAtRspTemplateClass;
import com.dev.generik.entities.ERM.Resep.ObAtRspTemplateGet;

import jakarta.transaction.Transactional;

public interface ObAtRspTemplateGetRepository extends JpaRepository<ObAtRspTemplateGet, ObAtRspTemplateClass> {
	List<ObAtRspTemplateGet>findById(Long id);
	@Modifying
    @Transactional 
	void deleteById(Long id);
}
