 package com.rotech.mvc.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rotech.mvc.models.Book;
import com.rotech.mvc.services.BookService;

@RestController
@RequestMapping("/api/books")
public class BooksApi {
	private final BookService bookService;
	
	public BooksApi(BookService bookService) {
		this.bookService = bookService;
	}
	@RequestMapping("")
	public List<Book> index() {
		return bookService.allBooks();
	}
	    
	@RequestMapping(value="", method=RequestMethod.POST)
	public Book create(@RequestParam(value="title") String title, @RequestParam(value="description") String desc, @RequestParam(value="language") String lang, @RequestParam(value="pages") Integer numOfPages) {
		Book book = new Book(title, desc, lang, numOfPages);
		return bookService.createBook(book);
	}
	    
	@RequestMapping("/{id}")
	public Book show(@PathVariable("id") Long id) {
		Book book = bookService.findBook(id);
		return book;
	}
	@RequestMapping(value="/{id}", method= RequestMethod.POST)
	public Book update( @PathVariable("id") Long id,@RequestParam("title") String title, @RequestParam("description") String desc, @RequestParam("language") String lang, @RequestParam("pages") Integer pages) {
		
		Book book =  new Book(id,title, desc,lang,pages);
				return bookService.update(book);
	}
	@RequestMapping("delete/{id}")
	public void delete(@PathVariable("id") Long id) {
		bookService.deleteById(id);
	}
}
