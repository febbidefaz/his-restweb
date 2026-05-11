package com.dev.generik.repository.Resep;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import com.dev.generik.entities.ERM.Resep.ObAtRspTemplate;
import com.dev.generik.entities.ERM.Resep.ObAtRspTemplateClass;

import jakarta.transaction.Transactional;



public interface ObAtRspTemplateRepository extends JpaRepository<ObAtRspTemplate, ObAtRspTemplateClass> {
	List<ObAtRspTemplate>findById(Long id);
	@Modifying
    @Transactional 
	void deleteById(Long id);
}
