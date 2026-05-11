package com.dev.generik.repository.TB;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.format.annotation.DateTimeFormat;

import com.dev.generik.entities.TB.TBScreaningRI;

public interface TBScreaningRIRepository extends JpaRepository<TBScreaningRI, Long> {
	Optional<List<TBScreaningRI>> findByRiAndTanggalBetween(
			Long ri,
			@DateTimeFormat(pattern="yyyy-MM-dd") Date bdate,
			@DateTimeFormat(pattern="yyyy-MM-dd") Date edate); 
}
