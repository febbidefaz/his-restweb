package com.dev.generik.entities.PSDI;

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

//import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

@Entity
@Table(name = "DIKLATWEB")

@NamedStoredProcedureQueries({
		@NamedStoredProcedureQuery(name = "UpdateDiklat", procedureName = "UpdateDiklat_sp", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "diklatid", type = Long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "tanggal", type = Date.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "isi", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "fotojudul", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "foto1", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "foto2", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "foto3", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "foto4", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "pdf1", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "pdf2", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "pdf3", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "pdf4", type = String.class) }) })

public class DiklatNew {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "Judul")
	@Nullable
	private String judul;

	@Column(name = "Tanggal")
	@Temporal(TemporalType.DATE)
	private Date tanggal;

	@Column(name = "Isi")
	@Nullable
	private String isi;

	@Column(name = "Fotojudul")
	@Nullable
	private String fotojudul;

	@Column(name = "Foto1")
	@Nullable
	private String foto1;

	@Column(name = "Foto2")
	@Nullable
	private String foto2;

	@Column(name = "Foto3")
	@Nullable
	private String foto3;

	@Column(name = "Foto4")
	@Nullable
	private String foto4;

	@Column(name = "Pdf1")
	@Nullable
	private String pdf1;

	@Column(name = "Pdf2")
	@Nullable
	private String pdf2;

	@Column(name = "Pdf3")
	@Nullable
	private String pdf3;

	@Column(name = "Pdf4")
	@Nullable
	private String pdf4;

	public DiklatNew() {
		super();
	}

	public DiklatNew(Long id, String judul, Date tanggal, String isi, String fotojudul, String foto1, String foto2,
			String foto3, String foto4, String pdf1, String pdf2, String pdf3, String pdf4) {
		super();
		this.id = id;
		this.judul = judul;
		this.tanggal = tanggal;
		this.isi = isi;
		this.fotojudul = fotojudul;
		this.foto1 = foto1;
		this.foto2 = foto2;
		this.foto3 = foto3;
		this.foto4 = foto4;
		this.pdf1 = pdf1;
		this.pdf2 = pdf2;
		this.pdf3 = pdf3;
		this.pdf4 = pdf4;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getJudul() {
		return judul;
	}

	public void setJudul(String judul) {
		this.judul = judul;
	}

	public Date getTanggal() {
		return tanggal;
	}

	public void setTanggal(Date tanggal) {
		this.tanggal = tanggal;
	}

	public String getIsi() {
		return isi;
	}

	public void setIsi(String isi) {
		this.isi = isi;
	}

	public String getFotojudul() {
		return fotojudul;
	}

	public void setFotojudul(String fotojudul) {
		this.fotojudul = fotojudul;
	}

	public String getFoto1() {
		return foto1;
	}

	public void setFoto1(String foto1) {
		this.foto1 = foto1;
	}

	public String getFoto2() {
		return foto2;
	}

	public void setFoto2(String foto2) {
		this.foto2 = foto2;
	}

	public String getFoto3() {
		return foto3;
	}

	public void setFoto3(String foto3) {
		this.foto3 = foto3;
	}

	public String getFoto4() {
		return foto4;
	}

	public void setFoto4(String foto4) {
		this.foto4 = foto4;
	}

	public String getPdf1() {
		return pdf1;
	}

	public void setPdf1(String pdf1) {
		this.pdf1 = pdf1;
	}

	public String getPdf2() {
		return pdf2;
	}

	public void setPdf2(String pdf2) {
		this.pdf2 = pdf2;
	}

	public String getPdf3() {
		return pdf3;
	}

	public void setPdf3(String pdf3) {
		this.pdf3 = pdf3;
	}

	public String getPdf4() {
		return pdf4;
	}

	public void setPdf4(String pdf4) {
		this.pdf4 = pdf4;
	}

}
