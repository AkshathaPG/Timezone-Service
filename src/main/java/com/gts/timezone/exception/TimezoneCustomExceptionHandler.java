package com.gts.timezone.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.gts.timezone.util.MethodUtils;

@ControllerAdvice
public class TimezoneCustomExceptionHandler {
	
	@ExceptionHandler(value=ApplicationException.class)
	public ResponseEntity<String> applicationException(ApplicationException exception){
		HttpStatus status=HttpStatus.BAD_REQUEST;
		return new ResponseEntity<>(MethodUtils.prepareErrorJSON(status,exception),status);
	}
	
	@ExceptionHandler(value=GtsTimezoneNotFoundException.class)
	public ResponseEntity<String> skillNotFoundException(GtsTimezoneNotFoundException exception){
		HttpStatus status=HttpStatus.NOT_FOUND;
		return new ResponseEntity<>(MethodUtils.prepareErrorJSON(status,exception),status);
	}
	
	@ExceptionHandler(value=DuplicationException.class)
	public ResponseEntity<String> duplicationException(DuplicationException exception){
		HttpStatus status=HttpStatus.FORBIDDEN;
		return new ResponseEntity<>(MethodUtils.prepareErrorJSON(status,exception),status);
	}
	
}
