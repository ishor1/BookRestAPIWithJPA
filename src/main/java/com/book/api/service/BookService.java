package com.book.api.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.book.api.dao.BookRepository;
import com.book.api.entity.Book;

@Component
public class BookService {
	@Autowired
	private BookRepository bookRepository;

	// add methond
	public Book addBook(Book b) {
		return bookRepository.save(b);
	}

	// read by id
	public Book getBookByID(int id) {
	Book book=null;
		try {
		return bookRepository.findById(id);
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	return book;
	}

	// Read all
	public List<Book> getAllBook(){
		List<Book> book=(List<Book>) bookRepository.findAll();
	return book;
	}
	

	//update
	public Book bookUpdate(Book book, int id) {
		book.setId(id);
		return bookRepository.save(book);
	}
	
	
//	delete Book By ID
	public Book deleteBook(int id) {
		Book book=bookRepository.findById(id);
		bookRepository.deleteById(id);
		return book;
	}
	
	//Delete All Book
	public void deleteAllBook() {
		bookRepository.deleteAll();
	}
	
	
}
