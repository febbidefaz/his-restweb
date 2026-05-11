package com.dev.generik.entities.HaloRSA;

import java.io.Serializable;
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
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

@Entity
@Table(name = "OLTHERAPY")
@NamedStoredProcedureQueries({
		@NamedStoredProcedureQuery(name = "UpdateOLTherapy", procedureName = "UpdateOLTherapy_sp", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "regid", type = Long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "buktitransfer", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "status", type = Integer.class), }) })

public class RegNewOL implements Serializable {

	private static final long serialVersionUID = -4031144012940015082L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "USERID")
	@NonNull
	private String userid;

	@Column(name = "SUBLAYANAN")
	@NonNull
	private String sublayanan;

	@Column(name = "LAYANAN")
	@NonNull
	private String layanan;

	@Column(name = "TGL")
	@Temporal(TemporalType.DATE)
	@NonNull
	private Date tgl;

	@Column(name = "JAM_PRAKTEK")
	@NonNull
	private Long jampraktek;

	@Column(name = "REGISTER")
	@NonNull
	private String register;

	@Column(name = "DOKTERID")
	@NonNull
	private Long dokterid;

	@Column(name = "KTP")
	@Nullable
	private String ktp;

	@Column(name = "BUKTITRANSFER")
	@Nullable
	private String buktitransfer;

	@Column(name = "STATUS")
//	@Nullable
	private Long status;

	@Column(name = "NORUJUKAN")
	@Nullable
	private String norujukan;

	@Column(name = "Upx")
//	@Nullable
	private Long upx;

	public RegNewOL() {
		super();
	}

	public RegNewOL(Long id, String userid, String sublayanan, String layanan, Date tgl, Long jampraktek,
			String register, Long dokterid, String ktp, String buktitransfer, Long status, String norujukan, Long upx) {

		super();
		this.id = id;
		this.userid = userid;
		this.sublayanan = sublayanan;
		this.layanan = layanan;
		this.tgl = tgl;
		this.jampraktek = jampraktek;
		this.register = register;
		this.dokterid = dokterid;
		this.ktp = ktp;
		this.buktitransfer = buktitransfer;
		this.status = status;
		this.norujukan = norujukan;
		this.upx = upx;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getSublayanan() {
		return sublayanan;
	}

	public void setSublayanan(String sublayanan) {
		this.sublayanan = sublayanan;
	}

	public String getLayanan() {
		return layanan;
	}

	public void setLayanan(String layanan) {
		this.layanan = layanan;
	}

	public Date getTgl() {
		return tgl;
	}

	public void setTgl(Date tgl) {
		this.tgl = tgl;
	}

	public Long getJampraktek() {
		return jampraktek;
	}

	public void setJampraktek(Long jampraktek) {
		this.jampraktek = jampraktek;
	}

	public String getRegister() {
		return register;
	}

	public void setRegister(String register) {
		this.register = register;
	}

	public Long getDokterid() {
		return dokterid;
	}

	public void setDokterid(Long dokterid) {
		this.dokterid = dokterid;
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

	public Long getStatus() {
		return status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}

	public String getNorujukan() {
		return norujukan;
	}

	public void setNorujukan(String norujukan) {
		this.norujukan = norujukan;
	}

	public Long getUpx() {
		return upx;
	}

	public void setUpx(Long upx) {
		this.upx = upx;
	}

}
