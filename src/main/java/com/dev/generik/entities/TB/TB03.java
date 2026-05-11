package com.dev.generik.entities.TB;

import java.util.Date;

//import java.util.Date;

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
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

//import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

@Entity
@Table(name = "TB03")

@NamedStoredProcedureQueries({
		@NamedStoredProcedureQuery(name = "UpdateTB03", procedureName = "UpdateTB03_sp", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "id", type = Long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "idtb03", type = String.class),
		//		@StoredProcedureParameter(mode = ParameterMode.IN, name = "kdPasien", type = String.class),
		//		@StoredProcedureParameter(mode = ParameterMode.IN, name = "nik", type = String.class),
		//		@StoredProcedureParameter(mode = ParameterMode.IN, name = "jenisKelamin", type = String.class),
		//		@StoredProcedureParameter(mode = ParameterMode.IN, name = "alamatLengkap", type = String.class)
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "idPropinsiFaskes", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "kdKabupatenFaskes", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "idPropinsiPasien", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "kdKabupatenPasien", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "kdFasyankes", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "kodeIcdX", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "tipeDiagnosa", type = Long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "klasifikasiLokasiAnatomi", type = Long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "klasifikasiRiwayatPengobatan", type = Long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "tanggalMulaiPengobatan", type = Date.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "panduanObat", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "sebelumPengobatanHasilMikroskopis", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "sebelumPengobatanHasilTesCepat", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "sebelumPengobatanHasilBiakan", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "hasilMikroskopisBulan2", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "hasilMikroskopisBulan3", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "hasilMikroskopisBulan5", type = Long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "akhirPengobatanHasilMikroskopis", type = Long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "tanggalHasilAkhirPengobatan", type = Date.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "hasilAkhirPengobatan", type = Date.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "fotoToraks", type = Date.class)
			}) })

public class TB03 {

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Nullable
	@Column(name = "Id")
	private Long id;

	@Column(name = "ID_TB_03")
	@Nullable
	private String idtb03;
	
//	@Column(name = "KD_PASIEN")
//	@Nullable
//	private String kdPasien;

//	@Column(name = "NIK")
//	@Nullable
//	private String nik;

//	@Column(name = "JENIS_KELAMIN")
//	@Nullable
//	private String jenisKelamin;

//	@Column(name = "ALAMAT_LENGKAP")
//	@Nullable
//	private String alamatLengkap;
	
	@Column(name = "ID_PROPINSI_FASKES")
	@Nullable
	private String idPropinsiFaskes;
	
	@Column(name = "KD_KABUPATEN_FASKES")
	@Nullable
	private String kdKabupatenFaskes;
	
	@Column(name = "ID_PROPINSI_PASIEN")
	@Nullable
	private String idPropinsiPasien;
	
	@Column(name = "KD_KABUPATEN_PASIEN")
	@Nullable
	private String kdKabupatenPasien;
	
	@Column(name = "KD_FASYANKES")
	@Nullable
	private String kdFasyankes;
	
	@Column(name = "KODE_ICD_X")
	@Nullable
	private String kodeIcdX;
	
	@Column(name = "TIPE_DIAGNOSA")
	@Nullable
	private Long tipeDiagnosa;
	
	@Column(name = "KLASIFIKASI_LOKASI_ANATOMI")
	@Nullable
	private Long klasifikasiLokasiAnatomi;
	
	@Column(name = "KLASIFIKASI_RIWAYAT_PENGOBATAN")
	@Nullable
	private Long klasifikasiRiwayatPengobatan;
	
	@Column(name = "TANGGAL_MULAI_PENGOBATAN")
	@Temporal(TemporalType.DATE)
	private Date tanggalMulaiPengobatan;
	
	@Column(name = "PANDUAN_OBAT")
	@Nullable
	private String panduanObat;
	
	@Column(name = "SEBELUM_PENGOBATAN_HASIL_MIKROSKOPIS")
	@Nullable
	private String sebelumPengobatanHasilMikroskopis;
	
	@Column(name = "SEBELUM_PENGOBATAN_HASIL_TES_CEPAT")
	@Nullable
	private String sebelumPengobatanHasilTesCepat;
	
	@Column(name = "SEBELUM_PENGOBATAN_HASIL_BIAKAN")
	@Nullable
	private String sebelumPengobatanHasilBiakan;
	
	@Column(name = "HASIL_MIKROSKOPIS_BULAN_2")
	@Nullable
	private String hasilMikroskopisBulan2;
	
	@Column(name = "HASIL_MIKROSKOPIS_BULAN_3")
	@Nullable
	private String hasilMikroskopisBulan3;
	
	@Column(name = "HASIL_MIKROSKOPIS_BULAN_5")
	@Nullable
	private String hasilMikroskopisBulan5;
	
	@Column(name = "AKHIR_PENGOBATAN_HASIL_MIKROSKOPIS")
	@Nullable
	private String akhirPengobatanHasilMikroskopis;
	
	@Column(name = "TANGGAL_HASIL_AKHIR_PENGOBATAN")
	@Temporal(TemporalType.DATE)
	private Date tanggalHasilAkhirPengobatan;
	
	@Column(name = "HASIL_AKHIR_PENGOBATAN")
	@Nullable
	private String hasilAkhirPengobatan;
	
	@Column(name = "FOTO_TORAKS")
	@Nullable
	private String fotoToraks;
	
	@Column(name = "TANGGAL")
	@Temporal(TemporalType.DATE)
	private Date tanggal;
	
	public TB03() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TB03(Long id, String idtb03, String idPropinsiFaskes, String kdKabupatenFaskes, String idPropinsiPasien,
			String kdKabupatenPasien, String kdFasyankes, String kodeIcdX, Long tipeDiagnosa,
			Long klasifikasiLokasiAnatomi, Long klasifikasiRiwayatPengobatan, Date tanggalMulaiPengobatan,
			String panduanObat, String sebelumPengobatanHasilMikroskopis, String sebelumPengobatanHasilTesCepat,
			String sebelumPengobatanHasilBiakan, String hasilMikroskopisBulan2, String hasilMikroskopisBulan3,
			String hasilMikroskopisBulan5, String akhirPengobatanHasilMikroskopis, Date tanggalHasilAkhirPengobatan,
			String hasilAkhirPengobatan, String fotoToraks, Date tanggal) {
		super();
		this.id = id;
		this.idtb03 = idtb03;
		this.idPropinsiFaskes = idPropinsiFaskes;
		this.kdKabupatenFaskes = kdKabupatenFaskes;
		this.idPropinsiPasien = idPropinsiPasien;
		this.kdKabupatenPasien = kdKabupatenPasien;
		this.kdFasyankes = kdFasyankes;
		this.kodeIcdX = kodeIcdX;
		this.tipeDiagnosa = tipeDiagnosa;
		this.klasifikasiLokasiAnatomi = klasifikasiLokasiAnatomi;
		this.klasifikasiRiwayatPengobatan = klasifikasiRiwayatPengobatan;
		this.tanggalMulaiPengobatan = tanggalMulaiPengobatan;
		this.panduanObat = panduanObat;
		this.sebelumPengobatanHasilMikroskopis = sebelumPengobatanHasilMikroskopis;
		this.sebelumPengobatanHasilTesCepat = sebelumPengobatanHasilTesCepat;
		this.sebelumPengobatanHasilBiakan = sebelumPengobatanHasilBiakan;
		this.hasilMikroskopisBulan2 = hasilMikroskopisBulan2;
		this.hasilMikroskopisBulan3 = hasilMikroskopisBulan3;
		this.hasilMikroskopisBulan5 = hasilMikroskopisBulan5;
		this.akhirPengobatanHasilMikroskopis = akhirPengobatanHasilMikroskopis;
		this.tanggalHasilAkhirPengobatan = tanggalHasilAkhirPengobatan;
		this.hasilAkhirPengobatan = hasilAkhirPengobatan;
		this.fotoToraks = fotoToraks;
		this.tanggal = tanggal;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIdtb03() {
		return idtb03;
	}

	public void setIdtb03(String idtb03) {
		this.idtb03 = idtb03;
	}

	public String getIdPropinsiFaskes() {
		return idPropinsiFaskes;
	}

	public void setIdPropinsiFaskes(String idPropinsiFaskes) {
		this.idPropinsiFaskes = idPropinsiFaskes;
	}

	public String getKdKabupatenFaskes() {
		return kdKabupatenFaskes;
	}

	public void setKdKabupatenFaskes(String kdKabupatenFaskes) {
		this.kdKabupatenFaskes = kdKabupatenFaskes;
	}

	public String getIdPropinsiPasien() {
		return idPropinsiPasien;
	}

	public void setIdPropinsiPasien(String idPropinsiPasien) {
		this.idPropinsiPasien = idPropinsiPasien;
	}

	public String getKdKabupatenPasien() {
		return kdKabupatenPasien;
	}

	public void setKdKabupatenPasien(String kdKabupatenPasien) {
		this.kdKabupatenPasien = kdKabupatenPasien;
	}

	public String getKdFasyankes() {
		return kdFasyankes;
	}

	public void setKdFasyankes(String kdFasyankes) {
		this.kdFasyankes = kdFasyankes;
	}

	public String getKodeIcdX() {
		return kodeIcdX;
	}

	public void setKodeIcdX(String kodeIcdX) {
		this.kodeIcdX = kodeIcdX;
	}

	public Long getTipeDiagnosa() {
		return tipeDiagnosa;
	}

	public void setTipeDiagnosa(Long tipeDiagnosa) {
		this.tipeDiagnosa = tipeDiagnosa;
	}

	public Long getKlasifikasiLokasiAnatomi() {
		return klasifikasiLokasiAnatomi;
	}

	public void setKlasifikasiLokasiAnatomi(Long klasifikasiLokasiAnatomi) {
		this.klasifikasiLokasiAnatomi = klasifikasiLokasiAnatomi;
	}

	public Long getKlasifikasiRiwayatPengobatan() {
		return klasifikasiRiwayatPengobatan;
	}

	public void setKlasifikasiRiwayatPengobatan(Long klasifikasiRiwayatPengobatan) {
		this.klasifikasiRiwayatPengobatan = klasifikasiRiwayatPengobatan;
	}

	public Date getTanggalMulaiPengobatan() {
		return tanggalMulaiPengobatan;
	}

	public void setTanggalMulaiPengobatan(Date tanggalMulaiPengobatan) {
		this.tanggalMulaiPengobatan = tanggalMulaiPengobatan;
	}

	public String getPanduanObat() {
		return panduanObat;
	}

	public void setPanduanObat(String panduanObat) {
		this.panduanObat = panduanObat;
	}

	public String getSebelumPengobatanHasilMikroskopis() {
		return sebelumPengobatanHasilMikroskopis;
	}

	public void setSebelumPengobatanHasilMikroskopis(String sebelumPengobatanHasilMikroskopis) {
		this.sebelumPengobatanHasilMikroskopis = sebelumPengobatanHasilMikroskopis;
	}

	public String getSebelumPengobatanHasilTesCepat() {
		return sebelumPengobatanHasilTesCepat;
	}

	public void setSebelumPengobatanHasilTesCepat(String sebelumPengobatanHasilTesCepat) {
		this.sebelumPengobatanHasilTesCepat = sebelumPengobatanHasilTesCepat;
	}

	public String getSebelumPengobatanHasilBiakan() {
		return sebelumPengobatanHasilBiakan;
	}

	public void setSebelumPengobatanHasilBiakan(String sebelumPengobatanHasilBiakan) {
		this.sebelumPengobatanHasilBiakan = sebelumPengobatanHasilBiakan;
	}

	public String getHasilMikroskopisBulan2() {
		return hasilMikroskopisBulan2;
	}

	public void setHasilMikroskopisBulan2(String hasilMikroskopisBulan2) {
		this.hasilMikroskopisBulan2 = hasilMikroskopisBulan2;
	}

	public String getHasilMikroskopisBulan3() {
		return hasilMikroskopisBulan3;
	}

	public void setHasilMikroskopisBulan3(String hasilMikroskopisBulan3) {
		this.hasilMikroskopisBulan3 = hasilMikroskopisBulan3;
	}

	public String getHasilMikroskopisBulan5() {
		return hasilMikroskopisBulan5;
	}

	public void setHasilMikroskopisBulan5(String hasilMikroskopisBulan5) {
		this.hasilMikroskopisBulan5 = hasilMikroskopisBulan5;
	}

	public String getAkhirPengobatanHasilMikroskopis() {
		return akhirPengobatanHasilMikroskopis;
	}

	public void setAkhirPengobatanHasilMikroskopis(String akhirPengobatanHasilMikroskopis) {
		this.akhirPengobatanHasilMikroskopis = akhirPengobatanHasilMikroskopis;
	}

	public Date getTanggalHasilAkhirPengobatan() {
		return tanggalHasilAkhirPengobatan;
	}

	public void setTanggalHasilAkhirPengobatan(Date tanggalHasilAkhirPengobatan) {
		this.tanggalHasilAkhirPengobatan = tanggalHasilAkhirPengobatan;
	}

	public String getHasilAkhirPengobatan() {
		return hasilAkhirPengobatan;
	}

	public void setHasilAkhirPengobatan(String hasilAkhirPengobatan) {
		this.hasilAkhirPengobatan = hasilAkhirPengobatan;
	}

	public String getFotoToraks() {
		return fotoToraks;
	}

	public void setFotoToraks(String fotoToraks) {
		this.fotoToraks = fotoToraks;
	}
	
	public Date getTanggal() {
		return tanggal;
	}

	public void setTanggal(Date tanggal) {
		this.tanggal = tanggal;
	}
	
}
