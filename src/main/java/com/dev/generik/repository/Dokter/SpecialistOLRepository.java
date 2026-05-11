package com.dev.generik.repository.Dokter;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.generik.entities.Dokter.SpecialistOL;

public interface SpecialistOLRepository extends JpaRepository<SpecialistOL, Long> {
//	List<Reg> findByreg(String reg);
}
