package com.dev.generik.entities.Rad;

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
@Table(name = "WSRADIOLOGIBACAPERIKSA")
public class RadiologiBacaPeriksa {
	@Id
	@Column(name = "ID")
	private String id;

	@Column(name = "Idpx")
	private Long idpx;

	@Column(name = "Idrad")
	private Long idrad;

	@Column(name = "Norm")
	private String norm;

	@Column(name = "Nama")
	private String nama;

	@Column(name = "Addr")
	private String addr;

	@Temporal(TemporalType.DATE)
	@Column(name = "Tgl")
	private Date tgl;

	@Column(name = "Periksa")
	private String periksa;

	@Column(name = "Statusbaca")
	private Long statusbaca;

	@Column(name = "Result")
	private String result;

	@Column(name = "Kesimpulan")
	private String kesimpulan;
	
	@Column(name = "Pdf")
	private String pdf;
	
	@Column(name = "IDPERIKSA")
	private Long idperiksa;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getIdpx() {
		return idpx;
	}

	public void setIdpx(Long idpx) {
		this.idpx = idpx;
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

	public String getPeriksa() {
		return periksa;
	}

	public void setPeriksa(String periksa) {
		this.periksa = periksa;
	}

	public Long getStatusbaca() {
		return statusbaca;
	}

	public void setStatusbaca(Long statusbaca) {
		this.statusbaca = statusbaca;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getKesimpulan() {
		return kesimpulan;
	}

	public void setKesimpulan(String kesimpulan) {
		this.kesimpulan = kesimpulan;
	}
	
	public String getPdf() {
		return pdf;
	}

	public void setPdf(String pdf) {
		this.pdf = pdf;
	}

	public Long getIdperiksa() {
		return idperiksa;
	}

	public void setIdperiksa(Long idperiksa) {
		this.idperiksa = idperiksa;
	}

}
