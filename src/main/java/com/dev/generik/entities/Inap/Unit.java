package com.dev.generik.entities.Inap;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;
//import org.springframework.lang.Nullable;

@Entity
@Table(name = "WSUNIT")
public class Unit {
	@Id
	@Column(name = "Id")
	private Long id;

	@Column(name = "Nama")
	private String nama;

	@Column(name = "Pelayanan")
	private Long pelayanan;

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

	public Long getPelayanan() {
		return pelayanan;
	}

	public void setPelayanan(Long pelayanan) {
		this.pelayanan = pelayanan;
	}

	public Long getKode() {
		return kode;
	}

	public void setKode(Long kode) {
		this.kode = kode;
	}

}
