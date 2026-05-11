package com.dev.generik.models;

import java.io.Serializable;
//import java.util.Date;

/*import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.OptBoolean;
import com.fasterxml.jackson.annotation.JsonFormat.Shape; */

public class PCRExternalRekananModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3121922636150247050L;
	private Long id;
//	private String username;
//	private String password;
//	@JsonFormat(shape=Shape.STRING,  pattern="dd-MM-yyyy", lenient=OptBoolean.FALSE)
//	@Temporal(TemporalType.DATE)

//	private Date tgllahir;
//	private Date tgl;
//	private String instansi;
//	private String ktp;

//	private String hasil;

	public PCRExternalRekananModel() {
		super();
	}

	public PCRExternalRekananModel(Long id// ,
	// String username,
	// String password
	// Date tgllahir,
	// Date tgl,
	// String instansi,
	// String ktp,
	// String hasil
	) {

		super();
		this.id = id;
		// this.username = username;
		// this.password = password;
		// this.alamat = alamat;
		// this.tgllahir = tgllahir;
		// this.tgl = tgl;
		// this.instansi = instansi;
		// this.ktp = ktp;
		// this.hasil = hasil;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/*
	 * public String getUsername() { return username; }
	 * 
	 * public void setUsername(String username) { this.username = username; }
	 * 
	 * public String getPassword() { return password; }
	 * 
	 * public void setPassword(String password) { this.password = password; }
	 */

}
