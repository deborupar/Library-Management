package com.microservices.entity;

public class BookDetailsDTO {
	
	private String ISBN;
	private String title;
	private String author;
	private String publisher;
	private String edition;
	private int qty;

	public BookDetailsDTO(String ISBN, String title, String author, String publisher, String edition, int qty) {
		this.ISBN = ISBN;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.edition = edition;
		this.qty = qty;
	}

	@Override
	public String toString() {
		return "BookDetailsDTO [ISBN=" + ISBN + ", title=" + title + ", author=" + author + ", publisher=" + publisher
				+ ", edition=" + edition + ", quantity=" + qty + "]";
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}
	
}
