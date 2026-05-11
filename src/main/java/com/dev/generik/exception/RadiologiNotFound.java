package com.dev.generik.exception;

public class RadiologiNotFound extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public RadiologiNotFound(String periksa) {
		super("Could not find Nama " + periksa);
	}
}
