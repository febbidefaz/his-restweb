package com.dev.generik.entities.HaloRSA;

import java.util.Date;

//import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "WSPXRJPCRALL")
public class PxRJPCRALL {
	@Id
	@Column(name = "Id")
	private Long id;

	@Column(name = "Regnum")
	private String regnum;

	@Column(name = "Nama")
	private String nama;

	@Column(name = "Addr")
	private String addr;

	@Column(name = "Pxrs")
	private String pxrs;

	@Column(name = "Pxno")
	private Long pxno;

	@Column(name = "Nik")
	private String nik;

	@Temporal(TemporalType.DATE)
	@Column(name = "Tgl")
	private Date tgl;

	@Temporal(TemporalType.DATE)
	@Column(name = "Tanggal_lahir")
	private Date tanggal_lahir;

	@Column(name = "Jenis_kelamin")
	private String jenis_kelamin;

	@Column(name = "Ktp")
	private String ktp;

	@Column(name = "Buktitransfer")
	private String buktitransfer;

	@Column(name = "Idstatustransaksirj")
	private Long idstatustransaksirj;

	@Column(name = "Statustransaksirj")
	private String statustransaksirj;

	@Column(name = "Idol")
	private Long idol;

	@Column(name = "PCR")
	private String pcr;

	@Column(name = "Sublayanan")
	private String sublayanan;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRegnum() {
		return regnum;
	}

	public void setRegnum(String regnum) {
		this.regnum = regnum;
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

	public String getPxrs() {
		return pxrs;
	}

	public void setPxrs(String pxrs) {
		this.pxrs = pxrs;
	}

	public Long getPxno() {
		return pxno;
	}

	public void setPxno(Long pxno) {
		this.pxno = pxno;
	}

	public String getNik() {
		return nik;
	}

	public void setNik(String nik) {
		this.nik = nik;
	}

	public Date getTgl() {
		return tgl;
	}

	public void setTgl(Date tgl) {
		this.tgl = tgl;
	}

	public Date getTanggal_lahir() {
		return tanggal_lahir;
	}

	public void setTanggal_lahir(Date tanggal_lahir) {
		this.tanggal_lahir = tanggal_lahir;
	}

	public String getJenis_kelamin() {
		return jenis_kelamin;
	}

	public void setJenis_kelamin(String jenis_kelamin) {
		this.jenis_kelamin = jenis_kelamin;
	}

	public String getKtp() {
		return ktp;
	}

	public void setKtp(String ktp) {
		this.ktp = ktp;
	}

	public String getBuktitransfer() {
		return buktitransfer;
	}

	public void setBuktitransfer(String buktitransfer) {
		this.buktitransfer = buktitransfer;
	}

	public Long getIdstatustransaksirj() {
		return idstatustransaksirj;
	}

	public void setIdstatustransaksirj(Long idstatustransaksirj) {
		this.idstatustransaksirj = idstatustransaksirj;
	}

	public String getStatustransaksirj() {
		return statustransaksirj;
	}

	public void setStatustransaksirj(String statustransaksirj) {
		this.statustransaksirj = statustransaksirj;
	}

	public Long getIdol() {
		return idol;
	}

	public void setIdol(Long idol) {
		this.idol = idol;
	}

	public String getPcr() {
		return pcr;
	}

	public void setPcr(String pcr) {
		this.pcr = pcr;
	}

	public String getSublayanan() {
		return sublayanan;
	}

	public void setSublayanan(String sublayanan) {
		this.sublayanan = sublayanan;
	}

}
