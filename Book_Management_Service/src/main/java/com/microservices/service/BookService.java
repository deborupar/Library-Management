package com.microservices.service;

import java.util.List;

import com.microservices.entity.Books;

public interface BookService {
	
	Books getBookById(long id);
	
	List<Books> getAllBooks();
	
	Books getBookByISBN(String isbn);
	
	Books getBookByTitle(String title);
	
	List<Books> getBookByAuthor(String author);
	
	List<Books> getBookByPublishedYear(int year);
	
	String createNewBookEntry(Books book);
	
	String updateBookTitle(long id , String title);
	
	String updateBookAuthor(long id , String author);
	
	String updateBookISBN(long id , String isbn);
	
	String updateBookSummary(long id , String summary);
	
	String deleteById(long id);
	
	String deleteByISBN(String isbn);
	

}
