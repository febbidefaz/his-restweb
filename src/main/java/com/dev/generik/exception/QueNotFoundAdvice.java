package com.dev.generik.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class QueNotFoundAdvice {
	@ResponseBody
	@ExceptionHandler(QueNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String queNotFoundHandler(QueNotFoundException ex) {
		return ex.getMessage();
	}
}