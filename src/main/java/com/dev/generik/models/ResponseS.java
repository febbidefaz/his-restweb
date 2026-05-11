package com.dev.generik.models;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class ResponseS implements Serializable {

	private static final long serialVersionUID = -1134265404278707904L;

	private String response;
	//private Integer code;

	public ResponseS() {
		super();
	}




}
