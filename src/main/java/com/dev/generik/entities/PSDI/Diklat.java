package com.dev.generik.entities.PSDI;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "WSDIKLAT")
public class Diklat {
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

	@Column(name = "Foto1")
	private String foto1;

	@Column(name = "Foto2")
	private String foto2;

	@Column(name = "Foto3")
	private String foto3;

	@Column(name = "Foto4")
	private String foto4;

//	@Column(name="Kode")
//	private Long kode;

	@Column(name = "Pdf1")
	private String pdf1;

	@Column(name = "Pdf2")
	private String pdf2;

	@Column(name = "Pdf3")
	private String pdf3;

	@Column(name = "Pdf4")
	private String pdf4;

	// @Column(name="Pdf5")
	// private String pdf5;

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

	public String getFoto1() {
		return foto1;
	}

	public void setFoto1(String foto1) {
		this.foto1 = foto1;
	}

	public String getFoto2() {
		return foto2;
	}

	public void setFoto2(String foto2) {
		this.foto2 = foto2;
	}

	public String getFoto3() {
		return foto3;
	}

	public void setFoto3(String foto3) {
		this.foto3 = foto3;
	}

	public String getFoto4() {
		return foto4;
	}

	public void setFoto4(String foto4) {
		this.foto4 = foto4;
	}

	/*
	 * public Long getKode() { return kode; }
	 * 
	 * public void setKode(Long kode) { this.kode = kode; }
	 */

	public String getPdf1() {
		return pdf1;
	}

	public void setPdf1(String pdf1) {
		this.pdf1 = pdf1;
	}

	public String getPdf2() {
		return pdf2;
	}

	public void setPdf2(String pdf2) {
		this.pdf2 = pdf2;
	}

	public String getPdf3() {
		return pdf3;
	}

	public void setPdf3(String pdf3) {
		this.pdf3 = pdf3;
	}

	public String getPdf4() {
		return pdf4;
	}

	public void setPdf4(String pdf4) {
		this.pdf4 = pdf4;
	}

	/*
	 * public String getPdf5() { return pdf5; }
	 * 
	 * public void setPdf5(String pdf5) { this.pdf5 = pdf5; }
	 */

}
