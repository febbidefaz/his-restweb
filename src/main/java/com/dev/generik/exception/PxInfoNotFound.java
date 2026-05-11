package com.dev.generik.exception;

public class PxInfoNotFound extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public PxInfoNotFound(Long id) {
		super("Could not find CardNo " + id);
	}
}
