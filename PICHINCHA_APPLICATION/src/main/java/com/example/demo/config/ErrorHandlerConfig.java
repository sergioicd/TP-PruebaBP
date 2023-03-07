package com.example.demo.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.demo.exceptions.GeneralServiceException;
import com.example.demo.exceptions.NoDataFoundException;
import com.example.demo.exceptions.ValidateServiceException;
import com.example.demo.utils.WrapperResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class ErrorHandlerConfig extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> all(Exception e, WebRequest request){
		log.error(e.getLocalizedMessage(), e);
		WrapperResponse<?> response = new WrapperResponse("Internal server error", null);
		return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(ValidateServiceException.class)
	public ResponseEntity<?> validateServiceException(ValidateServiceException e, WebRequest request){
		log.info(e.getLocalizedMessage(), e);
		WrapperResponse<?> response = new WrapperResponse(e.getMessage(), null);
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NoDataFoundException.class)
	public ResponseEntity<?> noDataFoundException(NoDataFoundException e, WebRequest request){
		log.info(e.getLocalizedMessage(), e);
		WrapperResponse<?> response = new WrapperResponse(e.getMessage(), null);
		return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
	}
	
	@ExceptionHandler(GeneralServiceException.class)
	public ResponseEntity<?> generalServiceException(GeneralServiceException e, WebRequest request){
		log.error(e.getLocalizedMessage(), e);
		WrapperResponse<?> response = new WrapperResponse("Internal server error", null);
		return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
