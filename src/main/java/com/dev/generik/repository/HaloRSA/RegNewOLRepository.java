package com.dev.generik.repository.HaloRSA;

import java.util.Date;
import java.util.Optional;

//import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.dev.generik.entities.HaloRSA.RegNewOL;

public interface RegNewOLRepository extends JpaRepository<RegNewOL, Long> {
	@Procedure(name = "UpdateOLTherapy")
	void updateBerita(@Param("regid") Long regid, @Param("buktitransfer") String buktitransfer,
			@Param("status") Long status);

	Optional<RegNewOL> findByDokteridAndTglAndRegisterAndJampraktekAndSublayanan(long dokterid, Date tgl,
			String register, long jamprak, String sublayanan);
}
