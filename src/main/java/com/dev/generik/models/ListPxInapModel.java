package com.dev.generik.models;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;

public class ListPxInapModel {

	private Long id;
	@Temporal(TemporalType.DATE)
	private Date tmsk;
	private String norm;
	private String room;
	private String kelas;
	private String px;
	private String addr;
	@Temporal(TemporalType.TIME)
	private Date jmsk;
	private Long regid;
	private Long pavid;
	private String pav;
	private Long biaya;
	private Long phk3;
	private String kelasbpjs;
	private String pxrs;
	
	private List<VisitDokterModel> lstVisite;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getTmsk() {
		return tmsk;
	}

	public void setTmsk(Date tmsk) {
		this.tmsk = tmsk;
	}

	public String getNorm() {
		return norm;
	}

	public void setNorm(String norm) {
		this.norm = norm;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public String getKelas() {
		return kelas;
	}

	public void setKelas(String kelas) {
		this.kelas = kelas;
	}

	public String getPx() {
		return px;
	}

	public void setPx(String px) {
		this.px = px;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public Date getJmsk() {
		return jmsk;
	}

	public void setJmsk(Date jmsk) {
		this.jmsk = jmsk;
	}

	public Long getRegid() {
		return regid;
	}

	public void setRegid(Long regid) {
		this.regid = regid;
	}

	public Long getPavid() {
		return pavid;
	}

	public void setPavid(Long pavid) {
		this.pavid = pavid;
	}

	public String getPav() {
		return pav;
	}

	public void setPav(String pav) {
		this.pav = pav;
	}

	public Long getBiaya() {
		return biaya;
	}

	public void setBiaya(Long biaya) {
		this.biaya = biaya;
	}

	public Long getPhk3() {
		return phk3;
	}

	public void setPhk3(Long phk3) {
		this.phk3 = phk3;
	}

	public String getKelasbpjs() {
		return kelasbpjs;
	}

	public void setKelasbpjs(String kelasbpjs) {
		this.kelasbpjs = kelasbpjs;
	}

	public String getPxrs() {
		return pxrs;
	}

	public void setPxrs(String pxrs) {
		this.pxrs = pxrs;
	}
	

	public List<VisitDokterModel> getLstVisite() {
		return lstVisite;
	}

	public void setLstVisite(List<VisitDokterModel> lstVisite) {
		this.lstVisite = lstVisite;
	}

}
