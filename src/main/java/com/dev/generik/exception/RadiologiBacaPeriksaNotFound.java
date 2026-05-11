package com.dev.generik.exception;

public class RadiologiBacaPeriksaNotFound extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public RadiologiBacaPeriksaNotFound(Long idrad) {
		super("Could not find IDRadiologi " + idrad);
	}
}
