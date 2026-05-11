package com.dev.generik.models;

import java.util.Date;

//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.OptBoolean;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat.Shape;

public class TracerPXRITanggalModel {
//	private Long paviliunid;

	@JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+7", lenient = OptBoolean.FALSE)
	@Temporal(TemporalType.DATE)
	private Date bDate;
	
	@JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+7", lenient = OptBoolean.FALSE)
	@Temporal(TemporalType.DATE)
	private Date eDate;

	public TracerPXRITanggalModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TracerPXRITanggalModel(//Long paviliunid, 
			Date bDate, Date eDate) {
		super();
	//	this.paviliunid = paviliunid;
		this.bDate = bDate;
		this.eDate = eDate;
	}

	/*public Long getPaviliunid() {
		return paviliunid;
	}

	public void setPaviliunid(Long paviliunid) {
		this.paviliunid = paviliunid;
	} */

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
