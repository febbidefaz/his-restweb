package com.dev.generik.repository.Lab;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.generik.entities.Lab.PCRExternalCus;

public interface PCREkternalCusRepository extends JpaRepository<PCRExternalCus, Long> {

	List<PCRExternalCus> findByInstansi(Long instansi);
}
