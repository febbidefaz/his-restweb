package com.dev.generik.models;

import java.io.Serializable;

public class Metadata implements Serializable {

	private static final long serialVersionUID = -1134265404278707904L;

	private String message;
	private Integer code;

	public Metadata() {
		super();
	}

	public Metadata(Integer code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
