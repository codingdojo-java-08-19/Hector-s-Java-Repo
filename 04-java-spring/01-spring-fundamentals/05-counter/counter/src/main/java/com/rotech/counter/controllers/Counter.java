package com.rotech.counter.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller	
public class Counter {
	
	@RequestMapping("/counter")
	public String index(Model model, HttpSession session) {
		Integer count = (Integer) session.getAttribute("counter");
		model.addAttribute("count", count);
		return "counter.jsp";
	}
}
