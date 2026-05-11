package com.dev.generik.exception;

public class BedReadyBPJSNotFound extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public BedReadyBPJSNotFound(Long id) {
		super("Could not find Bed ID " + id);
	}
}
