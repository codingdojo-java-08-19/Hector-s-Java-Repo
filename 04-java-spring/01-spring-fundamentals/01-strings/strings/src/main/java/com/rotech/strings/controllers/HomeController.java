package com.rotech.strings.controllers;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class HomeController {
	@RequestMapping("/")
	public String index() {
		return "HELLO CLIENT. WHAT IS YOUR STATUS?";
	}
	@RequestMapping("/random")
	public String random() {
		return "HELLO CLIENT IN REPLAY. I MADE A REQUEST TO THE FUTURE ON THE OTHER PAGE THAT YOUR STATUS MIGHT IMPROVE. HAS IT?";
	}

}
