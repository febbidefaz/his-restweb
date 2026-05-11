package com.dev.generik.repository.ERM.JadOp;

import java.sql.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.dev.generik.entities.ERM.JadOp.JadOp;

public interface JadOpRepository extends JpaRepository<JadOp, Long> {
	
	List<JadOp>findByid(Long id);
	List<JadOp> findByTanggalBetween(Date start, Date end);
	List<JadOp> findByTanggal(Date start);
	
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