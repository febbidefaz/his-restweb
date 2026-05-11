package com.dev.generik.repository.Lab;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.generik.entities.Lab.PCRExternal;

public interface GeNoseRepository extends JpaRepository<PCRExternal, Long> {
//	@Procedure(name = "UpdateOLTherapy" )
//	void updateBerita(
//			@Param("regid") Long regid,
//			@Param("buktitransfer") String buktitransfer,
//			@Param("status") Long status
//	);

//	Optional<GeNoseL> findByDokteridAndTglAndRegisterAndJampraktekAndSublayanan(long dokterid,Date tgl,String register,long jamprak, String sublayanan);
}
