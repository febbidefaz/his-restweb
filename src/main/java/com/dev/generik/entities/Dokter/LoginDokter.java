package com.dev.generik.entities.Dokter;

//import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;

@Entity
@Table(name = "WSLOGINDOKTER")
public class LoginDokter {
	@Id
	@Column(name = "Id")
	private Long id;

	@Column(name = "Dokter")
	private String dokter;

	@Column(name = "Spesialis")
	private String spesialis;

	@Column(name = "Sp")
	private Long sp;

	@Column(name = "Name")
	private String name;

	@Column(name = "Pass")
	private String pass;

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

	public Long getSp() {
		return sp;
	}

	public void setSp(Long sp) {
		this.sp = sp;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

}
