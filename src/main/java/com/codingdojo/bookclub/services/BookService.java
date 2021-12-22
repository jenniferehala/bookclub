package com.codingdojo.bookclub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.bookclub.models.Book;
import com.codingdojo.bookclub.repositories.BookRepository;

@Service
public class BookService {
	@Autowired
	private BookRepository bookRepo;
	
//	Find all
	
	public List<Book> allBooks() {
		return bookRepo.findAll();
	}
	
//	Create one
	
	public Book createBook(Book b) {
		return bookRepo.save(b);
		
	}
	
//	Find one
	
	public Book getBook(Long id) {
		Optional<Book> optionalbook =bookRepo.findById(id);
		if(optionalbook.isPresent()) {
			return optionalbook.get();
		} else {
			return null;
		}
	
//	Update one
	}
	
	public Book updateBook (Book book) {
	return bookRepo.save(book);
	}
	
	
//	public void deleteBook(Long id) {
//		bookRepo.deleteById(id);

}
