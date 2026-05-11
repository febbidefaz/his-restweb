package com.dev.generik.exception;

public class QueNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public QueNotFoundException(String id) {
		super("Could not find Que by dokter " + id);
	}
}
