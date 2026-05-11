package com.dev.generik.entities.ERM.PA;

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
public class PAHasil {
	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "REGNUM")
	private String RM;
	
	@Column(name = "NAMA")
	private String nama;
	
	@Column(name = "JENIS_KELAMIN")
	private String kel;
	
	@Column(name = "POSISI")
	private String ruang;
	
	@Column(name = "ADDR")
	private String alamat;
	
	@Column(name = "UMUR")
	private String umur;
	
	@JsonFormat(shape = Shape.STRING, pattern = "dd MMMM yyyy", lenient = OptBoolean.FALSE, timezone = "Asia/Jakarta")
	@Temporal(TemporalType.DATE)
	@Column(name = "TGL")
	private Date tgl; 	
	
	@Column(name = "PENGIRIM")
	private String pengirim ; 

	@Column(name = "PERUJUK")
	private String perujuk ; 
	
	@Column(name = "PXRS")
	private String pxrs ; 
	
	@JsonFormat(shape = Shape.STRING, pattern = "dd MMMM yyyy", lenient = OptBoolean.FALSE, timezone = "Asia/Jakarta")
	@Temporal(TemporalType.DATE)
	@Column(name = "TGLPA")
	private Date adate; 
	
	@JsonFormat(shape = Shape.STRING, pattern = "dd MMMM yyyy", lenient = OptBoolean.FALSE, timezone = "Asia/Jakarta")
	@Temporal(TemporalType.DATE)
	@Column(name = "EDATE")
	private Date rdate; 
	
	@Column(name = "PADOC")
	private String padoc;
	
	@Column(name = "ORGANNAME")
	private String argan;
	
	@Column(name = "REGIONAME")
	private String regio;
	
	@Column(name = "BAHAN")
	private String bahan;
	
	@Column(name = "DIAGNOSAKLINIS")
	private String diagnosaklinis;
	
	@Column(name = "MAKROSKOPIS")
	private String makroskopis;
	
	@Column(name = "MIKROSKOPIS")
	private String mikroskopis;
	
	@Column(name = "KESIMPULAN")
	private String kesimpulan;
	
	@Column(name = "ICDO")
	private String icdo;

}
