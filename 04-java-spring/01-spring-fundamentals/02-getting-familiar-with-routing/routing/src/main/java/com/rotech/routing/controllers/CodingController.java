package com.rotech.routing.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/coding")
public class CodingController {
	@RequestMapping("")
	public String index() {
		System.out.println("hello from index");
		return "Hello Coding Dojo!";
	}
	
	@RequestMapping("/python")
	public String python() {
		System.out.println("hello from python");
		return "Python/Django was awesome";
	}
	@RequestMapping("/java")
	public String java() {
		return "Java/ Spring is beter";
	}

}
