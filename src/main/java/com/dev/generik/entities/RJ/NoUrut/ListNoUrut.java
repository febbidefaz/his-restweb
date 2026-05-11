package com.dev.generik.entities.RJ.NoUrut;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.OptBoolean;

//import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ListNoUrut {
			
//	@Column(name = "PXNO")
	private Long pxNo;	
	
//	@Column(name = "CALLNO")
	private Long callNo;
	
//	@Column(name = "REGNUM")
	private String regNum;
	
//	@Column(name = "NAMA")
	private String nama;
	
//	@Column(name = "POLY")
	private String poly;
	
	@JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd", lenient = OptBoolean.FALSE, timezone = "Asia/Jakarta")
	@Temporal(TemporalType.DATE)
//	@Column(name = "TGL")
	private Date tgl; 	
	
//	@Column(name = "ALIAS")
	private String jp;
	
//	@Column(name = "ID")
	private Long id;
	
//	@Column(name = "DATANG")
//	private Boolean datang;
	
//	@Column(name = "FOLLOWUP")
//	private String followUp;
	
//	@Column(name = "IDQ")
	private Long idq;
	
//	@Column(name = "IDQ")
	private Long jamPraktek;
	
	private Boolean isLock;
}
