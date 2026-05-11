package com.dev.generik.entities.ERM.PPRA;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.OptBoolean;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

@Entity
//@Table(name = "WSLABHASILBATAS1")
@Getter
@Setter
public class ObatPPRA {
	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "NO")
	private Long no;
	
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "IDREG")
	private Long idReg;
	
	@Column(name = "KODE")
	private String kode;
	
	@Column(name = "PRODUCTNAME")
	private String nama;
	
	@Column(name = "QTY")
	private Long qty;
	
	@Column(name = "ROOMNAME")
	private String room;
	
	@JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd", lenient = OptBoolean.FALSE, timezone = "Asia/Jakarta")
	@Temporal(TemporalType.DATE)
	@Column(name = "INVOICEDATE")
	private Date tgl;
	
	@Column(name = "SIGNA")
	private String signa;

}
