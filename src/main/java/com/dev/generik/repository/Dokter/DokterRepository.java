package com.dev.generik.repository.Dokter;

import java.util.List;
//import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.generik.entities.Dokter.Dokter;

public interface DokterRepository extends JpaRepository<Dokter, Long> {
	List<Dokter> findBySp(Long sp);
	// Optional<List<Dokter>> findByUserAndPass(String user, String pass );

}
