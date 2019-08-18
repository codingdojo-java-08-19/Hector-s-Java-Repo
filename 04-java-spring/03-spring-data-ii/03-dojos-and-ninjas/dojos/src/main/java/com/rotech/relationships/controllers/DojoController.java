package com.rotech.relationships.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rotech.relationships.models.Dojo;
import com.rotech.relationships.services.DojoService;
import com.rotech.relationships.services.NinjaService;

@Controller
@RequestMapping("/dojos")
public class DojoController {
	private final DojoService service;
	private final NinjaService ninServ;
	
	public DojoController(DojoService service, NinjaService ninServ) {
		this.service = service;
		
		this.ninServ = ninServ;
	}
	
	@GetMapping("/new")
	public String displayNewDojo(@ModelAttribute("dojo") Dojo dojo) {
		return "dojos/NewDojo.jsp";
	}
	
	@PostMapping("/new")
	public String createDojoe(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if(!result.hasErrors()){
			service.create(dojo);
			return "redirect:/dojos/new";
		}
		
		return "dojos/NewDojo.jsp";
	}
	@GetMapping("/{id}")
	public String showDojo(@PathVariable("id") Long id, Model model) {
		Dojo dojo = service.findById(id);
		System.out.println("here are the ninjas"+ dojo.getNinjas());
		model.addAttribute("dojo", dojo);
		model.addAttribute("ninjas", dojo.getNinjas());
		return "dojos/ShowDojo.jsp";
	}

}
