package com.dev.generik.exception;

public class BeritaNotFound extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public BeritaNotFound(Long id) {
		super("Could not find Berita ID " + id);
	}
}
