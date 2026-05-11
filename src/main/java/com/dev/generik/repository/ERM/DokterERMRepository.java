package com.dev.generik.repository.ERM;

import java.util.List;
//import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.generik.entities.ERM.DokterERM;

public interface DokterERMRepository extends JpaRepository<DokterERM, Long> {
	List<DokterERM> findBySp(Long sp);
	// Optional<List<Dokter>> findByUserAndPass(String user, String pass );

}
