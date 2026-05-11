package com.dev.generik.entities.HaloRSA;

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
// import javax.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

@Entity
@Table(name = "PXNEWOL")

@NamedStoredProcedureQueries({
		@NamedStoredProcedureQuery(name = "UpdatePxNewOnline", procedureName = "UpdatePxNewOnline_sp", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "pxid", type = Long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "regnum", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "nama", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "addr", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "telepon", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "tlahir", type = Date.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "jk", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "pekerjaaan", type = Integer.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "status", type = Integer.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "nik", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "nojkn", type = String.class) }) })
//
public class PxNewOL {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "REGNUM")
	@Nullable
	private String norm;

	@Column(name = "NAMA")
	@NonNull
	private String nama;

	@Column(name = "ADDR")
	@NonNull
	private String addr;

	@Column(name = "TELEPON")
	@NonNull
	private String phone;

	@Column(name = "TLAHIR")
	@NonNull
	@Temporal(TemporalType.DATE)
	private Date tlahir;

	@Column(name = "JK")
	@NonNull
	private String sextype;

	@Column(name = "STATUS")
	private Long status;

	@Column(name = "PEKERJAAN")
	private Long pekerjaan;

	@Column(name = "PHOTO")
//	@Lob
	@Nullable
	private byte[] photo;

	@Column(name = "NIK")
	@NonNull
	private String noktp;

	@Column(name = "NOJKN")
	@Nullable
	private String nojkn;

	public PxNewOL() {
		super();
	}

	public PxNewOL(Long id, String norm, String nama, String addr, String phone, Date tlahir, String sextype,
			Long status, Long pekerjaan, byte[] photo, String noktp, String nojkn) {
		super();
		this.id = id;
		this.norm = norm;
		this.nama = nama;
		this.addr = addr;
		this.phone = phone;
		this.tlahir = tlahir;
		this.sextype = sextype;
		this.status = status;
		this.pekerjaan = pekerjaan;
		this.photo = photo;
		this.noktp = noktp;
		this.nojkn = nojkn;
	}

	public Long getStatus() {
		return status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}

	public Long getPekerjaan() {
		return pekerjaan;
	}

	public void setPekerjaan(Long pekerjaan) {
		this.pekerjaan = pekerjaan;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getTlahir() {
		return tlahir;
	}

	public void setTlahir(Date tlahir) {
		this.tlahir = tlahir;
	}

	public String getSextype() {
		return sextype;
	}

	public void setSextype(String sextype) {
		this.sextype = sextype;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public String getNoktp() {
		return noktp;
	}

	public void setNoktp(String noktp) {
		this.noktp = noktp;
	}

	public String getNojkn() {
		return nojkn;
	}

	public void setNojkn(String nojkn) {
		this.nojkn = nojkn;
	}
}
