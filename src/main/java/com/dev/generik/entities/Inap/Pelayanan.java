package com.dev.generik.entities.Inap;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "WSPELAYANAN")
public class Pelayanan {
	@Id
	@Column(name = "Id")
	private Long id;

	@Column(name = "Nama")
	private String nama;

	@Column(name = "Kode")
	private Long kode;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public Long getKode() {
		return kode;
	}

	public void setKode(Long kode) {
		this.kode = kode;
	}

}
