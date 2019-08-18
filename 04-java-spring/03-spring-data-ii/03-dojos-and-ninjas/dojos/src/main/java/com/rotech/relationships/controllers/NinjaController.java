package com.rotech.relationships.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rotech.relationships.models.Dojo;
import com.rotech.relationships.models.Ninja;
import com.rotech.relationships.services.DojoService;
import com.rotech.relationships.services.NinjaService;

@Controller
@RequestMapping("/ninjas")
public class NinjaController {
	private final NinjaService service;
	private final DojoService joServ;
	
	public NinjaController(NinjaService service, DojoService joServ) {
		this.service = service;
		this.joServ = joServ;
	}
	
	@GetMapping("/new")
	public String displayNinjaForm(@ModelAttribute("ninja") Ninja ninja,Model model) {
		List<Dojo> dojos = joServ.findAll();
		model.addAttribute("dojos",dojos);
		return "ninjas/NewNinja.jsp";
	}
	@PostMapping("/new")
	public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result, @RequestParam("sdojo") String sdojo) {
		if(!result.hasErrors()) {		
			Dojo dojo = joServ.findByName(sdojo);
			ninja.setDojo(dojo);
			service.create(ninja);
			return "redirect:/ninjas/new";
		}
		System.out.println("ninja creation  failed");
		return "ninjas/NewNinja.jsp";
	}
	
}



