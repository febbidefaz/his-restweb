package com.dev.generik.repository.Dokter;

//import java.util.List;
//import java.util.Optional;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.generik.entities.Dokter.LoginDokter;

public interface LoginDokterRepository extends JpaRepository<LoginDokter, Long> {
//	List<Dokter> findBySp(Long sp);
//	Optional<List<LoginDokter>> findByNameAndPass(String name, String pass);
//	Optional<List<LoginDokter>> findByName(String name);
	Optional<LoginDokter> findByNameAndPass(String user, String pass);

}
