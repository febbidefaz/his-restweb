package com.dev.generik.models.Rad;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
public class RadHasilAllModel {
	
	 private Long idd;
	 private Long idrad;
	 private Long idreg;
	 private String regNum;
	 private Long th;                  // umur (tahun)
	 private Long bln;                 // umur (bulan)
	 private Long hr;                  // umur (hari)	
	 private Long alatid; 
	 private String alatname;
	 private String nama;
	 private String addr;
	 private String kelurahan;
	 private String jenisKelamin;
	 private String dokter;
	 private String klas;
	 private LocalDateTime trad;
	 private LocalDate tanggalLahir;
	 private String usr;
	 private String shift;
	 private String details;
	 private String dr;
	 private byte[] ttd;
	 
	 private List<RadHasilAllPerikModel> periks;
}
