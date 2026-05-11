package com.dev.generik.repository.TB;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;

import com.dev.generik.entities.TB.TB06;

public interface TB06Repository extends JpaRepository<TB06, Long> {
	@Procedure(name = "UpdateTB06")
	void updateTB06(@Param("id") Long id, 
					@Param("nodahak") String nodahak,
					@Param("tglsitb") Date tglsitb, 
					@Param("umur") Long umur,
					@Param("dirujuk") String dirujuk, 
					@Param("LokasiAnatomiPenyakit") String LokasiAnatomiPenyakit, 
					@Param("TotalSkoringTBAnak") String TotalSkoringTBAnak,
					@Param("HasilPemeriksaanFotoToraks") String HasilPemeriksaanFotoToraks, 
					@Param("StatusHIV") String StatusHIV, 
					@Param("RiwayatDM") String RiwayatDM,
					@Param("TGLPengambilanA") String TGLPengambilanA,
					@Param("TGLPengambilanB") String TGLPengambilanB,
					@Param("TGLPengambilanC") String TGLPengambilanC,
					@Param("MikroskopisTGL") String MikroskopisTGL,
					@Param("MikroskopisHA") String MikroskopisHA,
					@Param("MikroskopisHB") String MikroskopisHB,
					@Param("MikroskopisHC") String MikroskopisHC,
					@Param("XpertMTBRIFTGL") String XpertMTBRIFTGL,
					@Param("XpertMTBRIHasil") String XpertMTBRIFHasil,
					@Param("BiakanTGL") String BiakanTGL,
					@Param("BiakanHasil") String BiakanHasil,
					@Param("NoRegLabTB04") String NoRegLabTB04,
					@Param("TindakLanjutPengobatanTGL") String TindakLanjutPengobatanTGL,
					@Param("TindakLanjutPengobatanDirujuk") String TindakLanjutPengobatanDirujuk
					); 
	
	Optional<List<TB06>> findByTanggalBetween(
			@DateTimeFormat(pattern="yyyy-MM-dd") Date bdate,
			@DateTimeFormat(pattern="yyyy-MM-dd") Date edate); 
	
		
}