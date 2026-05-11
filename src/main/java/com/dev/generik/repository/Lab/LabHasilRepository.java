package com.dev.generik.repository.Lab;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.generik.entities.Lab.LabHasil;

public interface LabHasilRepository extends JpaRepository<LabHasil, Long> {
	List<LabHasil> findByidlab(Long idlab);
}
