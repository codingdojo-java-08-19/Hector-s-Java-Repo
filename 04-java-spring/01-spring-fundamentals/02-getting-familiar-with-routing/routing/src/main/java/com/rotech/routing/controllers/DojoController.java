package com.rotech.routing.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class DojoController {
	@RequestMapping("/{param}")
	public String index(@PathVariable("param") String param) {
		if(param.equals("dojo")) {
			System.out.println("R"+ param +"L");
			return "the dojo is awsome";
		}else if(param.equals("burbank-dojo")) {
			return "Burbank Dojo is located in southern California";
		}
//		System.out.println("R"+ param +"L");
		return "hello";
	}

}
