package com.dev.generik.repository.PSDI;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.dev.generik.entities.PSDI.DiklatNew;

public interface DiklatNewRepository extends JpaRepository<DiklatNew, Long> {
	@Procedure(name = "UpdateDiklat")
	void updateDiklat(
			@Param("diklatid") Long diklatid, 
			@Param("tanggal") Date tanggal, 
			@Param("isi") String isi,
			@Param("fotojudul") String fotojudul, 
			@Param("foto1") String foto1, 
			@Param("foto2") String foto2,
			@Param("foto3") String foto3, 
			@Param("foto4") String foto4, 
			@Param("pdf1") String pdf1,
			@Param("pdf2") String pdf2, 
			@Param("pdf3") String pdf3, 
			@Param("pdf4") String pdf4
			);
}