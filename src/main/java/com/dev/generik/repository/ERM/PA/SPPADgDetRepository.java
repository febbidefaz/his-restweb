package com.dev.generik.repository.ERM.PA;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import com.dev.generik.entities.ERM.PA.SPPADgDet;

public interface SPPADgDetRepository extends JpaRepository<SPPADgDet, Long> {
	
	List<SPPADgDet>findByid(Long id);
//	List<SPPADgDet>findByNo(Long No);
//	List<SPPADgDet>findByNoAndPerik(Long No, Long Perik);
	
	//<SPLab>findByNo(Long no);
	
	@Procedure(name = "UpdateSPPA1")
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
			);
}