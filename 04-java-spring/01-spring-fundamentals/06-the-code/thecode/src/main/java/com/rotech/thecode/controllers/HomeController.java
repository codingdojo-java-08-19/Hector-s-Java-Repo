package com.rotech.thecode.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	@RequestMapping(value = "/thecode", method = RequestMethod.POST)
	public String check(@RequestParam(value="code") String code, RedirectAttributes flash) {
		if(!code.equals("bushido")) {
			System.out.println("post if triggerd");
			flash.addFlashAttribute("error","You must train harder!");
			return "redirect:/";
		}
		return "redirect:/thecode";
	}
	@RequestMapping(value="/thecode", method = RequestMethod.GET)
	public String displayCode() {
		return "theCode.jsp";
	}

}
