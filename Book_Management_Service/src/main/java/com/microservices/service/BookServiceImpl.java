package com.microservices.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.dao.BooksRepository;
import com.microservices.entity.Books;

import jakarta.transaction.Transactional;

@Service
public class BookServiceImpl implements BookService {
	
	
	BooksRepository booksRepo;
	
	@Autowired
	BookServiceImpl(BooksRepository booksRepo){
		this.booksRepo = booksRepo;
				
	}
	@Override
	public Books getBookById(int id) {
		Optional<Books> result = booksRepo.findById(id);
		Books book = null;
		if(result.isPresent())
			book = result.get();
		return book;
	}

	@Override
	public List<Books> getAllBooks() {
		List<Books> listOfBooks = booksRepo.findAll();
		return listOfBooks;
	}

	@Override
	public Books getBookByISBN(String isbn) {
		return booksRepo.getBookByISBN(isbn);
		
	}

	@Override
	public Books getBookByTitle(String title) {
		return booksRepo.getBookByTitle(title);
	}

	@Override
	public List<Books> getBookByAuthor(String author) {
		return booksRepo.getBookByAuthor(author);
	}

	@Override
	public List<Books> getBookByPublishedYear(int year) {
		return booksRepo.getBookByPublishedYear(year);
	}
	@Override
	@Transactional
	public String createNewBookEntry(Books book) {
		try {
			booksRepo.save(book);
			return "Success";
		}
		catch(Exception e) {
			return "Failure";
			
		}
	}	

	@Override
	@Transactional
	public String deleteById(int id) {
		try {
			booksRepo.deleteById(id);
			return "Deletd record with id "+id;
		} catch (Exception e) {
			return "Failed to delete record with id "+id;

		}
	}
	
	@Override
	@Transactional
	public String deleteByISBN(String isbn) {
		try {
			booksRepo.deleteByISBN(isbn);
			return "Deletd record with isbn number "+isbn;
		}
		catch(Exception e) {
			return "Failed to delete record with isbn number "+isbn;
		}
	}
	@Override
	public String updateBookTitle(int id, String title) {
		try {
		Optional<Books> result = booksRepo.findById(id);
		if(result.isPresent()) {
			Books b = result.get();
			b.setTitle(title);
			booksRepo.save(b);
			return "Success";
		}
		else
			return "No book corresponding to the id "+id+" is found in the system";
		}
		catch(Exception e)
		{
			return "Failure";
		}
		
	}
	@Override
	public String updateBookAuthor(int id, String author) {
		try {
			Optional<Books> result = booksRepo.findById(id);
			if(result.isPresent()) {
				Books b = result.get();
				b.setAuthor(author);
				booksRepo.save(b);
				return "Success";
			}
			else
				return "No book corresponding to the id "+id+" is found in the system";
			}
			catch(Exception e)
			{
				return "Failure";
			}
	}
	@Override
	public String updateBookISBN(int id, String isbn) {
		try {
			Optional<Books> result = booksRepo.findById(id);
			if(result.isPresent()) {
				Books b = result.get();
				b.setISBN(isbn);
				booksRepo.save(b);
				return "Success";
			}
			else
				return "No book corresponding to the id "+id+" is found in the system";
			}
			catch(Exception e)
			{
				return "Failure";
			}
	}
	@Override
	public String updateBookSummary(int id, String summary) {
		try {
			Optional<Books> result = booksRepo.findById(id);
			if(result.isPresent()) {
				Books b = result.get();
				b.setSummary(summary);
				booksRepo.save(b);
				return "Success";
			}
			else
				return "No book corresponding to the id "+id+" is found in the system";
			}
			catch(Exception e)
			{
				return "Failure";
			}
	}

}
