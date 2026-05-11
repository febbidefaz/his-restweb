package com.dev.generik.entities.ERM.Rad;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter 
@Setter
public class RadHasilAll {
	 @Id	
	 @Column(name = "IDD")
	 private Long idd;
	 
	 @Column(name = "IDRAD")
	 private Long idrad;
	 
	 @Column(name = "IDREG")
	 private Long idreg;
	 
	 @Column(name = "REGNUM")
	 private String regNum;
	 
	 @Column(name = "TH")
	 private Long th;                  // umur (tahun)
	 
	 @Column(name = "BLN")
	 private Long bln;                 // umur (bulan)
	 
	 @Column(name = "HR")
	 private Long hr;                  // umur (hari)	
	 
	 @Column(name = "ALATID")
	 private Long alatid; 
	 
	 @Column(name = "ALATNAME")
	 private String alatname;
	
	 @Column(name = "NAMA")
	 private String nama;
	 
	 @Column(name = "ADDR")
	 private String addr;
	 
	 @Column(name = "KELURAHAN")
	 private String kelurahan;
	 
	 @Column(name = "JENIS_KELAMIN")
	 private String jenisKelamin;
	 
	 @Column(name = "DOKTER")
	 private String dokter;
	 
	 @Column(name = "KLAS")
	 private String klas;
	 
	 @Column(name = "TRAD")
	 private LocalDateTime trad;
	 
	 @Column(name = "NOURUT")
	 private Long nourut;
	 	 
	 @Column(name = "PERIKSA")
	 private String periksa;
	 
	 @Column(name = "BIAYA")
	 private Long biaya;
		
	 @Column(name = "POT")
	 private Long pot;
		
	 @Column(name = "DISCOUNT")
	 private Float discount;  	 
	  
	 @Column(name = "TANGGAL_LAHIR")
	 private LocalDate tanggalLahir;
	 
	 @Column(name = "RESULT")
	 private String result;	 	
	 
	 @Column(name = "USR")
	 private String usr;
	 
	 @Column(name = "SHIFT")
	 private String shift;
	 
	 @Column(name = "DETAILS")
	 private String details;
	 
	 @Column(name = "DR")
	 private String dr;
	 
	 @Lob
	 @Column(name="TTD")
	 private byte[] ttd;
		 
	 
	 
	
}
