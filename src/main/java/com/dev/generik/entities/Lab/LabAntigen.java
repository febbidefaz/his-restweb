package com.dev.generik.entities.Lab;

import java.util.Date;

//import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "WSLABANTIGEN")
public class LabAntigen {
	@Id
	@Column(name = "Id")
	private Long id;

	@Column(name = "IDReg")
	private Long idreg;

	@Temporal(TemporalType.DATE)
	@Column(name = "TLab")
	private Date tlab;

	@Temporal(TemporalType.TIME)
	@Column(name = "Jam_ambil")
	private Date jamambil;

	@Temporal(TemporalType.TIME)
	@Column(name = "Jam_check")
	private Date jamcek;

	@Column(name = "Dokter")
	private String dokter;

	@Column(name = "Register")
	private String rm;

	@Column(name = "Nama")
	private String nama;

	@Temporal(TemporalType.DATE)
	@Column(name = "Tanggal_Lahir")
	private Date tgllhr;

	@Column(name = "Jenis_Kelamin")
	private String jk;

	@Column(name = "Addr")
	private String addr;

	@Column(name = "Kelas")
	private String kelas;

	@Column(name = "Grp")
	private String grplab;

	@Column(name = "Room")
	private String room;

	@Column(name = "Th")
	private Long th;

	@Column(name = "Bln")
	private Long bln;

	@Column(name = "Hr")
	private Long hr;

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
