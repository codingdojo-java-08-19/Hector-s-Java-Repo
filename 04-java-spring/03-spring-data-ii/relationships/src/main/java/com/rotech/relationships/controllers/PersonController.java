package com.rotech.relationships.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rotech.relationships.models.Person;
import com.rotech.relationships.services.LicenseServices;
import com.rotech.relationships.services.PersonService;

@Controller
@RequestMapping("/persons")
public class PersonController {
	private final PersonService prnServ;
	private final LicenseServices cardServ;
	public PersonController(PersonService prnServ,LicenseServices cardServ) {
		this.prnServ = prnServ;
		this.cardServ = cardServ;
	}
	@GetMapping("")
	public String displayPesonForm(@ModelAttribute("person") Person person) {
//		Long id = Long.parseLong("1");
//		prnServ.delete(id);
		return "person/NewPerson.jsp";
	}
	@GetMapping("/{id}")
	public String showPerson(@PathVariable("id")Long id, Model model) {
		
		Person person = prnServ.findById(id);
		System.out.println("here is the fucking id"+ person.getLicense());	
		model.addAttribute("card", person.getLicense());
		model.addAttribute("person",person);
		return "person/ShowPerson.jsp";
	}
	@PostMapping("/new")
	public String createPerson(@Valid @ModelAttribute("person") Person person, BindingResult result) {
		
		boolean error = result.hasErrors();
		if(!error) {
			person = prnServ.create(person);
			return "redirect:/persons/"+person.getId();
		}
		return "person/NewPerson.jsp";
	}
	@DeleteMapping("/{id}")
	public String delete(@PathVariable("id") Long id) {
		prnServ.delete(id);
		return "redirect:/persons";
	}
}
