package com.dev.generik.entities.ERM.Lab;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter 
@Setter
public class LabHasilAll {
	 @Id	
	 @Column(name = "IDD")
	 private Long idd;
	
	 @Column(name = "NAMA")
	 private String nama;
	 
	 @Column(name = "ADDR")
	 private String addr;
	 
	 @Column(name = "KELURAHAN")
	 private String kelurahan;
	 
	 @Column(name = "JENIS_KELAMIN")
	 private String jenisKelamin;
	 
	 @Column(name = "TANGGAL_LAHIR")
	 private LocalDate tanggalLahir;
	 
	 @Column(name = "TH")
	 private Long th;                  // umur (tahun)
	 
	 @Column(name = "BLN")
	 private Long bln;                 // umur (bulan)
	 
	 @Column(name = "HR")
	 private Long hr;                  // umur (hari)	   
	 
	 @Column(name = "DOKTER")
	 private String dokter;
	 
	 @Column(name = "KELAS")
	 private String kelas;
	 
	 @Column(name = "JAM_AMBIL")
	 @Temporal(TemporalType.TIME)
	 private Date jamAmbil;
	 
	 @Column(name = "IDLAB")
	 private Long idlab;
	 
	 @Column(name = "IDREG")
	 private Long idreg;
	 
	 @Column(name = "REGNUM")
	 private String regNum;
	 
	 @Column(name = "RUJUKAN")
	 private String rujukan;
	 
	 @Column(name = "TLAB")
	 private LocalDateTime tlab;
	 
	 @Column(name = "ROOMNAME")
	 private String roomName;
	 
	 @Column(name = "JAM_CHECK")
	 @Temporal(TemporalType.TIME)
	 private Date jamcheck;
	 
	 @Column(name = "TANGGAL")	
	 private LocalDate tanggal;           // Therapy.Tanggal
	 
	 @Column(name = "NOTE")
	 private String note;                 // Metode.Note
	 
	 @Column(name = "USR")
	 private String usr;
	 
	 @Column(name = "ISOK")
	 private Boolean isok;
	 
	 @Column(name = "PXRS")
	 private String pxrs;
	 
	 @Column(name = "DETAILS")
	 private String details;
	 
	 // ---
	 @Column(name = "KATEGORI")
	 private String kategori;
		
	 @Column(name = "KATEID")
	 private Long kateID;
		
	 @Column(name = "METODEID")
	 private Long metodeID;	
	 
	 //---
	 @Column(name = "ID")
	 private Long id; 
	 
	 @Column(name = "PREP_ID")
	 private Long prepID; 
		
	 @Column(name = "PERIK")
	 private String perik;	
		
	 @Column(name = "NORL")
	 private String norL;
		
	 @Column(name = "LEVELS")
	 private String levels;
		
	 @Column(name = "METODE")
	 private String metode;
		
	 @Column(name = "BIAYA")
	 private Long biaya;
		
	 @Column(name = "POT")
	 private Long pot;
		
	 @Column(name = "DISCOUNT")
	 private Float discount;  
}
