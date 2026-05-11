package com.dev.generik.exception;

public class RiwayatRegNotFound extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public RiwayatRegNotFound(Long id) {
		super("Could not find Riwayat Pendaftararan ID " + id);
	}
}
