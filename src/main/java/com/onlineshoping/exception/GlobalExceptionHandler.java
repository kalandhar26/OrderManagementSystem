package com.onlineshoping.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	// handle Standard exceptions

	@ExceptionHandler
	public ResponseEntity<?> handleOrderNotFoundException(OrderNotFoundException exception, WebRequest request) {

		ExceptionDetails exceptionDetails = new ExceptionDetails(new Date(), exception.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<Object>(exceptionDetails, HttpStatus.NOT_FOUND);
	}

	// handle Global exceptions

	@ExceptionHandler
	public ResponseEntity<?> handleGlobalException(Exception exception, WebRequest request) {

		ExceptionDetails exceptionDetails = new ExceptionDetails(new Date(), exception.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<Object>(exceptionDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
