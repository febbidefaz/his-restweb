package com.dev.generik.models;

import java.io.Serializable;
//import java.util.Date;
//import java.util.List;
import java.util.UUID;

//import com.dev.generik.bpjs.entities.SurgeryBooking;

public class CekIdRmTglLahirModel implements Serializable {

	private static final long serialVersionUID = -2995485292687802706L;

	private UUID Idn;
//	private String Rm;
	//private Date Tgl;

//	private List<LoginDokterModel> list;

	public CekIdRmTglLahirModel() {
		super();
	}

	public UUID getIdn() {
		return Idn;
	}

	public void setIdn(UUID idn) {
		Idn = idn;
	}
	
/*	public String getRm() {
		return Rm;
	}

	public void setRm(String rm) {
		Rm = rm;
	}

	public Date getTgl() {
		return Tgl;
	}

	public void setTgl(Date tgl) {
		Tgl = tgl;
	} */


	/*
	 * public LoginDokModel(List<LoginDokterModel> list) { super(); this.list =
	 * list; }
	 * 
	 * public List<LoginDokterModel> getList() { return list; }
	 * 
	 * public void setList(List<LoginDokterModel> list) { this.list = list; }
	 */
}
