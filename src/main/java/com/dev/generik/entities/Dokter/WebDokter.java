package com.dev.generik.entities.Dokter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;
//import org.springframework.lang.Nullable;

@Entity
@Table(name = "WSWEBDOKTER")
public class WebDokter {
	@Id
	@Column(name = "Id")
	private Long id;

	@Column(name = "Dokter")
	private String dokter;

	@Column(name = "Spesialis")
	private String spesialis;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

}
