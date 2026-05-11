package com.dev.generik.entities.HaloRSA;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "WSBEDREADY")
public class BedReady {
	@Id
	@Column(name = "BRID")
	private Long id;

	@Column(name = "Pav", length = 20)
	private String paviliun;

	@Column(name = "Kelas", length = 20)
	private String kelas;

	@Column(name = "Jtt")
	private Long jumlah;

	@Column(name = "re")
	private Long ready;

	@Column(name = "PavID")
	private Long pavid;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPaviliun() {
		return paviliun;
	}

	public void setPaviliun(String paviliun) {
		this.paviliun = paviliun;
	}

	public String getKelas() {
		return kelas;
	}

	public void setKelas(String kelas) {
		this.kelas = kelas;
	}

	public Long getJumlah() {
		return jumlah;
	}

	public void setJumlah(Long jumlah) {
		this.jumlah = jumlah;
	}

	public Long getReady() {
		return ready;
	}

	public void setReady(Long ready) {
		this.ready = ready;
	}

	public Long getPavid() {
		return pavid;
	}

	public void setPavid(Long pavid) {
		this.ready = pavid;
	}
}
