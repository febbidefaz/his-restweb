package com.dev.generik.models;

import java.io.Serializable;
import java.util.List;

//import com.dev.generik.bpjs.entities.SurgeryBooking;

public class HasPCRWSModel implements Serializable {

	private static final long serialVersionUID = -2995485292687802706L;

	private List<HasilPCRWSModel> list;

	public HasPCRWSModel() {
		super();
	}

	public HasPCRWSModel(List<HasilPCRWSModel> list) {
		super();
		this.list = list;
	}

	public List<HasilPCRWSModel> getList() {
		return list;
	}

	public void setList(List<HasilPCRWSModel> list) {
		this.list = list;
	}

}
