package com.book.api.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="authorAddress")
public class AuthorAddress {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
private String street;
private String city;
@OneToOne(mappedBy="authorAddress")
@JsonBackReference
private Book book;

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getStreet() {
	return street;
}
public void setStreet(String street) {
	this.street = street;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public AuthorAddress(int id, String street, String city) {
	super();
	this.id = id;
	this.street = street;
	this.city = city;
}
public AuthorAddress(String street, String city) {
	super();
	this.street = street;
	this.city = city;
}

public AuthorAddress() {
	super();
}




}
