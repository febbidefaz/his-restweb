package com.dev.generik.exception;

public class DisplayInapNotFound extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DisplayInapNotFound(String user) {
		super("Could not find User " + user);
	}
}
