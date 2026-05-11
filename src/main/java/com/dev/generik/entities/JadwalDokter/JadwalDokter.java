package com.dev.generik.entities.JadwalDokter;

import java.util.Date;

//import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;

import org.springframework.lang.Nullable;

@Entity
@Table(name = "WSJADWALDOKTER")
public class JadwalDokter {
	@Id
	@Column(name = "id")
	private Long id;

	@Column(name = "kode")
	private Long kode;

	@Column(name = "Dokter", length = 20)
	private String dokter;

	@Column(name = "Spesialis", length = 20)
	private String spesialis;

	@Column(name = "hari", length = 20)
	private String hari;

	@Temporal(TemporalType.TIME)
	private Date buka;

	@Temporal(TemporalType.TIME)
	private Date tutup;

	@Column(name = "hr")
	private Long hr;

	@Column(name = "dr")
	private Long dr;

	@Column(name = "prak")
	private Long prak;

	@Column(name = "PHOTO")
//	@Lob
	@Nullable
	private byte[] photo;

	@Column(name = "sp")
	private Long idklinik;

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
		this.kode = kode;
	}

	public String getDokter() {
		return dokter;
	}

	public void setDokter(String dokter) {
		this.dokter = dokter;
	}

	public String getSpesialis() {
		return spesialis;
	}

	public void setSpesialis(String spesialis) {
		this.spesialis = spesialis;
	}

	public String getHari() {
		return hari;
	}

	public void setHari(String hari) {
		this.hari = hari;
	}

	public Date getBuka() {
		return buka;
	}

	public void setBuka(Date buka) {
		this.buka = buka;
	}

	public Date getTutup() {
		return tutup;
	}

	public void setTutup(Date tutup) {
		this.buka = tutup;
	}

	public Long getHr() {
		return hr;
	}

	public void setHr(Long hr) {
		this.hr = hr;
	}

	public Long getDr() {
		return dr;
	}

	public void setDr(Long dr) {
		this.dr = dr;
	}

	public Long getPrak() {
		return prak;
	}

	public void setPrak(Long prak) {
		this.prak = prak;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public Long getIdklinik() {
		return idklinik;
	}

	public void setIdklinik(Long idklinik) {
		this.idklinik = idklinik;
	}

}
