package com.dev.generik.entities.JadwalDokter;
//import java.util.Date;

//import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;

//import org.springframework.lang.Nullable;

@Entity
@Table(name = "WSJADWALDOKTERPRAKLAB")
public class JadwalDokterPrakLab {
	@Id
	@Column(name = "id")
	private Long id;

	@Column(name = "dr")
	private Long dr;

	@Column(name = "hr")
	private Long hr;

	@Column(name = "prak")
	private String prak;

	@Column(name = "jml")
	private Long jml;

	@Column(name = "ready")
	private Long ready;

	@Column(name = "shift")
	private String shift;

	@Column(name = "ket")
	private Long ket;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getDr() {
		return dr;
	}

	public void setDr(Long dr) {
		this.dr = dr;
	}

	public Long getHr() {
		return hr;
	}

	public void setHr(Long hr) {
		this.hr = hr;
	}

	public String getPrak() {
		return prak;
	}

	public void setPrak(String prak) {
		this.prak = prak;
	}

	public Long getJml() {
		return jml;
	}

	public void setJml(Long jml) {
		this.jml = jml;
	}

	public Long getReady() {
		return ready;
	}

	public void setReady(Long ready) {
		this.ready = ready;
	}

	public String getShift() {
		return shift;
	}

	public void setShift(String shift) {
		this.shift = shift;
	}

	public Long getKet() {
		return ket;
	}

	public void setKet(Long ket) {
		this.ket = ket;
	}

}
