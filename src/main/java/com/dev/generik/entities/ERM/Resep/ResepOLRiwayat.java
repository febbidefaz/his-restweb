package com.dev.generik.entities.ERM.Resep;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.OptBoolean;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

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
//@Table(name = "WSRESEPOLWSRIWAYAT")
@Getter
@Setter

public class ResepOLRiwayat {
	
	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	
	@JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd", lenient = OptBoolean.FALSE, timezone = "Asia/Jakarta")
	@Temporal(TemporalType.DATE)
	@Column(name = "TGL")
	private Date tgl;
	
	@JsonFormat(shape = Shape.STRING, pattern = "HH:mm:ss", lenient = OptBoolean.FALSE, timezone = "Asia/Jakarta")
	@Temporal(TemporalType.TIME)
	@Column(name = "JAM")
	private Date jam;
	
	@Column(name = "IDREG")
	private Long idReg;
	
	@Column(name = "resepDokter")
	private Long idDokter;
	
	@Column(name = "KLASID")
	private Long kelasID;
	
	@Column(name = "ROID")
	private Long roomID;
	
	@Column(name = "MANUAL")
	private String manual;
	
	@Column(name = "KETINAP")
	private String ketInap;
	
	@Column(name = "Register")
	private String rm;
	
	@Column(name = "Racikan")
	private Boolean racikan;
}
