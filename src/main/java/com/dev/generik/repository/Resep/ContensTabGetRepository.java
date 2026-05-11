package com.dev.generik.repository.Resep;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import com.dev.generik.entities.ERM.Resep.ContensTabClass;
import com.dev.generik.entities.ERM.Resep.ContensTabGet;
import jakarta.transaction.Transactional;

public interface ContensTabGetRepository extends JpaRepository<ContensTabGet, ContensTabClass> {
	
	List<ContensTabGet>findById(Long id);
	List<ContensTabGet>findByIdAndMfdtd(Long id, String mfdtd);

	@Modifying
    @Transactional 
	 void deleteById(Long id);
}
