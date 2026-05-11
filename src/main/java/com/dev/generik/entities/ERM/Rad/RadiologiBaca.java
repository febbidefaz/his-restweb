package com.dev.generik.entities.ERM.Rad;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "WSRADIOLOGIBACA")
public class RadiologiBaca {
	@Id
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "IDT")
	private Long idt;

	@Column(name = "Idrad")
	private Long idrad;

	@Column(name = "Norm")
	private String norm;

	@Column(name = "Nama")
	private String nama;

	@Column(name = "Addr")
	private String addr;

	@Column(name = "Tgl")
	@Temporal(TemporalType.DATE)
	private Date tgl;

	@Column(name = "Statusbaca")
	private Long statusbaca;

	@Column(name = "Ket")
	private String ket;

	@Column(name = "IDdokter")
	private Long iddokter;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getIdt() {
		return idt;
	}

	public void setIdt(Long idt) {
		this.idt = idt;
	}

	public Long getIdrad() {
		return idrad;
	}

	public void setIdrad(Long idrad) {
		this.idrad = idrad;
	}

	public String getNorm() {
		return norm;
	}

	public void setNorm(String norm) {
		this.norm = norm;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public Date getTgl() {
		return tgl;
	}

	public void setTgl(Date tgl) {
		this.tgl = tgl;
	}

	public Long getStatusbaca() {
		return statusbaca;
	}

	public void setStatusbaca(Long statusbaca) {
		this.statusbaca = statusbaca;
	}

	public String getKet() {
		return ket;
	}

	public void setKet(String ket) {
		this.ket = ket;
	}

	public Long getIddokter() {
		return iddokter;
	}

	public void setIddokter(Long iddokter) {
		this.iddokter = iddokter;
	}

}
