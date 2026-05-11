package com.dev.generik.exception;

public class BedReadyNotFound extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public BedReadyNotFound(Long id) {
		super("Could not find Bed ID " + id);
	}
}
