package com.microservices.service;

import com.microservices.entity.BookDetailsDTO;
import com.microservices.entity.BookInventory;

public interface BookInvService {
	
	BookDetailsDTO getBookInventoryDetails(String isbn);
	
	int getBookQtyByISBN(String isbn);

	String addBookInvRecord(BookInventory bookInv);

	String deleteBookInvByISBN(String isbn);

	String loanBook(String isbn);

	String returnBook(String isbn);

}
