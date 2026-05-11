package com.dev.generik.exception;

import org.springframework.http.HttpStatus;

public class CustomExceptionS extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private Integer code;
	private String msg;
	private HttpStatus httpStatus;

	public CustomExceptionS() {
		super();
	}

	public CustomExceptionS(Integer code, String msg, HttpStatus httpStatus) {
		super();
		this.code = code;
		this.msg = msg;
		this.httpStatus = httpStatus;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

}
