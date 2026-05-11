package com.dev.generik.models;

import java.io.Serializable;
//import java.util.List;

//import com.dev.generik.bpjs.entities.SurgeryBooking;

public class LoginDokModel implements Serializable {

	private static final long serialVersionUID = -2995485292687802706L;

	private String user;
	private String pass;

//	private List<LoginDokterModel> list;

	public LoginDokModel() {
		super();
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
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
