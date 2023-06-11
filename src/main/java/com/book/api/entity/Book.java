package com.book.api.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Book {
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	private int id;
	private String Title;
	private String Author;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JsonManagedReference
	private AuthorAddress authorAddress;
	
	public AuthorAddress getAuthorAddress() {
		return this.authorAddress;
	}
	
	public void setAuthorAddress(AuthorAddress authorAddress) {
		this.authorAddress=authorAddress;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getAuthor() {
		return Author;
	}
	public void setAuthor(String author) {
		Author = author;
	}

	public Book(int id, String title, String author, AuthorAddress authorAddress) {
		super();
		this.id = id;
		Title = title;
		Author = author;
		this.authorAddress = authorAddress;
	}

	public Book(String title, String author, AuthorAddress authorAddress) {
		super();
		Title = title;
		Author = author;
		this.authorAddress = authorAddress;
	}

	public Book() {
		super();
	}
	
	
	

}
