package com.dev.generik.entities.ERM.Rad;

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
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "WSRADHASILPX")
@Getter
@Setter
public class RadHasilPX {
	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDD")
	private String idd;
	
	@Column(name = "IDRAD")
	private Long idrad;
	
	@Column(name = "IDREG")
	private Long idreg;
	
	@Column(name = "RADIOID")
	private Long radioid;	
	
	@Column(name = "REGNUM")
	private String regnum; 
	
	@Column(name = "NAMA")
	private String nama; 
	
	@Column(name = "KEL")
	private String kel; 
	
	@Column(name = "ADDR")
	private String addr; 
	
	@Column(name = "KELURAHAN")
	private String kelurahan; 
	
	@Column(name = "DOKTER")
	private String dokter; 
	
	@JsonFormat(shape = Shape.STRING, pattern = "dd MMMM yyyy", lenient = OptBoolean.FALSE, timezone = "Asia/Jakarta")
	@Temporal(TemporalType.DATE)
	@Column(name = "TRAD")
	private Date trad; 
	
	@Column(name = "ALATID")
	private String alatid; 
	
	@Column(name = "PERIKSA")
	private String periksa; 
	
	@Column(name = "BIAYA")
	private String biaya; 
	
	@Column(name = "TH")
	private Long th;
	
	@Column(name = "BLN")
	private Long bln;
	
	@Column(name = "HR")
	private Long hr;	
		
	@Column(name = "KLAS")
	private String klas; 
	
	@Column(name = "USR")
	private String usr;
	
	@JsonFormat(shape = Shape.STRING, pattern = "dd MMMM yyyy", lenient = OptBoolean.FALSE, timezone = "Asia/Jakarta")
	@Temporal(TemporalType.DATE)
	@Column(name = "TGLLAHIR")
	private Date tgllahir; 
	
	@Column(name = "DR")
	private String dr; 
		
	@Column(name = "RESULT")
	private String result; 
	
	@Column(name = "DETAILS")
	private String details; 
		
	@Column(name = "NM")
	private String nm; 
	
	@Column(name = "PACSBARCODE")
	private String pacsbarcode; 
	
}
