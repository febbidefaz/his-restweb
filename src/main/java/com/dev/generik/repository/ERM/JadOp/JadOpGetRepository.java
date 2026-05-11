package com.dev.generik.repository.ERM.JadOp;

import java.sql.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.dev.generik.entities.ERM.JadOp.JadOpGet;

public interface JadOpGetRepository extends JpaRepository<JadOpGet, Long> {
	
	List<JadOpGet>findByid(Long id);
	List<JadOpGet> findByTanggalBetween(Date start, Date end);
	List<JadOpGet> findByTanggal(Date start);
	
	//<SPLab>findByNo(Long no);
	
/*	@Procedure(name = "UpdateSPPA")
	void updateSPLab(
			@Param("NO") Long no,
			@Param("ID") Long id, 
			@Param("IDDokter") Long iddokter, 
			@Param("TGL") Date tgl, 
			@Param("Jam") Date jam, 
			@Param("KelasID") Long KelasID,
			@Param("RoomID") Long RoomID,
			@Param("LokasiOrgan") String LokasiOrgan, 
			@Param("DiagnosaKlinik") String DiagnosaKlinik, 
			@Param("Fiksatif") String Fiksatif, 
			@Param("Biopsi") String Biopsi, 
			@Param("Sputurn") String Sputurn, 
			@Param("JamOp") Date JamOp,
			@Param("JamSampel") Date JamSampel,
			@Param("KetKlinik") String KetKlinik, 
			@Param("RiwayatLab") String RiwayatLab 
	//		@Param("KetCancel") Long KetCancel
			); */
}