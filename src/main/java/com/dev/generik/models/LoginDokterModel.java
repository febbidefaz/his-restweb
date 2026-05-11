package com.dev.generik.models;

import java.io.Serializable;

/*import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.OptBoolean;
import com.fasterxml.jackson.annotation.JsonFormat.Shape; */

public class LoginDokterModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3121922636150247050L;
	private Long id;
	private String dokter;
	private String spesialis;
//	@JsonFormat(shape=Shape.STRING,  pattern="dd-MM-yyyy", lenient=OptBoolean.FALSE)
//	@Temporal(TemporalType.DATE)

//	private String name;
//	private Date tgl;
//	private String instansi;
//	private String ktp;

//	private Long upx ;

	public LoginDokterModel() {
		super();
	}

	public LoginDokterModel(Long id, String dokter,
			// String alamat,
			// Date tgllahir,
			// Date tgl,
			// String instansi,
			// String ktp,
			String spesialis) {

		super();
		this.id = id;
		this.dokter = dokter;
		// this.alamat = alamat;
		// this.tgllahir = tgllahir;
		// this.tgl = tgl;
		// this.instansi = instansi;
		// this.ktp = ktp;
		this.spesialis = spesialis;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDokter() {
		return dokter;
	}

	public void setDokter(String dokter) {
		this.dokter = dokter;
	}

	public String getSpesialis() {
		return spesialis;
	}

	public void setSpesialis(String spesialis) {
		this.spesialis = spesialis;
	}

}
