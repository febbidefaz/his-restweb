package com.dev.generik.entities.HaloRSA;

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
@Table(name = "WSSLIDE")
public class Slide {
	@Id
	@Column(name = "Id")
	private Long id;

	@Column(name = "Judul")
	private String judul;

	@Temporal(TemporalType.DATE)
	@Column(name = "Tanggal")
	private Date tanggal;

	@Column(name = "Isi")
	private String isi;

	@Column(name = "Fotojudul")
	private String fotojudul;

	@Column(name = "Kode")
	private Long kode;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getJudul() {
		return judul;
	}

	public void setJudul(String judul) {
		this.judul = judul;
	}

	public Date getTanggal() {
		return tanggal;
	}

	public void setTanggal(Date tanggal) {
		this.tanggal = tanggal;
	}

	public String getIsi() {
		return isi;
	}

	public void setIsi(String isi) {
		this.isi = isi;
	}

	public String getFotojudul() {
		return fotojudul;
	}

	public void setFotojudul(String fotojudul) {
		this.fotojudul = fotojudul;
	}

	public Long getKode() {
		return kode;
	}

	public void setKode(Long kode) {
		this.kode = kode;
	}
}
