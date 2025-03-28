package com.microservices.error.handling;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(BookNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleBookNotFoundException(BookNotFoundException exc){
		ErrorResponse errResp = new ErrorResponse("BOOK NOT FOUND", exc.getMessage());
		return new ResponseEntity<ErrorResponse>(errResp, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(HttpMediaTypeNotAcceptableException.class)
    public ResponseEntity<ErrorResponse> handleHttpMediaTypeNotAcceptableException(HttpMediaTypeNotAcceptableException ex) {
        ErrorResponse errorResponse = new ErrorResponse("MEDIA_TYPE_NOT_ACCEPTABLE", "The requested media type is not supported.");
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_ACCEPTABLE);
    }
	
	@ExceptionHandler(BookInventoryRecordsNotFound.class)
	public ResponseEntity<ErrorResponse> handleBookInvRecordNotFound(BookInventoryRecordsNotFound exc){
		ErrorResponse errorResponse = new ErrorResponse("BOOK INVENTORY RECORD NOT FOUND", exc.getMessage());
		return new ResponseEntity<ErrorResponse>(errorResponse , HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleGenericException(Exception exc){
		ErrorResponse errorResponse = new ErrorResponse("ENCOUNTERED EXCEPTION", exc.getMessage());
		return new ResponseEntity<ErrorResponse>(errorResponse , HttpStatus.BAD_REQUEST);
	}

}
