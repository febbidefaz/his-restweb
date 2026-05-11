package com.dev.generik.repository.Display;

import java.util.List;
//import java.util.Optional;
//import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.generik.entities.display.DisplayInap;

public interface DisplayInapRepository extends JpaRepository<DisplayInap, Long> {
	//List<DisplayInap> findByUser(String User);
	List<DisplayInap> findByUser(String us);
//	public List<Optional<DisplayInap>> findByUser(String user);
	// Optional<List<Dokter>> findByUserAndPass(String user, String pass );

}
