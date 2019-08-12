package com.rotech.hellohuman.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloHuman {
	@RequestMapping("/")
	public String index(@RequestParam(value="name", required = false) String name) {
		System.out.println("what is goin on");
		if(name == null) {
			name = "Human";
		}
		return "hello "+name;
	}
}
