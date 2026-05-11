package com.dev.generik.models;

import java.util.Date;

//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.OptBoolean;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat.Shape;

public class TaskIDIRJDrDateModel {
	private Long dokterid;

	@JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+7", lenient = OptBoolean.FALSE)
	@Temporal(TemporalType.DATE)
	private Date bDate;
	
	@JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+7", lenient = OptBoolean.FALSE)
	@Temporal(TemporalType.DATE)
	private Date eDate;

	public TaskIDIRJDrDateModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TaskIDIRJDrDateModel(Long dokterid, Date bDate, Date eDate) {
		super();
		this.dokterid = dokterid;
		this.bDate = bDate;
		this.eDate = eDate;
	}

	public Long getDokterid() {
		return dokterid;
	}

	public void setDokterid(Long dokterid) {
		this.dokterid = dokterid;
	}

	public Date getbDate() {
		return bDate;
	}

	public void setbDate(Date bDate) {
		this.bDate = bDate;
	}

	public Date geteDate() {
		return eDate;
	}

	public void seteDate(Date eDate) {
		this.eDate = eDate;
	}

	

	
}
