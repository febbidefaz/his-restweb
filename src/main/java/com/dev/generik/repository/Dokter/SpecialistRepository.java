package com.dev.generik.repository.Dokter;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.generik.entities.Dokter.Specialist;

public interface SpecialistRepository extends JpaRepository<Specialist, Long> {
//	List<Reg> findByreg(String reg);
}
