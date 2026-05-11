package com.dev.generik.repository.Lab;

import java.util.List;
import java.util.Optional;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.generik.entities.Lab.LabAntigen;

public interface LabAntigenRepository extends JpaRepository<LabAntigen, Long> {
//	List<Lab> findByid(Long id);
	Optional<List<LabAntigen>> findByIdregAndRmAndTgllhr(Long idreg, String rm, Date tgllhr);

}
