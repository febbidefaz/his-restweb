package com.dev.generik.repository.Resep;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import com.dev.generik.entities.ERM.Resep.ContensTabTemplateClass;
import com.dev.generik.entities.ERM.Resep.ContensTabTemplateGet;

import jakarta.transaction.Transactional;

public interface ContensTabTemplateGetRepository extends JpaRepository<ContensTabTemplateGet, ContensTabTemplateClass> {

	List<ContensTabTemplateGet>findById(Long id);
	List<ContensTabTemplateGet>findByIdAndMfdtd(Long id, String mfdtd);
	@Modifying
    @Transactional 
	 void deleteById(Long id);
}
