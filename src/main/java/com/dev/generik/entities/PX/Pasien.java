package com.dev.generik.entities.PX;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "PASIENLIST")
public class Pasien {

	@Id
	@Column(name = "REGNUM")
	private String id;

	@Column(name = "NAMA")
	private String nama;

	@Column(name = "ADDR")
	private String addr;

	@Column(name = "KELURAHAN")
	private String kelurahan;

	@Column(name = "TELEPON")
	private String telepon;

	@Temporal(TemporalType.DATE)
	@Column(name = "TANGGAL_LAHIR")
	private Date tglahir;

	@Column(name = "JENIS_KELAMIN")
	private String sextype;

	@Column(name = "STATUS")
	private Long status;

	@Column(name = "SUKU")
	private Long suku;

	@Column(name = "AGAMA")
	private Long agama;

	@Column(name = "PENDIDIKAN")
	private Long edu;

	@Column(name = "NIK")
	private String noktp;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getKelurahan() {
		return kelurahan;
	}

	public void setKelurahan(String kelurahan) {
		this.kelurahan = kelurahan;
	}

	public String getTelepon() {
		return telepon;
	}

	public void setTelepon(String telepon) {
		this.telepon = telepon;
	}

	public Date getTglahir() {
		return tglahir;
	}

	public void setTglahir(Date tglahir) {
		this.tglahir = tglahir;
	}

	public String getSextype() {
		return sextype;
	}

	public void setSextype(String sextype) {
		this.sextype = sextype;
	}

	public Long getStatus() {
		return status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}

	public Long getSuku() {
		return suku;
	}

	public void setSuku(Long suku) {
		this.suku = suku;
	}

	public Long getAgama() {
		return agama;
	}

	public void setAgama(Long agama) {
		this.agama = agama;
	}

	public Long getEdu() {
		return edu;
	}

	public void setEdu(Long edu) {
		this.edu = edu;
	}

	public String getNoktp() {
		return noktp;
	}

	public void setNoktp(String noktp) {
		this.noktp = noktp;
	}

}
