package com.dev.generik.entities.TB;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedStoredProcedureQueries;
import jakarta.persistence.NamedStoredProcedureQuery;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureParameter;
// import javax.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

//import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

@Entity
@Table(name = "TB06")

@NamedStoredProcedureQueries({
		@NamedStoredProcedureQuery(name = "UpdateTB06", procedureName = "UpdateTB06_sp", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "id", type = Long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "nodahak", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "tglsitb", type = Date.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "umur", type = Long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "dirujuk", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "LokasiAnatomiPenyakit", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "TotalSkoringTBAnak", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "HasilPemeriksaanFotoToraks", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "StatusHIV", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "RiwayatDM", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "TglPengambianA", type = Date.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "TglPengambianB", type = Date.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "TglPengambianC", type = Date.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "MikroskopisTGL", type = Date.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "MikroskopisHA", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "MikroskopisHB", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "MikroskopisHC", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "XpertMTBRIFTGL", type = Date.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "XpertMTBRIHasil", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "BiakanTGL", type = Date.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "BiakanHasil", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "NoRegLabTB06", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "TindakLanjutPengobatanTGL", type = Date.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "TindakLanjutPengobatanDirujuk", type = String.class)
				}) })

public class TB06 {

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Nullable
	@Column(name = "Id")
	private Long id;

	@Column(name = "Nodahak")
	@Nullable
	private String nodahak;

	@Column(name = "Tglsitb")
	@Temporal(TemporalType.DATE)
	private Date tglsitb;

	@Column(name = "umur")
	@Nullable
	private Long umur;

	@Column(name = "Dirujuk")
	@Nullable
	private String dirujuk;

	@Column(name = "LOKASIANATOMIPENYAKIT")
	@Nullable
	private String lokasiAnatomiPenyakit;

	@Column(name = "TOTALSKORINGTBANAK")
	@Nullable
	private String totalSkoringTBAnak;

	@Column(name = "HASILPEMERIKSAANFOTOTORAKS")
	@Nullable
	private String hasilPemeriksaanFotoToraks;

	@Column(name = "STATUSHIV")
	@Nullable
	private String statusHIV;

	@Column(name = "RIWAYATDM")
	@Nullable
	private String riwayatDM;
	
	@Column(name = "TGLPENGAMBILANA")
	@Temporal(TemporalType.DATE)
	private Date tglPengambilanA;
	
	@Column(name = "TGLPENGAMBILANB")
	@Temporal(TemporalType.DATE)
	private Date tglPengambilanB;

	@Column(name = "TGLPENGAMBILANC")
	@Temporal(TemporalType.DATE)
	private Date tglPengambilanC;
	
	@Column(name = "MIKROSKOPISTGL")
	private String mikroskopisTgl;
	
	@Column(name = "MIKROSKOPISHA")
	@Nullable
	private String mikroskopisHA;
	
	@Column(name = "MIKROSKOPISHB")
	@Nullable
	private String mikroskopisHB;
	
	@Column(name = "MIKROSKOPISHC")
	@Nullable
	private String mikroskopisHC;
	
	@Column(name = "XPERTMTBRIFTGL")
	@Temporal(TemporalType.DATE)
	private Date xpertMtbRifTgl;
	
	@Column(name = "XPERTMTBRIFHASIL")
	@Nullable
	private String xpertMtbRifHasil;
	
	@Column(name = "BIAKANTGL")
	@Temporal(TemporalType.DATE)
	private Date biakanTgl;
	
	@Column(name = "BIAKANHASIL")
	@Nullable
	private String biakanHasil;

	@Column(name = "NOREGLABTB04")
	@Nullable
	private String noRegLabTb04;
	
	@Column(name = "TINDAKLANJUTPENGOBATANTGL")
	@Temporal(TemporalType.DATE)
	private Date tindakLanjutPengobatanTgl;
	
	@Column(name = "TINDAKLANJUTPENGOBATANDIRUJUK")
	@Nullable
	private String tindakLanjutPengobatanDirujuk;
	
	@Column(name = "TANGGAL")
	@Temporal(TemporalType.DATE)
	private Date tanggal;
	
	public TB06() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public TB06(Long id, String nodahak, Date tglsitb, Long umur, String dirujuk, String lokasiAnatomiPenyakit,
			String totalSkoringTBAnak, String hasilPemeriksaanFotoToraks, String statusHIV, String riwayatDM,
			Date tglPengambilanA, Date tglPengambilanB, Date tglPengambilanC, String mikroskopisTgl,
			String mikroskopisHA, String mikroskopisHB, String mikroskopisHC, Date xpertMtbRifTgl,
			String xpertMtbRifHasil, Date biakanTgl, String biakanHasil, String noRegLabTb04,
			Date tindakLanjutPengobatanTgl, String tindakLanjutPengobatanDirujuk, Date tanggal) {
		super();
		this.id = id;
		this.nodahak = nodahak;
		this.tglsitb = tglsitb;
		this.umur = umur;
		this.dirujuk = dirujuk;
		this.lokasiAnatomiPenyakit = lokasiAnatomiPenyakit;
		this.totalSkoringTBAnak = totalSkoringTBAnak;
		this.hasilPemeriksaanFotoToraks = hasilPemeriksaanFotoToraks;
		this.statusHIV = statusHIV;
		this.riwayatDM = riwayatDM;
		this.tglPengambilanA = tglPengambilanA;
		this.tglPengambilanB = tglPengambilanB;
		this.tglPengambilanC = tglPengambilanC;
		this.mikroskopisTgl = mikroskopisTgl;
		this.mikroskopisHA = mikroskopisHA;
		this.mikroskopisHB = mikroskopisHB;
		this.mikroskopisHC = mikroskopisHC;
		this.xpertMtbRifTgl = xpertMtbRifTgl;
		this.xpertMtbRifHasil = xpertMtbRifHasil;
		this.biakanTgl = biakanTgl;
		this.biakanHasil = biakanHasil;
		this.noRegLabTb04 = noRegLabTb04;
		this.tindakLanjutPengobatanTgl = tindakLanjutPengobatanTgl;
		this.tindakLanjutPengobatanDirujuk = tindakLanjutPengobatanDirujuk;
		this.tanggal = tanggal;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNodahak() {
		return nodahak;
	}

	public void setNodahak(String nodahak) {
		this.nodahak = nodahak;
	}

	public Date getTglsitb() {
		return tglsitb;
	}

	public void setTglsitb(Date tglsitb) {
		this.tglsitb = tglsitb;
	}

	public Long getUmur() {
		return umur;
	}

	public void setUmur(Long umur) {
		this.umur = umur;
	}

	public String getDirujuk() {
		return dirujuk;
	}

	public void setDirujuk(String dirujuk) {
		this.dirujuk = dirujuk;
	}

	public String getLokasiAnatomiPenyakit() {
		return lokasiAnatomiPenyakit;
	}

	public void setLokasiAnatomiPenyakit(String lokasiAnatomiPenyakit) {
		this.lokasiAnatomiPenyakit = lokasiAnatomiPenyakit;
	}

	public String getTotalSkoringTBAnak() {
		return totalSkoringTBAnak;
	}

	public void setTotalSkoringTBAnak(String totalSkoringTBAnak) {
		this.totalSkoringTBAnak = totalSkoringTBAnak;
	}

	public String getHasilPemeriksaanFotoToraks() {
		return hasilPemeriksaanFotoToraks;
	}

	public void setHasilPemeriksaanFotoToraks(String hasilPemeriksaanFotoToraks) {
		this.hasilPemeriksaanFotoToraks = hasilPemeriksaanFotoToraks;
	}

	public String getStatusHIV() {
		return statusHIV;
	}

	public void setStatusHIV(String statusHIV) {
		this.statusHIV = statusHIV;
	}

	public String getRiwayatDM() {
		return riwayatDM;
	}

	public void setRiwayatDM(String riwayatDM) {
		this.riwayatDM = riwayatDM;
	}

	public Date getTglPengambilanA() {
		return tglPengambilanA;
	}

	public void setTglPengambilanA(Date tglPengambilanA) {
		this.tglPengambilanA = tglPengambilanA;
	}

	public Date getTglPengambilanB() {
		return tglPengambilanB;
	}

	public void setTglPengambilanB(Date tglPengambilanB) {
		this.tglPengambilanB = tglPengambilanB;
	}

	public Date getTglPengambilanC() {
		return tglPengambilanC;
	}

	public void setTglPengambilanC(Date tglPengambilanC) {
		this.tglPengambilanC = tglPengambilanC;
	}

	public String getMikroskopisTgl() {
		return mikroskopisTgl;
	}

	public void setMikroskopisTgl(String mikroskopisTgl) {
		this.mikroskopisTgl = mikroskopisTgl;
	}

	public String getMikroskopisHA() {
		return mikroskopisHA;
	}

	public void setMikroskopisHA(String mikroskopisHA) {
		this.mikroskopisHA = mikroskopisHA;
	}

	public String getMikroskopisHB() {
		return mikroskopisHB;
	}

	public void setMikroskopisHB(String mikroskopisHB) {
		this.mikroskopisHB = mikroskopisHB;
	}

	public String getMikroskopisHC() {
		return mikroskopisHC;
	}

	public void setMikroskopisHC(String mikroskopisHC) {
		this.mikroskopisHC = mikroskopisHC;
	}

	public Date getXpertMtbRifTgl() {
		return xpertMtbRifTgl;
	}

	public void setXpertMtbRifTgl(Date xpertMtbRifTgl) {
		this.xpertMtbRifTgl = xpertMtbRifTgl;
	}

	public String getXpertMtbRifHasil() {
		return xpertMtbRifHasil;
	}

	public void setXpertMtbRifHasil(String xpertMtbRifHasil) {
		this.xpertMtbRifHasil = xpertMtbRifHasil;
	}

	public Date getBiakanTgl() {
		return biakanTgl;
	}

	public void setBiakanTgl(Date biakanTgl) {
		this.biakanTgl = biakanTgl;
	}

	public String getBiakanHasil() {
		return biakanHasil;
	}

	public void setBiakanHasil(String biakanHasil) {
		this.biakanHasil = biakanHasil;
	}

	public String getNoRegLabTb04() {
		return noRegLabTb04;
	}

	public void setNoRegLabTb04(String noRegLabTb04) {
		this.noRegLabTb04 = noRegLabTb04;
	}

	public Date getTindakLanjutPengobatanTgl() {
		return tindakLanjutPengobatanTgl;
	}

	public void setTindakLanjutPengobatanTgl(Date tindakLanjutPengobatanTgl) {
		this.tindakLanjutPengobatanTgl = tindakLanjutPengobatanTgl;
	}

	public String getTindakLanjutPengobatanDirujuk() {
		return tindakLanjutPengobatanDirujuk;
	}

	public void setTindakLanjutPengobatanDirujuk(String tindakLanjutPengobatanDirujuk) {
		this.tindakLanjutPengobatanDirujuk = tindakLanjutPengobatanDirujuk;
	}
	
	public Date getTanggal() {
		return tanggal;
	}

	public void setTanggal(Date tanggal) {
		this.tanggal = tanggal;
	}

	
	

}
