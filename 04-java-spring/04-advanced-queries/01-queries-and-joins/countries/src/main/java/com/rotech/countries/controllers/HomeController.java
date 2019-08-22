package com.rotech.countries.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rotech.countries.services.apiService;

@Controller
@RequestMapping("/")
public class HomeController {
	private final apiService serv;
	public HomeController(apiService serv) {
		this.serv = serv;
	}
	
	@GetMapping("")
	public String index(Model model) {
		
		model.addAttribute("countries", serv.howManyCities());
		model.addAttribute("sloviCities", serv.whoSpeaksSlovene());
		model.addAttribute("mexiCitz", serv.halfMiliMexiCity());
		model.addAttribute("topLangs", serv.majorLangs());
		model.addAttribute("bigLil", serv.bigLilCountries());
		model.addAttribute("bigMons", serv.bigMons());
		model.addAttribute("buenosAires", serv.wassupBuenosAires());
		model.addAttribute("countryZ", serv.countryZ());
		
		return "Index.jsp";
	}

}
