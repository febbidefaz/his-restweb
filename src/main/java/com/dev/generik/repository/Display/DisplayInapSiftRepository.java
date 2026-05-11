package com.dev.generik.repository.Display;

import java.util.List;
//import java.util.Optional;
//import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.generik.entities.display.DisplayInapSift;

public interface DisplayInapSiftRepository extends JpaRepository<DisplayInapSift, String> {
	//List<DisplayInap> findByUser(String User);
	List<DisplayInapSift> findByUser(String us);
	List<DisplayInapSift> findByUserAndSift(String us, String sift);
//	public List<Optional<DisplayInap>> findByUser(String user);
	// Optional<List<Dokter>> findByUserAndPass(String user, String pass );

}
