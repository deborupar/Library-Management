package com.microservices.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.dao.BooksInvRepository;
import com.microservices.dao.BooksRepository;
import com.microservices.entity.BookDetailsDTO;
import com.microservices.entity.BookInventory;
import com.microservices.entity.Books;
import com.microservices.error.handling.BookInventoryRecordsNotFound;
import com.microservices.error.handling.BookNotFoundException;

import jakarta.transaction.Transactional;

@Service
public class BookInvServiceImpl implements BookInvService {

	private BooksInvRepository bookInvRepo;
	private BooksRepository bookRepo;
	
	@Autowired
	BookInvServiceImpl(BooksInvRepository bookInvRepo, BooksRepository bookRepo){
		this.bookInvRepo = bookInvRepo;
		this.bookRepo = bookRepo;
	}
	
	@Override
	public BookDetailsDTO getBookInventoryDetails(String isbn) {
		BookDetailsDTO book = bookInvRepo.getBookDetailedInfo(isbn);
		if(book == null)
			throw new BookNotFoundException("No book record found with ISBN number "+isbn);
		return book;
	}

	
	@Override
	@Transactional
	public String addBookInvRecord(BookInventory bookInv) {
		// check if book exists in BMS_BOOK_INFO table 
		Books book = bookRepo.getBookByISBN(bookInv.getISBN());
		// if not send error message informing to add book details 
		if( book ==  null)
			throw new BookNotFoundException("No book found in the system with the given ISBN code. Add book info into system before entering book inventory details");
		else
		{
			try {
				BookInventory b = bookInvRepo.save(bookInv);
				if(b != null)
					return "Inventory details added successfuly";
				else
					return "Error while adding inventory deatils";
			}
			catch(Exception e) {
				return "Error while adding inventory deatils";
			}
		}
		
	}
	
	@Override
	@Transactional
	public String deleteBookInvByISBN(String isbn) {
		try {
		if(bookRepo.getBookByISBN(isbn)!=null)
		{
				if(bookInvRepo.getInvRecordByISBN(isbn)!=null)
				{
					bookInvRepo.deleteBookRecord(isbn);
					return "Book inventory records deleted successfully";
				}
				else
					throw new BookInventoryRecordsNotFound("No inventory record found for the book with ISBN number "+isbn);
		}
		else
			throw new BookNotFoundException("No book record found for book with ISBN number "+isbn);
			
		}
		catch(Exception e) {
			return e.getMessage();
		}
	}

	@Override
	@Transactional
	public String loanBook(String isbn) {
		try {
			bookInvRepo.loanBook(isbn);
			return "Book "+isbn+" loaned successfully. Quantity updated";
			
		}
		catch(Exception e) {
			return e.getMessage();
		}
	}

	@Override
	public int getBookQtyByISBN(String isbn) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	@Transactional
	public String returnBook(String isbn) {
		try {
			bookInvRepo.returnBook(isbn);
			return "Book "+isbn+" returned successfully. Quantity updated";		
		}
		catch(Exception e) {
			return e.getMessage();
		}
	}
	

}
