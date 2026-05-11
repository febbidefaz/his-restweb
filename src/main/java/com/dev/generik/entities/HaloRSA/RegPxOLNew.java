package com.dev.generik.entities.HaloRSA;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

@Entity
@Table(name = "REGPXOL")

//
public class RegPxOLNew {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "Nama")
	@NonNull
	private String nama;

	@Column(name = "Addr")
	@Nullable
	private String addr;

	@Column(name = "Kelurahan")
	@Nullable
	private String kel;

	@Column(name = "Telepon")
	@Nullable
	private String tlpn;

	@Column(name = "Tanggal_Lahir")
	@Nullable
	@Temporal(TemporalType.DATE)
	private Date tlahir;

	@Column(name = "Golongan_darah")
	@Nullable
	private String goldr;

	@Column(name = "Jenis_Kelamin")
	@Nullable
	private String jk;

	@Column(name = "Ojob")
	@Nullable
	private String job;

	@Column(name = "Suami_Istri")
	@Nullable
	private String suamiistri;

	@Column(name = "Ayah_Ibu")
	@Nullable
	private String ayahibu;

	@Column(name = "Status")
	@Nullable
	private Long status;

	@Column(name = "Suku")
	@Nullable
	private Long suku;

	@Column(name = "Agama")
	@Nullable
	private Long agama;

	@Column(name = "Pendidikan")
	@Nullable
	private Long pend;

	@Column(name = "Nik")
	@NonNull
	private String nik;

	@Column(name = "Nojkn")
	@Nullable
	private String nojkn;

	@Column(name = "Regnum")
//	@Nullable
	private String regnum;

	@Column(name = "Statusregpx")
	@Nullable
	private Long statusregpx;

	@Column(name = "Userid")
	@Nullable
	private String userid;

	@Column(name = "Ojob_ayah")
	@Nullable
	private String job_ayah;

	@Column(name = "Namabin")
	@NonNull
	private String namabin;

	@Column(name = "Kecamatan")
	@NonNull
	private String kec;

	public RegPxOLNew() {
		super();
	}

	/*
	 * public RegPxOL(Long id, String nama, String kel, String tlpn, Date tlahir,
	 * String goldr,String jk, String job, String suamiistri, String ayahibu, Long
	 * status, Long suku, Long agama, Long pend, String nik, String nojkn ) {
	 * super(); this.id = id; this.nama = nama; this.kel = kel; this.tlpn = tlpn;
	 * this.tlahir = tlahir; this.goldr = goldr; this.jk = jk; this.job = job;
	 * this.suamiistri = suamiistri; this.ayahibu = ayahibu; this.status = status;
	 * this.suku = suku; this.agama = agama; this.pend = pend; this.nik = nik;
	 * this.nojkn = nojkn;
	 * 
	 * }
	 */

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

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getKel() {
		return kel;
	}

	public void setKel(String kel) {
		this.kel = kel;
	}

	public String getTlpn() {
		return tlpn;
	}

	public void setTlpn(String tlpn) {
		this.tlpn = tlpn;
	}

	public Date getTlahir() {
		return tlahir;
	}

	public void setTlahir(Date tlahir) {
		this.tlahir = tlahir;
	}

	public String getGoldr() {
		return goldr;
	}

	public void setGoldr(String goldr) {
		this.goldr = goldr;
	}

	public String getJk() {
		return jk;
	}

	public void setJk(String jk) {
		this.jk = jk;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getSuamiistri() {
		return suamiistri;
	}

	public void setSuamiistri(String suamiistri) {
		this.suamiistri = suamiistri;
	}

	public String getAyahibu() {
		return ayahibu;
	}

	public void setAyahibu(String ayahibu) {
		this.ayahibu = ayahibu;
	}

	public Long getStatus() {
		return status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}

	public Long getSuku() {
		return suku;
	}

	public void setSuku(Long suku) {
		this.suku = suku;
	}

	public Long getAgama() {
		return agama;
	}

	public void setAgama(Long agama) {
		this.agama = agama;
	}

	public Long getPend() {
		return pend;
	}

	public void setPend(Long pend) {
		this.pend = pend;
	}

	public String getNik() {
		return nik;
	}

	public void setNik(String nik) {
		this.nik = nik;
	}

	public String getNojkn() {
		return nojkn;
	}

	public void setNojkn(String nojkn) {
		this.nojkn = nojkn;
	}

	public String getRegnum() {
		return regnum;
	}

	public void setRegnum(String regnum) {
		this.regnum = regnum;
	}

	public Long getStatusregpx() {
		return statusregpx;
	}

	public void setStatusregpx(Long statusregpx) {
		this.statusregpx = statusregpx;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getJob_ayah() {
		return job_ayah;
	}

	public void setJob_ayah(String job_ayah) {
		this.job_ayah = job_ayah;
	}

	public String getNamabin() {
		return namabin;
	}

	public void setNamabin(String namabin) {
		this.namabin = namabin;
	}

	public String getKec() {
		return kec;
	}

	public void setKec(String kec) {
		this.kec = kec;
	}

}
