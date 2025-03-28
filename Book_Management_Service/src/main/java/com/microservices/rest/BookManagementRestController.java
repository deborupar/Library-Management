package com.microservices.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.entity.Books;
import com.microservices.service.BookService;

@RestController
@RequestMapping("/bms")
public class BookManagementRestController {
	
	BookService bookService;
	
	@Autowired
	BookManagementRestController(BookService bookService){
		this.bookService = bookService;
	}
	
	
	@GetMapping("/books/{id}")
	public Books getBookById(@PathVariable long id) {
		return bookService.getBookById(id);
	}
	
	@GetMapping("/books")
	public List<Books> getAllBooks() {
		return bookService.getAllBooks();
	}
	
	@GetMapping("/books/isbn/{isbn}")
	public Books getBookByISBN(@PathVariable String isbn) {
		return bookService.getBookByISBN(isbn);
		
	}
	
	@GetMapping("/books/title/{title}")
	public Books getBookByTitle(@PathVariable String title) {
		return bookService.getBookByTitle(title);
		
	}
	
	
	@GetMapping("/books/author/{author}")
	public List<Books> getBookByAuthor(@PathVariable String author) {
		return bookService.getBookByAuthor(author);
		
	}
	
	@GetMapping("/books/pubyear/{pubyear}")
	public List<Books> getBookByPublishedYear(@PathVariable int pubyear) {
		return bookService.getBookByPublishedYear(pubyear);
		
	}
	
	@PostMapping("/books")
	public String addNewBook(@RequestBody Books book) {
		return bookService.createNewBookEntry(book);
	}
	
	@PostMapping("/books/update/title")
	public String updateBookTitle(@RequestBody Map<String, String> request) {
		return bookService.updateBookTitle(Long.parseLong(request.get("id")) , request.get("title"));
	}
	@PostMapping("/books/update/author")
	public String updateBookAuthor(@RequestBody Map<String, String> request) {
		return bookService.updateBookAuthor(Long.parseLong(request.get("id")) , request.get("author"));
	}
	@PostMapping("/books/update/isbn")
	public String updateBookISBN(@RequestBody Map<String, String> request) {
		return bookService.updateBookISBN(Long.parseLong(request.get("id")) , request.get("isbn"));
	}
	@PostMapping("/books/update/summary")
	public String updateBookSummary(@RequestBody Map<String, String> request) {
		return bookService.updateBookSummary(Long.parseLong(request.get("id")) , request.get("summary"));
	}
	
	@DeleteMapping("/books/{id}")
	public String deleteById(@PathVariable long id) {
		return bookService.deleteById(id);
	}
	
	@DeleteMapping("/books/isbn/{isbn}")
	public String deleteByISBN(@PathVariable String isbn) {
		return bookService.deleteByISBN(isbn);
	}
	
	


}
