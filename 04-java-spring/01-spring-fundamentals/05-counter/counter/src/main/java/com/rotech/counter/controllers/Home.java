package com.rotech.counter.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Home {

	@RequestMapping("/")
	public String index(HttpSession session) {
		if(session.getAttribute("counter") == null) {
			session.setAttribute("counter", 0);
		}
		Integer counter = (Integer) session.getAttribute("counter");
		System.out.println(counter);
		session.setAttribute("counter", counter+1);
		return "index.jsp";
	}

}

