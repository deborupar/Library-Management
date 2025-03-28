package com.microservices.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.entity.BookDetailsDTO;
import com.microservices.entity.BookInventory;
import com.microservices.service.BookInvService;

@RestController
@RequestMapping("/bms")
public class BookInvManagementRestController {
	
	private BookInvService bookInvService;
	
	@Autowired
	BookInvManagementRestController(BookInvService bookInvService){
		this.bookInvService = bookInvService;
	}
	//get book inventory info 
	@GetMapping("/inv/{isbn}")
	BookDetailsDTO getBookInvDetailsByISBN(@PathVariable String isbn) {
		
		BookDetailsDTO bookDTO = bookInvService.getBookInventoryDetails(isbn);
		return bookDTO;
	}
	
	//add book to inv
	@PostMapping("/inv")
	ResponseEntity<String> addBookInvRecord(@RequestBody BookInventory bookInv) {
	    
		String message = bookInvService.addBookInvRecord(bookInv);
		return new ResponseEntity<String>(message,HttpStatus.OK);
	}
	
	//delete book from inv 
	@DeleteMapping("/inv/{isbn}")
	ResponseEntity<String> deleteBookInvByISBN(@PathVariable String isbn){
		String message = bookInvService.deleteBookInvByISBN(isbn);
		return new ResponseEntity<String>(message,HttpStatus.OK);
	}
	//update book count in inv 
	
	/* LOAN : this method is called internally from other rest services*/
	@PutMapping("/inv/loan/{isbn}")
	ResponseEntity<String> loanBook(@PathVariable String isbn){
		String message = bookInvService.loanBook(isbn);
		return new ResponseEntity<String>(message,HttpStatus.OK);
	}
	//RETURN 
	@PutMapping("/inv/return/{isbn}")
	ResponseEntity<String> returnBook(@PathVariable String isbn){
		String message = bookInvService.returnBook(isbn);
		return new ResponseEntity<String>(message,HttpStatus.OK);
	}
	
	

}
