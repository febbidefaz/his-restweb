package com.dev.generik.exception;

public class ERMIGDObservasiNotFound extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ERMIGDObservasiNotFound(Long id) {
		super("Could not find Px ID " + id);
	}
}
