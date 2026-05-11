package com.dev.generik.entities.Lab;

//import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;

@Entity
@Table(name = "WSLABHASIL")
public class LabHasil {
	@Id
	@Column(name = "Id")
	private Long id;

	@Column(name = "Idlab")
	private Long idlab;

	@Column(name = "Perik")
	private String perik;

	@Column(name = "Levels")
	private String isi;

	@Column(name = "Biaya")
	private Long biaya;

	@Column(name = "NorL")
	private String nor;

	@Column(name = "Idlevel")
	private Long lev;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdlab() {
		return idlab;
	}

	public void setIdlab(Long idlab) {
		this.idlab = idlab;
	}

	public String getPerik() {
		return perik;
	}

	public void setPerik(String perik) {
		this.perik = perik;
	}

	public String getIsi() {
		return isi;
	}

	public void setIsi(String isi) {
		this.isi = isi;
	}

	public Long getBiaya() {
		return biaya;
	}

	public void setBiaya(Long biaya) {
		this.biaya = biaya;
	}

	public String getNor() {
		return nor;
	}

	public void setNor(String nor) {
		this.nor = nor;
	}

	public Long getLev() {
		return lev;
	}

	public void setLev(Long lev) {
		this.lev = lev;
	}

}
