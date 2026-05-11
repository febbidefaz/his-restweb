package com.dev.generik.models;

import java.util.Date;

//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.OptBoolean;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat.Shape;

public class VisiteModel {
//	private String keyId;
//	private Long pxId;
//	private String noRm;
//	private String namaPx;
	private Long dokterId;
	private String nadok;
//	private Long klasId;
//	private Long roomId;
	@JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+7", lenient = OptBoolean.FALSE)
	@Temporal(TemporalType.DATE)
	private Date tglVisit;

	public VisiteModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getDokterId() {
		return dokterId;
	}

	public void setDokterId(Long dokterId) {
		this.dokterId = dokterId;
	}

	public String getNadok() {
		return nadok;
	}

	public void setNadok(String nadok) {
		this.nadok = nadok;
	}

	public Date getTglVisit() {
		return tglVisit;
	}

	public void setTglVisit(Date tglVisit) {
		this.tglVisit = tglVisit;
	}

}
