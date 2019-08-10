package com.dbs.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.dbs.exception.QueueOverflowException;
import com.dbs.model.ErrorResponse;


@ControllerAdvice
public class DBSBaseException extends ResponseEntityExceptionHandler {

	private final Logger log = LoggerFactory.getLogger(getClass());

	/**
	 * @param ex
	 * @return ResponseEntity it contains error object and error code. handle all
	 *         global exceptions.
	 */
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ErrorResponse> handleAllExceptions(Exception ex) {
		log.info("Start of handleAllExceptions method : GlobalException ");
		ErrorResponse error = new ErrorResponse();
		error.setErrorcode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		error.setErrorMessage(ex.getMessage());
		log.info("End of handleAllExceptions method : GlobalException");
		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	/**
	 * @param ex
	 * @return ResponseEntity it contains error object and error code. handle the
	 *         custom exceptions QueueOverflowException
	 */
	@ExceptionHandler(QueueOverflowException.class)
	public final ResponseEntity<ErrorResponse> handleUserNotFoundException(QueueOverflowException ex) {
		log.info("Start Of QueueOverflowException ");
		ErrorResponse error = new ErrorResponse();
		error.setErrorcode(HttpStatus.INSUFFICIENT_STORAGE.value());
		error.setErrorMessage(ex.getMessage());
		log.info("End of QueueOverflowException");
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

}
