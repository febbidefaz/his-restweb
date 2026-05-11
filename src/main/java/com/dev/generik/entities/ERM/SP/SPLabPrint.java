package com.dev.generik.entities.ERM.SP;

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
public class SPLabPrint {
	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ROW")
	private Long n;
	
	@Column(name = "ID")
	private Long idreg;
	
	@JsonFormat(shape = Shape.STRING, pattern = "dd MMMM yyyy", lenient = OptBoolean.FALSE, timezone = "Asia/Jakarta")
	@Temporal(TemporalType.DATE)
	@Column(name = "TGL")
	private Date tgl; 	
	
	@JsonFormat(shape = Shape.STRING, pattern = "hh:mm:ss", lenient = OptBoolean.FALSE, timezone = "Asia/Jakarta")
	@Temporal(TemporalType.TIME)
	@Column(name = "JAM")
	private Date jam; 

	@Column(name = "PERIKSALAB")
	private String periksaLab;
	
	@Column(name = "NAMA")
	private String nama;

	@Column(name = "ADDR")
	private String addr;
	
	@Column(name = "REGNUM")
	private String rm;
	
	@JsonFormat(shape = Shape.STRING, pattern = "dd MMMM yyyy", lenient = OptBoolean.FALSE, timezone = "Asia/Jakarta")
	@Temporal(TemporalType.DATE)
	@Column(name = "TANGGAL_LAHIR")
	private Date tglLhr; 
	
	@Column(name = "Dokter")
	private String dokter;
	
	@Column(name = "DIAGNOSA")
	private String diagnosa;
	
	@Column(name = "ROOMNAME")
	private String room;
	
	@Column(name = "BB")
	private Long bb;
	
	@Column(name = "NO")
	private Long no;
}
