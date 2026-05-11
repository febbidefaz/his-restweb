package com.dev.generik.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;



@Entity
@Table(name = "WSINACBG")
public class Inacbg {
	@Id
	@Column(name = "ID")
	private Long id;

	@Column(name = "RM")
	private String rm;

	@Temporal(TemporalType.DATE)
	@Column(name = "TGLMASUK")
	private Date tglMasuk;

	@Column(name = "PROSEDURNONBEDAH")
	private Long prosedurNonBedah;

	@Column(name = "PROSEDURBEDAH")
	private Long prosedurBedah;
	
	@Column(name = "KONSULTASI")
	private Long konsultasi;
	
	@Column(name = "TENAGAAHLI")
	private Long tengaAhli;
	
	@Column(name = "KEPERAWATAN")
	private Long keperawatan;

	@Column(name = "PENUNJANG")
	private Long penunjang;
	
	@Column(name = "RADIOLOGI")
	private Long radiologi;
	
	@Column(name = "LABORATORIUM")
	private Long laboratorium;
	
	@Column(name = "REHABILITASI")
	private Long rehabilitasi;
	
	@Column(name = "KAMAR")
	private Long kamar;
	
	@Column(name = "KAMARINTENSIF")
	private Long kamarIntensif;
	
	@Column(name = "OBAT")
	private Long obat;
	
	@Column(name = "BMHP")
	private Long bmhp;
	
	@Column(name = "SEWAALAT")
	private Long sewaAlat;
	
	@Column(name = "KELAS")
	private Long kelas;

	@Column(name = "DPJP")
	private String dpjp;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "TGLPLG")
	private Date tglPlg;
	
	@Column(name = "PELAYANANDARAH")
	private Long pelayananDarah;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRm() {
		return rm;
	}

	public void setRm(String rm) {
		this.rm = rm;
	}

	public Date getTglMasuk() {
		return tglMasuk;
	}

	public void setTglMasuk(Date tglMasuk) {
		this.tglMasuk = tglMasuk;
	}

	public Long getProsedurNonBedah() {
		return prosedurNonBedah;
	}

	public void setProsedurNonBedah(Long prosedurNonBedah) {
		this.prosedurNonBedah = prosedurNonBedah;
	}

	public Long getProsedurBedah() {
		return prosedurBedah;
	}

	public void setProsedurBedah(Long prosedurBedah) {
		this.prosedurBedah = prosedurBedah;
	}

	public Long getKonsultasi() {
		return konsultasi;
	}

	public void setKonsultasi(Long konsultasi) {
		this.konsultasi = konsultasi;
	}

	public Long getTengaAhli() {
		return tengaAhli;
	}

	public void setTengaAhli(Long tengaAhli) {
		this.tengaAhli = tengaAhli;
	}

	public Long getKeperawatan() {
		return keperawatan;
	}

	public void setKeperawatan(Long keperawatan) {
		this.keperawatan = keperawatan;
	}

	public Long getPenunjang() {
		return penunjang;
	}

	public void setPenunjang(Long penunjang) {
		this.penunjang = penunjang;
	}

	public Long getRadiologi() {
		return radiologi;
	}

	public void setRadiologi(Long radiologi) {
		this.radiologi = radiologi;
	}

	public Long getLaboratorium() {
		return laboratorium;
	}

	public void setLaboratorium(Long laboratorium) {
		this.laboratorium = laboratorium;
	}

	public Long getRehabilitasi() {
		return rehabilitasi;
	}

	public void setRehabilitasi(Long rehabilitasi) {
		this.rehabilitasi = rehabilitasi;
	}

	public Long getKamar() {
		return kamar;
	}

	public void setKamar(Long kamar) {
		this.kamar = kamar;
	}

	public Long getKamarIntensif() {
		return kamarIntensif;
	}

	public void setKamarIntensif(Long kamarIntensif) {
		this.kamarIntensif = kamarIntensif;
	}

	public Long getObat() {
		return obat;
	}

	public void setObat(Long obat) {
		this.obat = obat;
	}

	public Long getBmhp() {
		return bmhp;
	}

	public void setBmhp(Long bmhp) {
		this.bmhp = bmhp;
	}

	public Long getSewaAlat() {
		return sewaAlat;
	}

	public void setSewaAlat(Long sewaAlat) {
		this.sewaAlat = sewaAlat;
	}

	public Long getKelas() {
		return kelas;
	}

	public void setKelas(Long kelas) {
		this.kelas = kelas;
	}

	public String getDpjp() {
		return dpjp;
	}

	public void setDpjp(String dpjp) {
		this.dpjp = dpjp;
	}

	public Date getTglPlg() {
		return tglPlg;
	}

	public void setTglPlg(Date tglPlg) {
		this.tglPlg = tglPlg;
	}

	public Long getPelayananDarah() {
		return pelayananDarah;
	}

	public void setPelayananDarah(Long pelayananDarah) {
		this.pelayananDarah = pelayananDarah;
	}
	
	
	
	
	
}
