package com.dev.generik.repository.Inap;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.format.annotation.DateTimeFormat;
//import org.springframework.stereotype.Repository;

import com.dev.generik.entities.Inap.TracerPXPlg;

//@Repository
public interface TracerPXPlgRepository extends JpaRepository<TracerPXPlg, Long> {
	Optional<List<TracerPXPlg>> findByPavid(Long Pavid);
	
	Optional<List<TracerPXPlg>> findByPavidAndTanggalBetween(
			Long Pavid,
			@DateTimeFormat(pattern="yyyy-MM-dd") Date bdate,
			@DateTimeFormat(pattern="yyyy-MM-dd") Date edate); 

}