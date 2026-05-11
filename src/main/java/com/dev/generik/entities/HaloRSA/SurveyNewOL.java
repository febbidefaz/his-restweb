package com.dev.generik.entities.HaloRSA;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
// import javax.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

@Entity
@Table(name = "SURVEYKEPUASANPX")
public class SurveyNewOL {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "Tgl")
	@Temporal(TemporalType.DATE)
	private Date tgl;

	@Column(name = "Nama")
	@Nullable
	private String nama;

	@Column(name = "Alamat")
	@NonNull
	private String alamat;

	@Column(name = "Kota")
	@NonNull
	private String kota;

	@Column(name = "Telp")
	@NonNull
	private String telp;

	@Column(name = "Jenispelayanan")
	@NonNull
	private Long jenispelayanan;

	@Column(name = "Unitperawatan")
	@NonNull
	private Long unitperawatan;

	@Column(name = "Sumberinformasi")
	@NonNull
	private Long sumberinformasi;

	@Column(name = "Waktutunggu")
	@NonNull
	private Long waktutunggu;

	@Column(name = "Keramahanpetugas")
	@NonNull
	private Long keramahanpetugas;

	@Column(name = "Kemudahan")
	@NonNull
	private Long kemudahan;

	@Column(name = "Kebersihan")
	@NonNull
	private Long kebersihan;

	@Column(name = "Keamanan")
	@NonNull
	private Long keamanan;

	@Column(name = "Pelayanan")
	@NonNull
	private Long pelayanan;

	@Column(name = "Rekomendasi")
	@NonNull
	private Long rekomendasi;

	@Column(name = "Saran")
	@NonNull
	private String saran;

	@Column(name = "Petugas")
	@NonNull
	private String petugas;

	public SurveyNewOL() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getTgl() {
		return tgl;
	}

	public void setTgl(Date tgl) {
		this.tgl = tgl;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public String getAlamat() {
		return alamat;
	}

	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}

	public String getKota() {
		return kota;
	}

	public void setKota(String kota) {
		this.kota = kota;
	}

	public String getTelp() {
		return telp;
	}

	public void setTelp(String telp) {
		this.telp = telp;
	}

	public Long getJenispelayanan() {
		return jenispelayanan;
	}

	public void setJenispelayanan(long jenispelayanan) {
		this.jenispelayanan = jenispelayanan;
	}

	public Long getUnitperawatan() {
		return unitperawatan;
	}

	public void setUnitperawatan(long unitperawatan) {
		this.unitperawatan = unitperawatan;
	}

	public Long getSumberinformasi() {
		return sumberinformasi;
	}

	public void setSumberinformasi(long sumberinformasi) {
		this.sumberinformasi = sumberinformasi;
	}

	public Long getWaktutunggu() {
		return waktutunggu;
	}

	public void setWaktutunggu(long waktutunggu) {
		this.waktutunggu = waktutunggu;
	}

	public Long getKeramahanpetugas() {
		return keramahanpetugas;
	}

	public void setKeramahanpetugas(long keramahanpetugas) {
		this.keramahanpetugas = keramahanpetugas;
	}

	public Long getKemudahan() {
		return kemudahan;
	}

	public void setKemudahan(long kemudahan) {
		this.kemudahan = kemudahan;
	}

	public Long getKebersihan() {
		return kebersihan;
	}

	public void setKebersihan(long kebersihan) {
		this.kebersihan = kebersihan;
	}

	public Long getKeamanan() {
		return keamanan;
	}

	public void setKeamanan(long keamanan) {
		this.keamanan = keamanan;
	}

	public Long getPelayanan() {
		return pelayanan;
	}

	public void setPelayanan(long pelayanan) {
		this.pelayanan = pelayanan;
	}

	public Long getRekomendasi() {
		return rekomendasi;
	}

	public void setRekomendasi(long rekomendasi) {
		this.rekomendasi = rekomendasi;
	}

	public String getSaran() {
		return saran;
	}

	public void setSaran(String saran) {
		this.saran = saran;
	}

	public String getPetugas() {
		return petugas;
	}

	public void setPetugas(String petugas) {
		this.petugas = petugas;
	}

}
