package com.dev.generik.exception;

public class PxInapNotFound extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public PxInapNotFound(Long id) {
		super("Could not find Px ID " + id);
	}
}
