package com.book.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.book.api.entity.Book;
import com.book.api.helper.FileUploadHelper;
import com.book.api.service.BookService;

@RestController
public class BookController {
	
@Autowired
private BookService bookService;


@GetMapping("/home")
	public String test(){
	return "this is home page";
	}
//Featch Book By ID
@GetMapping("/books/{id}")
public ResponseEntity<Book> getBookById(@PathVariable("id") int id){
	Book book=bookService.getBookByID(id); 
	if(book==null) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	return ResponseEntity.of(Optional.of(book));
}
//Featch All Book
@GetMapping("/books")
public ResponseEntity<List<Book>> getAllBook(){
List<Book> list=bookService.getAllBook();
	if(list.size()<=0) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
return ResponseEntity.status(HttpStatus.CREATED).body(list);
}

//add operation
@PostMapping("/books")
public ResponseEntity<Book> saveBook(@RequestBody Book book) {
Book books=null;
try {
	books=bookService.addBook(book);
	return ResponseEntity.of(Optional.of(books));
}
catch(Exception e) {
	e.printStackTrace();
	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	
}
}

//Update Book
@PutMapping("/books/{id}")
public ResponseEntity updateBook(@RequestBody Book book, @PathVariable("id") int id) {
try {
	bookService.bookUpdate(book, id);
	return ResponseEntity.ok(book);
}
catch(Exception e) {
	e.printStackTrace();
	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	
}
	
}

//Delete Book
@DeleteMapping("/books/{id}")
public ResponseEntity<Void> deleteBooks(@PathVariable("id") int id) {
	try{
		bookService.deleteBook(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	catch(Exception e) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}

	
}
@DeleteMapping("/books")
public String DeleteAllBooks() {
	bookService.deleteAllBook();
	return "All books are Deleted";
}


}
