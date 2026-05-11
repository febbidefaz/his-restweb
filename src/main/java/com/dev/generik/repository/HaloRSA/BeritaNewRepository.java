package com.dev.generik.repository.HaloRSA;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.dev.generik.entities.HaloRSA.BeritaNew;

public interface BeritaNewRepository extends JpaRepository<BeritaNew, Long> {
	@Procedure(name = "UpdateBerita")
	void updateBerita(@Param("beritaid") Long beritaid, @Param("tanggal") Date tanggal, @Param("isi") String isi,
			@Param("fotojudul") String fotojudul, @Param("foto1") String foto1, @Param("foto2") String foto2,
			@Param("foto3") String foto3, @Param("foto4") String foto4, @Param("slide") String slide);
}