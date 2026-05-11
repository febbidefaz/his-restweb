package com.dev.generik.repository.Dokter;

//import java.util.Date;
import java.util.Optional;

//import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.dev.generik.entities.Lab.HasilPCR;

public interface HasilPCRRepository extends JpaRepository<HasilPCR, Long> {
	@Procedure(name = "UpdateOLTherapy")
	void updateBerita(@Param("id") Long id,
			// @Param("teraphyid") Long teraphyid,
			@Param("pcr") String pcr);

	Optional<HasilPCR> findById(long id);
}
