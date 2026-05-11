package com.dev.generik.repository.RJ;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.format.annotation.DateTimeFormat;
//import org.springframework.stereotype.Repository;

import com.dev.generik.entities.RJ.TaskIDIRJ;

//@Repository
public interface TaskIDIRJRepository extends JpaRepository<TaskIDIRJ, Long> {
	Optional<List<TaskIDIRJ>> findByDokterid(Long Dokterid);
	
	Optional<List<TaskIDIRJ>> findByDokteridAndDateBetween(
			Long Dokterid,
			@DateTimeFormat(pattern="yyyy-MM-dd") Date bdate,
			@DateTimeFormat(pattern="yyyy-MM-dd") Date edate); 

	Optional<List<TaskIDIRJ>> findBySublayananidAndDateBetween(
			Long sublayananid,
			@DateTimeFormat(pattern="yyyy-MM-dd") Date bdate,
			@DateTimeFormat(pattern="yyyy-MM-dd") Date edate); 
}
