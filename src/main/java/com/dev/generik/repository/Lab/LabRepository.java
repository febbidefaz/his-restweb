package com.dev.generik.repository.Lab;

import java.util.List;
import java.util.Optional;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.generik.entities.Lab.Lab;

public interface LabRepository extends JpaRepository<Lab, Long> {
	List<Lab> findByid(Long id);

	Optional<List<Lab>> findByIdAndRmAndTgllhr(Long id, String rm, Date tgllhr);

}
