package com.dev.generik.models;

import java.io.Serializable;

/*import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.OptBoolean;
import com.fasterxml.jackson.annotation.JsonFormat.Shape; */

public class CekPasienModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3121922636150247050L;
//	private Long id; 
//	private String nama;
//	private String alamat;
//	@JsonFormat(shape=Shape.STRING,  pattern="dd-MM-yyyy", lenient=OptBoolean.FALSE)
//	@Temporal(TemporalType.DATE)

	private String name;
//	private Date tgl;
//	private String instansi;
//	private String ktp;

	private Long upx;

	public CekPasienModel() {
		super();
	}

	public CekPasienModel(
			// Long id ,
			String name,
			// String alamat,
			// Date tgllahir,
			// Date tgl,
			// String instansi,
			// String ktp,
			Long upx) {

		super();
		// this.id = id;
		this.name = name;
		// this.alamat = alamat;
		// this.tgllahir = tgllahir;
		// this.tgl = tgl;
		// this.instansi = instansi;
		// this.ktp = ktp;
		this.upx = upx;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getUpx() {
		return upx;
	}

	public void setUpx(Long upx) {
		this.upx = upx;
	}

}
