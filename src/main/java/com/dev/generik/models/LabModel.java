package com.dev.generik.models;

import java.io.Serializable;
import java.util.List;

//import com.dev.generik.bpjs.entities.SurgeryBooking;

public class LabModel implements Serializable {

	private static final long serialVersionUID = -2995485292687802706L;

	private List<LaboratModel> list;

	public LabModel() {
		super();
	}

	public LabModel(List<LaboratModel> list) {
		super();
		this.list = list;
	}

	public List<LaboratModel> getList() {
		return list;
	}

	public void setList(List<LaboratModel> list) {
		this.list = list;
	}

}
