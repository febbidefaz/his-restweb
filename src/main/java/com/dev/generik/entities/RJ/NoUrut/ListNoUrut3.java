package com.dev.generik.entities.RJ.NoUrut;

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
public class ListNoUrut3 {
	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "PXNO")
	private Long pxNo;
	
	@Column(name = "REGNUM")
	private Long regNum;
	
	@Column(name = "NAMA")
	private String nama;
	
	@JsonFormat(shape = Shape.STRING, pattern = "dd MMMM yyyy", lenient = OptBoolean.FALSE, timezone = "Asia/Jakarta")
	@Temporal(TemporalType.DATE)
	@Column(name = "TGL")
	private Date tgl; 	
	
	@Column(name = "ALIAS")
	private Long jp;
	
	@Column(name = "CALL_NO")
	private Long panggil;
	
	@Column(name = "DATANG")
	private Boolean datang;
	
	@Column(name = "SUBLAYANAN")
	private String sublayanan;
	
	@Column(name = "Dokter")
	private Long dokterID;
}
