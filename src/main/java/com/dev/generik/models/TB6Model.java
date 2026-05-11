package com.dev.generik.models;

import java.io.Serializable;
import java.util.List;


//import com.dev.generik.bpjs.entities.SurgeryBooking;

public class TB6Model implements Serializable {

	private static final long serialVersionUID = -2995485292687802706L;

	private List<TB06Model> list;

	public TB6Model() {
		super();
	}

	public TB6Model(List<TB06Model> list) {
		super();
		this.list = list;
	}

	public List<TB06Model> getList() {
		return list;
	}

	public void setList(List<TB06Model> list) {
		this.list = list;
	}

}
