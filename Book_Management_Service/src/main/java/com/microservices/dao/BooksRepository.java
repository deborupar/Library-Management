package com.microservices.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.microservices.entity.Books;

@Repository
public interface BooksRepository extends JpaRepository<Books, Integer> {
	
    
	@Query("SELECT b FROM Books b WHERE b.ISBN = :isbn")
	Books getBookByISBN(@Param("isbn") String isbn);
	
	@Query("SELECT b FROM Books b WHERE b.title like %:title%")
	Books getBookByTitle(@Param("title") String title);
	
	@Query("SELECT b from Books b where b.author like %:author%")
	List<Books> getBookByAuthor(@Param("author") String author);
	
	@Query("SELECT b FROM Books b WHERE b.pub_year = :year")
	List<Books> getBookByPublishedYear(@Param("year") int year);
	
	@Query("DELETE FROM Books b where b.ISBN = :isbn")
	void deleteByISBN(@Param("isnb") String isbn);
	
}
