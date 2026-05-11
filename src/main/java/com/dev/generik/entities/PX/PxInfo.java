package com.dev.generik.entities.PX;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "WSPASIENINFO")
public class PxInfo {
	// SELECT t.ID, p.RegNum, p.Nama, p.Addr, p.Tanggal_Lahir
	// FROM dbo.PasienList AS p INNER JOIN
	// dbo.Therapy AS t ON p.RegNum = t.Register
	@Id
	private Long id;

	@Column(name = "NAMA")
	private String nama;

	@Column(name = "REGNUM")
	private String regnum;

	@Column(name = "ADDR")
	private String addr;

	@Temporal(TemporalType.DATE)
	@Column(name = "TANGGAL_LAHIR")
	private Date tlahir;

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

	public String getRegnum() {
		return regnum;
	}

	public void setRegnum(String regnum) {
		this.regnum = regnum;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public Date getTlahir() {
		return tlahir;
	}

	public void setTlahir(Date tlahir) {
		this.tlahir = tlahir;
	}

}
