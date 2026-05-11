package com.dev.generik.entities.display;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.OptBoolean;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

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
@Table(name = "WSRAWATINAP")
@Getter
@Setter
public class DisplayInap {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "PXRS")
	private String pxrs;
	
	@Column(name = "REGNUM", length = 10)
	private String norm;
	
	@Column(name = "ROOMNAME")
	private String room;
	
	@JsonFormat(shape = Shape.STRING, pattern = "dd MMMM yyyy", lenient = OptBoolean.FALSE, timezone = "Asia/Jakarta")
	@Temporal(TemporalType.DATE)
	@Column(name = "TIN")
	private Date tmsk;
	
	@Temporal(TemporalType.TIME)
	@Column(name = "JAM_MASUK")
	private Date jmsk;
	
	@Column(name = "US")
	private String user;
	
	@Column(name = "KODEBED")
	private String bed;
	
	@Column(name = "DR")
	private String dokter;
}
