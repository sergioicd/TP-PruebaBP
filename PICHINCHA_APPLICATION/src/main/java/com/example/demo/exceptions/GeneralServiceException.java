package com.example.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
public class GeneralServiceException extends RuntimeException {

	private static final long serialVersionUID = -2538444334924708113L;

	public GeneralServiceException() {
		super();
	}

	public GeneralServiceException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public GeneralServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public GeneralServiceException(String message) {
		super(message);
	}

	public GeneralServiceException(Throwable cause) {
		super(cause);
	}

	
}
