package com.dev.generik.models;

import java.io.Serializable;
import java.util.List;

//import com.dev.generik.bpjs.entities.SurgeryBooking;

public class CekPxModel implements Serializable {

	private static final long serialVersionUID = -2995485292687802706L;

	private List<CekPasienModel> list;

	public CekPxModel() {
		super();
	}

	public CekPxModel(List<CekPasienModel> list) {
		super();
		this.list = list;
	}

	public List<CekPasienModel> getList() {
		return list;
	}

	public void setList(List<CekPasienModel> list) {
		this.list = list;
	}

}
