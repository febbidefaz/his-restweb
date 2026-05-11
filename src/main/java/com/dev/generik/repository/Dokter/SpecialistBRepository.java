package com.dev.generik.repository.Dokter;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.generik.entities.Dokter.SpecialistB;

public interface SpecialistBRepository extends JpaRepository<SpecialistB, Long> {
//	List<Reg> findByreg(String reg);
}
