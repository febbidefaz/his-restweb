package com.dev.generik.repository.Lab;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.generik.entities.Lab.LabHasilLevel;

public interface LabHasilLevelRepository extends JpaRepository<LabHasilLevel, Long> {
	List<LabHasilLevel> findBylvl(Long lvl);
}
