package com.dbs.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus()
public class QueueOverflowException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private final transient Logger log = LoggerFactory.getLogger(getClass());

	public QueueOverflowException() {
		super();
	}

	/**
	 * @param message return ContributeStoreException.
	 */
	public QueueOverflowException(String message) {
		super(message);
		log.info("QueueOverflowException");
	}

}
