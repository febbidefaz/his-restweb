package com.dev.generik.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

//import com.dev.generik.exception.PasienNotFoundException;

@ControllerAdvice
public class PxInapNotFoundAdvice {
	@ResponseBody
	@ExceptionHandler(PxInapNotFound.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String PxInapNotFoundHandler(PxInapNotFound ex) {
		return ex.getMessage();
	}
}