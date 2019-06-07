package com.nettrack.user.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.nettrack.user.exception.CustomAPIResponse;
import com.nettrack.user.exception.RecordNotFoundException;

@ControllerAdvice
public class CustomizedExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<?> handleNullPointer(Exception exception, WebRequest request) {

		return new ResponseEntity(new CustomAPIResponse("E0001", exception.getMessage()),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<?> handleIllegalArgumentException(Exception exception, WebRequest request) {

		return new ResponseEntity(new CustomAPIResponse("E0001", exception.getMessage()),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(ArrayIndexOutOfBoundsException.class)
	public ResponseEntity<?> handleArrayIndexOutOfBoundException(Exception exception, WebRequest request) {
		System.out.println(exception.getMessage());
		return new ResponseEntity(new CustomAPIResponse("E0001", exception.getMessage()),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(RecordNotFoundException.class)
	public final ResponseEntity<?> handleUserNotFoundException(RecordNotFoundException ex, WebRequest request) {
		CustomAPIResponse error = new CustomAPIResponse("E0001", ex.getLocalizedMessage());
		return new ResponseEntity(error, HttpStatus.NOT_FOUND);
	}

}
