package com.dev.generik.entities.ERM.Lab;

//import java.sql.Date;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.OptBoolean;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

@Entity
//@Table(name = "WSLABHASILBATAS1")
@Getter
@Setter
public class LabHasilKultur {
	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDD")
	private Long idd;
	
	@Column(name = "IDLAB")
	private Long idlab;
	
	@Column(name = "IDREG")
	private Long idreg;
	
	@Column(name = "PREPID")
	private Long prepid;
	
	@JsonFormat(shape = Shape.STRING, pattern = "dd MMMM yyyy", lenient = OptBoolean.FALSE, timezone = "Asia/Jakarta")
	@Temporal(TemporalType.DATE)
	@Column(name = "TLAB")
	private Date tlab; 
	
	@Column(name = "DOKTER")
	private String dokter; 
	
	@Column(name = "PERIK")
	private String perik; 
	
	@Column(name = "KATEID")
	private Long kateid; 
	
	@Column(name = "NORL")
	private String norl; 
	
	@Column(name = "LEVELS")
	private String levels; 
	
	@Column(name = "METODE")
	private String metode; 
	
	@Column(name = "BIAYA")
	private String biaya; 
		
	@Column(name = "REGNUM")
	private String regnum; 
	
	@Column(name = "NAMA")
	private String nama; 
	
	@Column(name = "ADDR")
	private String addr; 
	
	@Column(name = "KELURAHAN")
	private String kelurahan; 
	
	@Column(name = "KEL")
	private String kel; 
	
	@JsonFormat(shape = Shape.STRING, pattern = "dd MMMM yyyy", lenient = OptBoolean.FALSE, timezone = "Asia/Jakarta")
	@Temporal(TemporalType.DATE)
	@Column(name = "TANGGAL")
	private Date tanggal; 
	
	@Column(name = "TH")
	private Long th;
	
	@Column(name = "BLN")
	private Long bln;
	
	@Column(name = "HR")
	private Long hr;
	
	@Column(name = "KATEGORI")
	private String kategori; 
	
	@Column(name = "NOTE")
	private String note; 
	
	@Column(name = "METODEID")
	private Long metodeid;
	
//	@Column(name = "USR")
//	private String Usr; 

	@Column(name = "ISOK")
	private Boolean isok; 
	
	@Column(name = "RUJUKAN")
	private String rujukan; 
	
	@Column(name = "DETAILS")
	private String details; 
	
	@Column(name = "ID")
	private Long id;
	
	@Temporal(TemporalType.TIME)
	@Column(name = "JAMAMBIL")
	private Date jamambil;

	@Temporal(TemporalType.TIME)
	@Column(name = "JAMCHECK")
	private Date jamcheck;

	@JsonFormat(shape = Shape.STRING, pattern = "dd MMMM yyyy", lenient = OptBoolean.FALSE, timezone = "Asia/Jakarta")
	@Temporal(TemporalType.DATE)
	@Column(name = "TGLLAHIR")
	private Date tgllahir; 
	
	@Column(name = "PXRS")
	private String pxrs; 
	
	@Column(name = "BATASUP")
	private Float batasup;
	
	@Column(name = "BATASDOWN")
	private Float batasdown;
	
	@Column(name = "LVL")
	private String lvl; 
	
	@Column(name = "USER1")
	private String user1; 
	
	@Column(name = "USER2")
	private String user2; 
	
	@Column(name = "DR")
	private String dr; 
	
	@Column(name = "NOTELAP")
	private String notelap; 
	
	@Column(name = "VERIF")
	private Boolean verif; 
	
	@Column(name = "PDF")
	private String pdf; 
	

}
