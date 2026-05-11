package com.dev.generik.entities.Lab;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedStoredProcedureQueries;
import jakarta.persistence.NamedStoredProcedureQuery;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureParameter;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.OptBoolean;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@Entity
@Table(name = "PCREXTERNAL")
@NamedStoredProcedureQueries({
		@NamedStoredProcedureQuery(name = "UpdatePCRExternal", procedureName = "UpdatePCRExternal_sp", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "id", type = Long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "nama", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "alamat", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "tgllahir", type = Date.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "tgl", type = Date.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "instansi", type = Long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "ktp", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "hasil", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "nik", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "pembayaran", type = Long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "bukti", type = String.class), }) })

public class PCRExternal {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private Long id;

	@Column(name = "Nama")
	private String nama;

	@Column(name = "Alamat")
	private String alamat;

	@JsonFormat(shape = Shape.STRING, pattern = "dd-MM-yyyy", lenient = OptBoolean.FALSE, timezone = "Asia/Jakarta")
	@Temporal(TemporalType.DATE)
	@Column(name = "Tgl_lahir")
	private Date tgllahir;

	@JsonFormat(shape = Shape.STRING, pattern = "dd-MM-yyyy", lenient = OptBoolean.FALSE, timezone = "Asia/Jakarta")
	@Temporal(TemporalType.DATE)
	@Column(name = "Tgl")
	private Date tgl;

	@Column(name = "Instansi")
	private Long instansi;

	@Column(name = "Ktp")
	private String ktp;

	@Column(name = "Hasil")
	private String hasil;

	@Column(name = "Nik")
	private String nik;

	@Column(name = "Pembayaran")
	private Long pembayaran;

	@Column(name = "Bukti")
	private String bukti;

	public PCRExternal() {
		super();
	}

	public PCRExternal(Long id, String nama, String alamat, Date tgllahir, Date tgl, Long instansi, String ktp,
			String hasil, String nik, Long pembayaran, String bukti) {

		super();
		this.id = id;
		this.nama = nama;
		this.alamat = alamat;
		this.tgllahir = tgllahir;
		this.tgl = tgl;
		this.instansi = instansi;
		this.ktp = ktp;
		this.hasil = hasil;
		this.nik = nik;
		this.pembayaran = pembayaran;
		this.bukti = bukti;

	}

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

	public String getAlamat() {
		return alamat;
	}

	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}

	public Date getTgllahir() {
		return tgllahir;
	}

	public void setTgllahir(Date tgllahir) {
		this.tgllahir = tgllahir;
	}

	public Date getTgl() {
		return tgl;
	}

	public void setTgl(Date tgl) {
		this.tgl = tgl;
	}

	public Long getInstansi() {
		return instansi;
	}

	public void setInstansi(Long instansi) {
		this.instansi = instansi;
	}

	public String getKtp() {
		return ktp;
	}

	public void setKtp(String ktp) {
		this.ktp = ktp;
	}

	public String getHasil() {
		return hasil;
	}

	public void setHasil(String hasil) {
		this.hasil = hasil;
	}

	public String getNik() {
		return nik;
	}

	public void setNik(String nik) {
		this.nik = nik;
	}

	public Long getPembayaran() {
		return pembayaran;
	}

	public void setPembayaran(Long pembayaran) {
		this.pembayaran = pembayaran;
	}

	public String getBukti() {
		return bukti;
	}

	public void setBukti(String bukti) {
		this.bukti = bukti;
	}
}
