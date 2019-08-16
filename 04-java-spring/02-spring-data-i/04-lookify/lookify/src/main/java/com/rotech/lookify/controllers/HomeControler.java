package com.rotech.lookify.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeControler {
	@GetMapping("/")
	public String redirect() {
		return "redirect:/lookify";
	}
}
