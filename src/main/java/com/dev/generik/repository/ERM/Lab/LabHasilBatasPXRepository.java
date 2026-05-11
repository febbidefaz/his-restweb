package com.dev.generik.repository.ERM.Lab;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.generik.entities.ERM.Lab.LabHasilBatasPX;

public interface LabHasilBatasPXRepository extends JpaRepository<LabHasilBatasPX, Long> {
	List<LabHasilBatasPX> findByidlab(Long idlab);
}
