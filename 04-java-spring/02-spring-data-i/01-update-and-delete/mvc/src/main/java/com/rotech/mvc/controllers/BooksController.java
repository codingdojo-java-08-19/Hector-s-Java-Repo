package com.rotech.mvc.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rotech.mvc.models.Book;
import com.rotech.mvc.services.BookService;

@Controller
@RequestMapping("/books")
public class BooksController {
 private final BookService bookService;
 
 public BooksController(BookService bookService) {
     this.bookService = bookService;
 }
 
 @RequestMapping("")
 public String index(Model model) {
     List<Book> books = bookService.allBooks();
     model.addAttribute("books", books);
     return "/books/index.jsp";
 }
 @RequestMapping("/new")
 public String newBook(@ModelAttribute("book") Book book) {
     return "/books/new.jsp";
 }
 @RequestMapping(value="", method=RequestMethod.POST)
 public String create(@Valid @ModelAttribute("book") Book book, BindingResult result) {
     if (result.hasErrors()) {
         return "/books/new.jsp";
     } else {
         bookService.createBook(book);
         return "redirect:/books";
     }
 }
 @RequestMapping("/{id}")
 public String show(@PathVariable("id") Long id, Model model) {
	 	Book book = bookService.findBook(id);
	 	model.addAttribute("book", book);
	 return "/books/show.jsp";
 }
 
 
}