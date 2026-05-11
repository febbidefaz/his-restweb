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

//import org.springframework.lang.Nullable;

@Entity
@Table(name = "WSJADWALDOKTERDISPLAY")
public class JadwalDokterDisplay {
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
	private String prak;

	@Column(name = "libur")
	private Long libur;

	@Temporal(TemporalType.DATE)
	private Date tgllibur;

	@Column(name = "allpx")
	private Long allpx;

	@Column(name = "finishpx")
	private Long finishpx;

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
		this.tutup = tutup;
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

	public String getPrak() {
		return prak;
	}

	public void setPrak(String prak) {
		this.prak = prak;
	}

	public Long getLibur() {
		return libur;
	}

	public void setLibur(Long libur) {
		this.libur = libur;
	}

	public Date getTgllibur() {
		return tgllibur;
	}

	public void setTgllibur(Date tgllibur) {
		this.tgllibur = tgllibur;
	}

	public Long getAllpx() {
		return allpx;
	}

	public void setAllpx(Long allpx) {
		this.allpx = allpx;
	}

	public Long getFinishpx() {
		return finishpx;
	}

	public void setFinishpx(Long finishpx) {
		this.finishpx = finishpx;
	}

}
