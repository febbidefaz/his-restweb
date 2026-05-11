package com.dev.generik.repository.ERM.IGD;

//import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.query.Procedure;
//import org.springframework.data.repository.query.Param;

import com.dev.generik.entities.ERM.IGD.SkriningCovid.ERMIGDSkriningCovidPost;

public interface ERMIGDSkriningCovidPostRepository extends JpaRepository<ERMIGDSkriningCovidPost, Long> {
/*	@Procedure(name = "UpdateSkriningCovid")
	void updateSPLab(
			@Param("Id") Long Id, 
			@Param("Tanggal") Date Tanggal, 
			@Param("TandaNGejala") Boolean TandaNGejala,
			@Param("Riwayat") Boolean Riwayat, 
			@Param("Demam") Boolean Demam,			
			@Param("Kel") Boolean Kel,
			@Param("Suhu") Boolean Suhu,
			@Param("Gejala") Boolean Gejala,
			@Param("Ratio") Boolean Ratio
			); */
}
