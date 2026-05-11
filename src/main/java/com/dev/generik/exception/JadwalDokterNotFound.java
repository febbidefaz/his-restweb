package com.dev.generik.exception;

public class JadwalDokterNotFound extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public JadwalDokterNotFound(Long id) {
		super("Could not find Dokter ID " + id);
	}
}
