package com.dev.generik.repository.ERM.Lab;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.generik.entities.ERM.Lab.LabHasilBatasPXCek;

public interface LabHasilBatasCekRepository extends JpaRepository<LabHasilBatasPXCek, Long> {
	List<LabHasilBatasPXCek> findByidlab(Long idlab);
}
