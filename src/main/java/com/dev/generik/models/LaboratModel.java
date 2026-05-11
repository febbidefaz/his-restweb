package com.dev.generik.models;

import java.io.Serializable;
//import java.util.Date;
import java.util.Date;

public class LaboratModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3121922636150247051L;
	private Long id;
	private Long idreg;
	private Date tlab;
	private Date jamambil;
	private Date jamcek;
	private String dokter;
	private String rm;
	private String nama;
	private Date tgllhr;
	private String jk;
	private String addr;
	private String kelas;
	private String grplab;
	private String room;
	private Long th;
	private Long bln;
	private Long hr;

	public LaboratModel() {
		super();
	}

	public LaboratModel(Long id, Long idreg, Date tlab, Date jamambil, Date jamcek, String dokter, String rm,
			String nama, Date tgllhr, String jk, String addr, String kelas, String grplab, String room, Long th,
			Long bln, Long hr) {

		super();
		this.id = id;
		this.idreg = idreg;
		this.tlab = tlab;
		this.jamambil = jamambil;
		this.jamcek = jamcek;
		this.dokter = dokter;
		this.rm = rm;
		this.nama = nama;
		this.tgllhr = tgllhr;
		this.jk = jk;
		this.addr = addr;
		this.kelas = kelas;
		this.grplab = grplab;
		this.room = room;
		this.th = th;
		this.bln = bln;
		this.hr = hr;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdreg() {
		return idreg;
	}

	public void setIdreg(Long idreg) {
		this.idreg = idreg;
	}

	public Date getTlab() {
		return tlab;
	}

	public void setTlab(Date tlab) {
		this.tlab = tlab;
	}

	public Date getJamambil() {
		return jamambil;
	}

	public void setJamambil(Date jamambil) {
		this.jamambil = jamambil;
	}

	public Date getJamcek() {
		return jamcek;
	}

	public void setJamcek(Date jamcek) {
		this.jamcek = jamcek;
	}

	public String getDokter() {
		return dokter;
	}

	public void setDokter(String dokter) {
		this.dokter = dokter;
	}

	public String getRm() {
		return rm;
	}

	public void setRm(String rm) {
		this.rm = rm;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public Date getTgllhr() {
		return tgllhr;
	}

	public void setTgllhr(Date tgllhr) {
		this.tgllhr = tgllhr;
	}

	public String getJk() {
		return jk;
	}

	public void setJk(String jk) {
		this.jk = jk;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getKelas() {
		return kelas;
	}

	public void setKelas(String kelas) {
		this.kelas = kelas;
	}

	public String getGrplab() {
		return grplab;
	}

	public void setGrplab(String grplab) {
		this.grplab = grplab;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public Long getTh() {
		return th;
	}

	public void setTh(Long th) {
		this.th = th;
	}

	public Long getBln() {
		return bln;
	}

	public void setBln(Long bln) {
		this.bln = bln;
	}

	public Long getHr() {
		return hr;
	}

	public void setHr(Long hr) {
		this.hr = hr;
	}

}
