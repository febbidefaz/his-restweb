package com.dev.generik.entities.TB;

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
@Table(name = "tbscreaningrj")
public class TBScreaningRJ {
	@Id
	@Column(name = "Id")
	private Long id;

	@Column(name = "Norm")
	private String norm;
	
	@Column(name = "Nama")
	private String nama;
	
	@Column(name = "Addr")
	private String addr;

	@Temporal(TemporalType.DATE)
	@Column(name = "Tgllhr")
	private Date tanggalLahir;

	@Column(name = "Jeniskelamin")
	private String jk;
	
	@Column(name = "Nik")
	private String nik;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "Tanggal")
	private Date tanggal;
	
	@Column(name = "Keterangan")
	private String keterangan;
	
	@Column(name = "Sublayanan")
	private String sublayanan;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNorm() {
		return norm;
	}

	public void setNorm(String norm) {
		this.norm = norm;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public Date getTanggalLahir() {
		return tanggalLahir;
	}

	public void setTanggalLahir(Date tanggalLahir) {
		this.tanggalLahir = tanggalLahir;
	}

	public String getJk() {
		return jk;
	}

	public void setJk(String jk) {
		this.jk = jk;
	}

	public String getNik() {
		return nik;
	}

	public void setNik(String nik) {
		this.nik = nik;
	}

	public Date getTanggal() {
		return tanggal;
	}

	public void setTanggal(Date tanggal) {
		this.tanggal = tanggal;
	}

	public String getKeterangan() {
		return keterangan;
	}

	public void setKeterangan(String keterangan) {
		this.keterangan = keterangan;
	}

	public String getSublayanan() {
		return sublayanan;
	}

	public void setSublayanan(String sublayanan) {
		this.sublayanan = sublayanan;
	}



	
	
	
	
}
