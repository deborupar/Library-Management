package com.microservices.service;

import java.util.List;

import com.microservices.entity.Books;

public interface BookService {
	
	Books getBookById(int id);
	
	List<Books> getAllBooks();
	
	Books getBookByISBN(String isbn);
	
	Books getBookByTitle(String title);
	
	List<Books> getBookByAuthor(String author);
	
	List<Books> getBookByPublishedYear(int year);
	
	String createNewBookEntry(Books book);
	
	String updateBookTitle(int id , String title);
	
	String updateBookAuthor(int id , String author);
	
	String updateBookISBN(int id , String isbn);
	
	String updateBookSummary(int id , String summary);
	
	String deleteById(int id);
	
	String deleteByISBN(String isbn);
	

}
