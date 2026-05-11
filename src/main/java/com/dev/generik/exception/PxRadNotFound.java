package com.dev.generik.exception;

public class PxRadNotFound extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public PxRadNotFound(String id) {
		super("Could not find Px ID " + id);
	}
}
