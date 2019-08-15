package com.rotech.languages.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rotech.languages.models.Language;
import com.rotech.languages.services.LanguageService;

@Controller
@RequestMapping("/languages")
public class LanguageController {
	private LanguageService langSer;
	
	public LanguageController(LanguageService langSer) {
		this.langSer = langSer;
	}
	
	@GetMapping("")
	public String index(Model model, @ModelAttribute("language") Language language) {
		List<Language> languages = langSer.allLanguages(); 
		model.addAttribute("languages", languages);
		return "languages/index.jsp";
	}
	
	@PostMapping("")
	public String create(@Valid @ModelAttribute("language") Language language, BindingResult result) {
		String page = result.hasErrors() ?  "languages/index.jsp":"redirect:/languages" ;
		langSer.update(language); 
		return page;
	}
	
	@GetMapping("/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		Language lang = langSer.findOne(id);
		model.addAttribute("language", lang);
		return "languages/show.jsp";
	}
	@GetMapping("/{id}/edit")
	public String displayEdit(Model model,
			@PathVariable("id") Long id,
			@ModelAttribute("language") Language language
			) {
		Language lang = langSer.findOne(id);
		model.addAttribute("language", lang);
		return "languages/edit.jsp";
	}
	@PutMapping("/{id}/edit")
	public String update(@ModelAttribute("language") Language language) {
		Language lang = langSer.update(language);
		return "redirect:/languages/" + lang.getId();
	}
	@DeleteMapping("/{id}")
	public String delete(@PathVariable("id") Long id) {
		langSer.delete(id);
		return "redirect:/languages";
	}
}
