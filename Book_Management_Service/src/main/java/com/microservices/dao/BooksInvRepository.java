package com.microservices.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.microservices.entity.BookDetailsDTO;
import com.microservices.entity.BookInventory;

@Repository
public interface BooksInvRepository extends JpaRepository<BookInventory, Long> {
	
	@Query("SELECT new com.microservices.entity.BookDetailsDTO(bi.ISBN, b.title, b.author, b.publisher, b.edition, bi.QTY) " +
		       "FROM Books b JOIN BookInventory bi ON b.ISBN = bi.ISBN " +
		       "WHERE bi.ISBN = :ISBN")
	BookDetailsDTO getBookDetailedInfo(@Param("ISBN") String ISBN);
	
	@Query(" SELECT bi FROM BookInventory bi WHERE ISBN = :ISBN ")
	BookInventory getInvRecordByISBN(@Param("ISBN") String ISBN);
	
	@Modifying
	@Query("DELETE FROM BookInventory bi WHERE bi.ISBN = :ISBN")
	void deleteBookRecord(@Param("ISBN") String ISBN);

	@Modifying
	//@Query("UPDATE TABLE BookInventory bi SET bi.QTY= bi.QTY -1 WHERE bi.ISBN = :ISBN")
	@Query("UPDATE BookInventory SET QTY= QTY - 1 WHERE ISBN = :ISBN")
	void loanBook(@Param("ISBN") String ISBN);
	
	@Modifying
	@Query("UPDATE BookInventory SET QTY= QTY +1 WHERE ISBN = :ISBN")
	void returnBook(@Param("ISBN") String ISBN);
	
	

}
