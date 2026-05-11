package com.dev.generik.models;

import java.io.Serializable;
//import java.util.Date;
import java.util.Date;

public class HasilPCRWSModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3121922636150247051L;
	private Long id;
	private String rm;
	private Date tgl;
	private String pcr;

	public HasilPCRWSModel() {
		super();
	}

	public HasilPCRWSModel(Long id, String rm, Date tgl, String pcr) {

		super();
		this.id = id;
		this.rm = rm;
		this.tgl = tgl;
		this.pcr = pcr;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRm() {
		return rm;
	}

	public void setRm(String rm) {
		this.rm = rm;
	}

	public Date getTgl() {
		return tgl;
	}

	public void setTgl(Date tgl) {
		this.tgl = tgl;
	}

	public String getPcr() {
		return pcr;
	}

	public void setPcr(String pcr) {
		this.pcr = pcr;
	}

}
