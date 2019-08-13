package com.rotech.thecode.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestAttributes;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping(value="/result", method= RequestMethod.POST)
	public String info(@RequestParam("name") String name, @RequestParam("location") String local, @RequestParam("favLang") String favLang, @RequestParam("comment") String comment, HttpSession session) {
		System.out.println(name + local);
		session.setAttribute("name", name);
		session.setAttribute("local", local);
		session.setAttribute("favLang", favLang);
		session.setAttribute("comment", comment);
		return "redirect:/result";
	}
	
	@RequestMapping("/result")
	public String showInfo(Model model, HttpSession session) {
		
		String name = (String) session.getAttribute("name");
		String local = (String) session.getAttribute("local");
		String favLang = (String) session.getAttribute("favLang");
		String comment = (String) session.getAttribute("comment");
		System.out.println(name + local);
		model.addAttribute("name", name);
		model.addAttribute("local", local);
		model.addAttribute("favLang", favLang);
		model.addAttribute("comment", comment);
		return "info.jsp";
	}
}
