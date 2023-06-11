package com.book.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.book.api.controller.BookController;
import com.book.api.dao.BookRepository;
import com.book.api.service.BookService;

@SpringBootApplication
public class BookRestApiWithJpaApplication {
	public static void main(String[] args) {
		SpringApplication.run(BookRestApiWithJpaApplication.class, args);

	}

}
