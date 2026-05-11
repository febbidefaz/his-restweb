package com.dev.generik.models;

import java.io.Serializable;
import java.util.List;

//import com.dev.generik.bpjs.entities.SurgeryBooking;

public class PCRExtModel implements Serializable {

	private static final long serialVersionUID = -2995485292687802706L;

	private List<PCRExternalModel> list;

	public PCRExtModel() {
		super();
	}

	public PCRExtModel(List<PCRExternalModel> list) {
		super();
		this.list = list;
	}

	public List<PCRExternalModel> getList() {
		return list;
	}

	public void setList(List<PCRExternalModel> list) {
		this.list = list;
	}

}
