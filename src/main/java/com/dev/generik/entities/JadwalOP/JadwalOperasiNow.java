package com.dev.generik.entities.JadwalOP;

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
@Table(name = "WSJADWALOPERASINOW")
public class JadwalOperasiNow {
	@Id
	@Column(name = "id")
	private Long id;

	@Column(name = "Kode")
	private Long kode;

	@Column(name = "PXRS")
	private String pxrs;

	@Column(name = "Regnum")
	private String rm;

	@Column(name = "idpx")
	private String idpx;

	@Column(name = "Nama")
	private String nama;

	@Column(name = "Addr")
	private String alamat;

	@Column(name = "Roomname")
	private String ruang;

	@Temporal(TemporalType.DATE)
	@Column(name = "Tanggal")
	private Date tanggal;

	@Temporal(TemporalType.TIME)
	@Column(name = "Jam")
	private Date jam;

	@Column(name = "DokterID")
	private String dokter;

	@Column(name = "DiagnosaID")
	private String diagnosa;

	@Column(name = "Ketdiag")
	private String ketdiagnosa;

	@Column(name = "TindakanID")
	private String planop;

	@Column(name = "Aka")
	private String layanan;

	@Column(name = "Status")
	private String status;

	@Column(name = "tempatOK")
	private String tempatop;

	@Column(name = "ren")
	private String reninap;

	@Column(name = "Telepon")
	private String telp;

	@Column(name = "iddok")
	private String dokterid;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getKode() {
		return kode;
	}

	public void setKode(Long kode) {
		this.id = kode;
	}

	public String getPxrs() {
		return pxrs;
	}

	public void setPxrs(String pxrs) {
		this.pxrs = pxrs;
	}

	public String getRm() {
		return rm;
	}

	public void setRm(String rm) {
		this.rm = rm;
	}

	public String getIdpx() {
		return idpx;
	}

	public void setIdpx(String idpx) {
		this.idpx = idpx;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public String getAlamat() {
		return alamat;
	}

	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}

	public String getRuang() {
		return ruang;
	}

	public void setRuang(String ruang) {
		this.ruang = ruang;
	}

	public Date getTanggal() {
		return tanggal;
	}

	public void setTanggal(Date tanggal) {
		this.tanggal = tanggal;
	}

	public Date getJam() {
		return jam;
	}

	public void setJam(Date jam) {
		this.jam = jam;
	}

	public String getDokter() {
		return dokter;
	}

	public void setDokter(String dokter) {
		this.dokter = dokter;
	}

	public String getDiagnosa() {
		return diagnosa;
	}

	public void setDiagnosa(String diagnosa) {
		this.diagnosa = diagnosa;
	}

	public String getKetdiagnosa() {
		return ketdiagnosa;
	}

	public void setKetiagnosa(String ketdiagnosa) {
		this.ketdiagnosa = ketdiagnosa;
	}

	public String getPlanop() {
		return planop;
	}

	public void setPlanop(String planop) {
		this.planop = planop;
	}

	public String getLayanan() {
		return layanan;
	}

	public void setLayanan(String layanan) {
		this.layanan = layanan;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTempatop() {
		return tempatop;
	}

	public void setTempatop(String tempatop) {
		this.tempatop = tempatop;
	}

	public String getReninap() {
		return reninap;
	}

	public void setReninap(String reninap) {
		this.reninap = reninap;
	}

	public String getTelp() {
		return telp;
	}

	public void setTelp(String telp) {
		this.telp = telp;
	}

	public String getDokterid() {
		return dokterid;
	}

	public void setDokterid(String dokterid) {
		this.dokterid = dokterid;
	}
}
