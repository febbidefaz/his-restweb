package com.dev.generik.entities.Lab;

//import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;

import org.springframework.lang.NonNull;

@Entity
@Table(name = "WSLABHASILLEVEL")
public class LabHasilLevel {
	@Id
	@Column(name = "Id")
	private Long id;

	@Column(name = "Idlvl")
	@NonNull
	private Long lvl;

	@Column(name = "Nama")
	@NonNull
	private String nama;

	@Column(name = "Isi")
	@NonNull
	private String isi;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getLvl() {
		return lvl;
	}

	public void setLvl(Long lvl) {
		this.lvl = lvl;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public String getIsi() {
		return isi;
	}

	public void setIsi(String isi) {
		this.isi = isi;
	}

}
