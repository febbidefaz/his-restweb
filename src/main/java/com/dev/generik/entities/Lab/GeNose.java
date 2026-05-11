package com.dev.generik.entities.Lab;

import java.io.Serializable;
import java.util.Date;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "GENOSE")

public class GeNose implements Serializable {

	private static final long serialVersionUID = -4031144012940015002L;

	@Id
	@Column(name = "ID")
	private Long id;

	@Column(name = "NIK")
	@NonNull
	private String nik;

	@Column(name = "NAMA")
	@NonNull
	private String nama;

	@Column(name = "ALAMAT")
	private String alamat;

	@Column(name = "TGLLAHIR")
	@Temporal(TemporalType.DATE)
	private Date tgllahir;

	@Column(name = "KELAMIN")
	private String kelamin;

	@Column(name = "HASIL")
	private Long hasil;

	@Lob
	@Column(name = "BUKTITRANSFER")
	private byte[] buktitransfer;

	@Column(name = "STATUS")
	private Long status;

	@Column(name = "USERID")
	private String userid;

	public GeNose() {
		super();
	}

	public GeNose(Long id, String nik, String nama, String alamat, Date tgllahir, String kelamin, Long hasil,
			byte[] buktitransfer, Long status, String userid) {

		super();
		this.id = id;
		this.nik = nik;
		this.nama = nama;
		this.alamat = alamat;
		this.tgllahir = tgllahir;
		this.kelamin = kelamin;
		this.hasil = hasil;
		this.buktitransfer = buktitransfer;
		this.status = status;
		this.userid = userid;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNik() {
		return nik;
	}

	public void setNik(String nik) {
		this.nik = nik;
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

	public Date getTgllahir() {
		return tgllahir;
	}

	public void setTgllahir(Date tgllahir) {
		this.tgllahir = tgllahir;
	}

	public String getKelamin() {
		return kelamin;
	}

	public void setKelamin(String kelamin) {
		this.kelamin = kelamin;
	}

	public Long getHasil() {
		return hasil;
	}

	public void setHasil(Long hasil) {
		this.hasil = hasil;
	}

	public byte[] getBuktitransfer() {
		return buktitransfer;
	}

	public void setBuktitransfer(byte[] buktitransfer) {
		this.buktitransfer = buktitransfer;
	}

	public Long getStatus() {
		return status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

}
