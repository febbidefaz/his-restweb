package com.dev.generik.repository.Resep;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import com.dev.generik.entities.ERM.Resep.ContensTabTemplate;
import com.dev.generik.entities.ERM.Resep.ContensTabTemplateClass;
import jakarta.transaction.Transactional;

public interface ContensTabTemplateRepository extends JpaRepository<ContensTabTemplate, ContensTabTemplateClass> {

	List<ContensTabTemplate>findById(Long id);
	List<ContensTabTemplate>findByIdAndMfdtd(Long id, String mfdtd);
	@Modifying
    @Transactional 
	 void deleteById(Long id);
}
