package com.rotech.displaydate.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	@RequestMapping("")
	public String index() {
		return "index.jsp";
	}
	
	@SuppressWarnings("deprecation")
	@RequestMapping("/date")
	public String date(Model model) {
		SimpleDateFormat dateFormater = new SimpleDateFormat("EEEE");
		java.util.Date date = new java.util.Date();
		java.util.Calendar calendar = java.util.Calendar.getInstance();
		DateFormat formateddate = DateFormat.getDateInstance();
		System.out.println(formateddate.format(date));
		model.addAttribute("month", formateddate.format(date));
		model.addAttribute("day", dateFormater.format(date));
		return "date.jsp";
	}
	
	@RequestMapping("/time")
	public String time(Model model) {
		java.util.Date now = new java.util.Date();
		DateFormat dateformater = new SimpleDateFormat("hh:mm aa");
		model.addAttribute("time", dateformater.format(now));
		return "time.jsp";
	}

}
