package com.dev.generik.exception;

public class JadwalOperasiNotFound extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public JadwalOperasiNotFound(Long id) {
		super("Could not find Jadwal Operasi ID " + id);
	}
}
