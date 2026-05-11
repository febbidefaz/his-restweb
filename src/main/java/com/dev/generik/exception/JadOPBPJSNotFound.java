package com.dev.generik.exception;

public class JadOPBPJSNotFound extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public JadOPBPJSNotFound(Long id) {
		super("Could not find Jadwal Operasi ID " + id);
	}
}
