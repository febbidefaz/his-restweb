package com.dev.generik.models;

import java.io.Serializable;
import java.util.List;

//import com.dev.generik.bpjs.entities.SurgeryBooking;

public class PCRExtRekModel implements Serializable {

	private static final long serialVersionUID = -2995485292687802706L;

	private List<PCRExternalRekananModel> list;

	public PCRExtRekModel() {
		super();
	}

	public PCRExtRekModel(List<PCRExternalRekananModel> list) {
		super();
		this.list = list;
	}

	public List<PCRExternalRekananModel> getList() {
		return list;
	}

	public void setList(List<PCRExternalRekananModel> list) {
		this.list = list;
	}

}
