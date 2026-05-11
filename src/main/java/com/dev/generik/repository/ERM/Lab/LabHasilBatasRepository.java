package com.dev.generik.repository.ERM.Lab;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.generik.entities.ERM.Lab.LabHasilBatas;

public interface LabHasilBatasRepository extends JpaRepository<LabHasilBatas, Long> {
	List<LabHasilBatas> findByidlab(Long idlab);
}
