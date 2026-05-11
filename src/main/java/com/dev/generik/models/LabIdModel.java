package com.dev.generik.models;

//import java.io.Serializable;

//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;

import java.util.Date;

//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;
//import javax.validation.constraints.NotNull;

//import com.dev.generik.validator.PresentOrFutureDate;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.OptBoolean;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat.Shape;

public class LabIdModel {
	/**
	 * 
	 */
	// private static final long serialVersionUID = 12345L;

//	@NotNull	
//	@Size(min = 13, max=13)	
//	@Notnull
	private Long idreg;

	private String rm;

	@JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd", lenient = OptBoolean.FALSE)
	@Temporal(TemporalType.DATE)
	// @NotNull
	// @PresentOrFutureDate
	private Date tgllhr;

	public LabIdModel() {
		super();
	}

	/*
	 * public IdLabModel( Long id) { super(); this.id = id; }
	 */

	public Long getIdreg() {
		return idreg;
	}

	public void setIdreg(Long idreg) {
		this.idreg = idreg;
	}

	public String getRm() {
		return rm;
	}

	public void setRm(String rm) {
		this.rm = rm;
	}

	public Date getTgllhr() {
		return tgllhr;
	}

	public void setTgllhr(Date tgllhr) {
		this.tgllhr = tgllhr;
	}
}
