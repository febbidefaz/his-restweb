package com.dev.generik.exception;

public class PasienNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public PasienNotFoundException(String id) {
		super("Could not find CardNo " + id);
	}
}
