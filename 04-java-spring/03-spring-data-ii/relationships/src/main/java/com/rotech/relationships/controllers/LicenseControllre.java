 package com.rotech.relationships.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rotech.relationships.models.FormLicense;
import com.rotech.relationships.models.License;
import com.rotech.relationships.models.Person;
import com.rotech.relationships.services.LicenseServices;
import com.rotech.relationships.services.PersonService;

@Controller
@RequestMapping("licenses")
public class LicenseControllre {
	private final LicenseServices cardServ;
	private final PersonService prnServ;
	public LicenseControllre(LicenseServices cardServ, PersonService prnServ) {
		this.cardServ = cardServ;
		this.prnServ = prnServ;
	}
	@GetMapping("")
	public String displayLicense(@ModelAttribute("card") FormLicense card,Model model) {
		List<Person> persons = prnServ.findAll();
		model.addAttribute("persons", persons);	
		return "license/NewLicense.jsp";
	}
	@PostMapping("/new")
	public String createLicense(@Valid @ModelAttribute("card") FormLicense formCard, BindingResult result) throws ParseException {	
		
		Person person = prnServ.findByFirstName(formCard.getPerson());
		if(!result.hasErrors()&& person ==null ) {
			License card = new License();
			Date date = new SimpleDateFormat("yyyy-MM-dd").parse(formCard.getExpirationDate());
			card.setExpirationDate(date);
			card.setPerson(person);
			cardServ.create(card);
			return "redirect:/licenses";
		}
		return "license/NewLicense.jsp";
	}
	
	
}
