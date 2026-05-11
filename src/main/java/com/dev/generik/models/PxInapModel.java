package com.dev.generik.models;

import java.util.Date;
import java.util.List;

//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.OptBoolean;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat.Shape;

public class PxInapModel {

	private Long pxId;
	private String noRm;
	private String namaPx;
//	private Long klasId;
	private String kelas;
//	private Long roomId;
	private String roomName;
//	private Long pavId;
	private String pav;
	@JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+7", lenient = OptBoolean.FALSE)
	@Temporal(TemporalType.DATE)
	private Date tglMsk;
	private List<VisiteModel> lstVisite;

	public Long getPxId() {
		return pxId;
	}

	public void setPxId(Long pxId) {
		this.pxId = pxId;
	}

	public String getNoRm() {
		return noRm;
	}

	public void setNoRm(String noRm) {
		this.noRm = noRm;
	}

	public String getNamaPx() {
		return namaPx;
	}

	public void setNamaPx(String namaPx) {
		this.namaPx = namaPx;
	}

	public String getKelas() {
		return kelas;
	}

	public void setKelas(String kelas) {
		this.kelas = kelas;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public String getPav() {
		return pav;
	}

	public void setPav(String pav) {
		this.pav = pav;
	}

	public Date getTglMsk() {
		return tglMsk;
	}

	public void setTglMsk(Date tglMsk) {
		this.tglMsk = tglMsk;
	}

	public List<VisiteModel> getLstVisite() {
		return lstVisite;
	}

	public void setLstVisite(List<VisiteModel> lstVisite) {
		this.lstVisite = lstVisite;
	}

}
