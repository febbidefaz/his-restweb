package com.dev.generik.models;

import java.util.Date;

//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.OptBoolean;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat.Shape;

public class TBScreaningRIDateModel {
	private Long ri; 
	
	@JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+7", lenient = OptBoolean.FALSE)
	@Temporal(TemporalType.DATE)
	private Date bDate;
	
	@JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+7", lenient = OptBoolean.FALSE)
	@Temporal(TemporalType.DATE)
	private Date eDate;

	public TBScreaningRIDateModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TBScreaningRIDateModel(Long ri, Date bDate, Date eDate) {
		super();
		this.ri = ri;
		this.bDate = bDate;
		this.eDate = eDate;
	}
	
		
	public Long getRi() {
		return ri;
	}

	public void setRi(Long ri) {
		this.ri = ri;
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
