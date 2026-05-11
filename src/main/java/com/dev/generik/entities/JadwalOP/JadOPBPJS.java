package com.dev.generik.entities.JadwalOP;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;



@Entity
@Table(name = "WSGETJADOPBPJS")
public class JadOPBPJS {
	@Id
	@Column(name = "id")
	private Long id;

	@Column(name = "Kodebooking")
	private Long kodebooking;

	@Temporal(TemporalType.DATE)
//	@Column (name="Tanggaloperasi")
	private Date tanggaloperasi;

	@Column(name = "Jenistindakan", length = 50)
	private String jenistindakan;

	@Column(name = "Kodepoli", length = 20)
	private String kodepoli;

	@Column(name = "Namapoli", length = 30)
	private String namapoli;

	@Column(name = "Terlaksana")
	private Long terlaksana;

	@Column(name = "Nopeserta", length = 30)
	private String nopeserta;

//	@Temporal(TemporalType.TIMESTAMP)
//	@Column (name="lastdate")
//	private Date lastdate;

	@Column(name = "unixtime")
	private Long lastupdate;

	public JadOPBPJS() {
		super();
	}

//	public Date getLastdate() {
//		return lastdate;
//	}
//
//
//	public void setLastdate(Date lastdate) {
//		this.lastdate = lastdate;
//	}

	public Long getLastupdate() {
		return lastupdate;
	}

	public void setLastupdate(Long lastupdate) {
		this.lastupdate = lastupdate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getKodebooking() {
		return kodebooking;
	}

	public void setKodebooking(Long kodebooking) {
		this.kodebooking = kodebooking;
	}

	public Date getTanggaloperasi() {

		return tanggaloperasi;
	}

	public void setTanggaloperasi(Date tanggaloperasi) {
		this.tanggaloperasi = tanggaloperasi;
	}

	public String getJenistindakan() {
		return jenistindakan;
	}

	public void setJenistindakan(String jenistindakan) {
		this.jenistindakan = jenistindakan;
	}

	public String getKodepoli() {
		return kodepoli;
	}

	public void setKodepoli(String kodepoli) {
		this.kodepoli = kodepoli;
	}

	public String getNamapoli() {
		return namapoli;
	}

	public void setNamapoli(String namapoli) {
		this.namapoli = namapoli;
	}

	public Long getTerlaksana() {
		return terlaksana;
	}

	public void setTerlaksana(Long terlaksana) {
		this.terlaksana = terlaksana;
	}

	public String getNopeserta() {
		return nopeserta;
	}

	public void setNopeserta(String nopeserta) {
		this.nopeserta = nopeserta;
	}

}
