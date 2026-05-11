package com.dev.generik.models;

import java.io.Serializable;
import java.util.Date;
//import java.util.List;

//import com.dev.generik.bpjs.entities.SurgeryBooking;

public class CekRMTglLahirModel implements Serializable {

	private static final long serialVersionUID = -2995485292687802706L;

	private String Patientid;
	private Date Date ;

//	private List<LoginDokterModel> list;

	public CekRMTglLahirModel() {
		super();
	}

	public String getPatientid() {
		return Patientid;
	}

	public void setPatientid(String patientid) {
		Patientid = patientid;
	}

	public Date getDate() {
		return Date;
	}

	public void setDate(Date date) {
		Date = date;
	}


	/*
	 * public LoginDokModel(List<LoginDokterModel> list) { super(); this.list =
	 * list; }
	 * 
	 * public List<LoginDokterModel> getList() { return list; }
	 * 
	 * public void setList(List<LoginDokterModel> list) { this.list = list; }
	 */
}
