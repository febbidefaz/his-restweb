package com.dev.generik.models;

import java.io.Serializable;
import java.util.Date;

/*import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.OptBoolean;
import com.fasterxml.jackson.annotation.JsonFormat.Shape; */

public class PCRExternalModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3121922636150247050L;
	private Long id;
//	private String nama;
//	private String alamat;
//	@JsonFormat(shape=Shape.STRING,  pattern="dd-MM-yyyy", lenient=OptBoolean.FALSE)
//	@Temporal(TemporalType.DATE)

	private Date tgllahir;
//	private Date tgl;
//	private String instansi;
//	private String ktp;

	private String hasil;

	public PCRExternalModel() {
		super();
	}

	public PCRExternalModel(Long id,
			// String nama,
			// String alamat,
			Date tgllahir,
			// Date tgl,
			// String instansi,
			// String ktp,
			String hasil) {

		super();
		this.id = id;
		// this.nama = nama;
		// this.alamat = alamat;
		this.tgllahir = tgllahir;
		// this.tgl = tgl;
		// this.instansi = instansi;
		// this.ktp = ktp;
		this.hasil = hasil;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getTgllahir() {
		return tgllahir;
	}

	public void setTgllahir(Date tgllahir) {
		this.tgllahir = tgllahir;
	}

	public String getHasil() {
		return hasil;
	}

	public void setHasil(String hasil) {
		this.hasil = hasil;
	}

}
