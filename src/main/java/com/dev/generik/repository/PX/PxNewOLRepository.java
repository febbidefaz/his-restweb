package com.dev.generik.repository.PX;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.dev.generik.entities.HaloRSA.PxNewOL;

public interface PxNewOLRepository extends JpaRepository<PxNewOL, Long> {
	@Procedure(name = "UpdatePxNewOnline")
	void updatePxNewOL(@Param("pxid") Long pxid, @Param("regnum") String regum, @Param("nama") String nama,
			@Param("addr") String addr, @Param("telepon") String telepon, @Param("tlahir") Date tlahir,
			@Param("jk") String jk, @Param("pekerjaan") Integer pekerjaan, @Param("status") Integer status,
			@Param("nik") String nik, @Param("nojkn") String nojkn);
}
