package com.microservices.error.handling;

public class BookInventoryRecordsNotFound extends RuntimeException {
	
	public BookInventoryRecordsNotFound(String message){
		super(message);
	}

}
