package com.microservices.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="BMS_BOOK_INV")
public class BookInventory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="INV_ID")
	private Long INV_ID;
	
	@Column(name="ISBN")
	private String ISBN;
	
	@Column(name="QTY")
	private int QTY;

	public Long getINV_ID() {
		return INV_ID;
	}

	public void setINV_ID(Long iNV_ID) {
		INV_ID = iNV_ID;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public int getQTY() {
		return QTY;
	}

	public void setQTY(int qTY) {
		QTY = qTY;
	}
	
}
