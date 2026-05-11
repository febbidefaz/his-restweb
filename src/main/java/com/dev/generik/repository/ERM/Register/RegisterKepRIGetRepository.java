package com.dev.generik.repository.ERM.Register;

import java.util.List;
//import java.util.Optional;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dev.generik.entities.ERM.Register.RegisterKepRIGet;
import com.dev.generik.entities.ERM.Register.RegisterKepRIGetClass;

public interface RegisterKepRIGetRepository extends JpaRepository<RegisterKepRIGet, RegisterKepRIGetClass> {
	List<RegisterKepRIGet> findByid(Long no);
	Optional<RegisterKepRIGet> findById(Long id);

	List<RegisterKepRIGet> findAllById(Long id);
}
