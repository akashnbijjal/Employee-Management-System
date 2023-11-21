package com.employee.timecard.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionInteceptor extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ErrorDetails> handleallException(Exception ex, WebRequest request) throws Exception {
		ErrorDetails details = new ErrorDetails(LocalDateTime.now(), request.getDescription(false), ex.getMessage());
		return new ResponseEntity<ErrorDetails>(details, HttpStatus.BAD_GATEWAY);
	}

	@ExceptionHandler(NomatchException.class)
	public final ResponseEntity<ErrorDetails> handleException(NomatchException ex, WebRequest request)
			throws NomatchException {
		ErrorDetails details = new ErrorDetails(LocalDateTime.now(), request.getDescription(false), ex.getMsg());
		return new ResponseEntity<ErrorDetails>(details, HttpStatus.BAD_GATEWAY);
	}
}
