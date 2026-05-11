package com.dev.generik.entities.ERM.Pasien;

import java.util.Date;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.OptBoolean;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@Entity
@Table(name = "WSCEKPXWEB")
@Getter
@Setter

public class CekPxWeb {

	@Id
	//@Column(name = "IDN")
	@Column(name = "IDN", columnDefinition = "uniqueidentifier")
	private UUID idn;
	
	@Column(name = "ID")
	private Long id;

	@Column(name = "REGNUM")
	private String rm;

	@JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd", lenient = OptBoolean.FALSE, timezone = "Asia/Jakarta")
//	@JsonFormat(shape = Shape.STRING, pattern = "dd-MM-yyyy", lenient = OptBoolean.FALSE, timezone = "Asia/Jakarta")
	@Temporal(TemporalType.DATE)
	@Column(name = "TGL")
	private Date tgl;

	

}
