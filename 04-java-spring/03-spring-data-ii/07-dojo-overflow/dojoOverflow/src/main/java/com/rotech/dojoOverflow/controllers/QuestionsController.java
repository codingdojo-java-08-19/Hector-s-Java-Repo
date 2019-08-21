package com.rotech.dojoOverflow.controllers;

import java.util.ArrayList;
import java.util.Arrays;
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

import com.rotech.dojoOverflow.models.Question;
import com.rotech.dojoOverflow.models.Tag;
import com.rotech.dojoOverflow.services.QuestionService;
	
@Controller
@RequestMapping("/questions")
public class QuestionsController {
	private final QuestionService service;
	public QuestionsController(QuestionService service) {
		this.service = service;
	}
	@GetMapping("")
	public String index(Model model) {
		List<Question> questions = service.findAll();
		model.addAttribute("questions",questions);
		return "QuestionsDashboard.jsp";
	}
	@GetMapping("/new")
	public String displayNewForm(@ModelAttribute("theQuestion") Question question, Model model) {
		return "NewQuestion.jsp";
	}
	@PostMapping("")
	public String create( @Valid @ModelAttribute("theQuestion") Question question, BindingResult result, @RequestParam("stags") String stags)  {
		System.out.println("new triggerd");

		List<String> tags = new ArrayList<String>(Arrays.asList(stags.split(",")));
		if(stags.contains(",")==false) {
			//to many tags error and reload page
			System.out.println("tags length if triggerd");
			return "redirect:/questions/new";
		}		
		int length = tags.size()>3 ? 3 : tags.size();
		if(!result.hasErrors()) {
			for(int i = 0; i < length; i++) {
				Tag tag = service.findOrCreateTag(tags.get(i).trim().toLowerCase());
				question.addTag(tag);
			}
			System.out.println("no errors if triggerd");
			service.create(question);
			return "redirect:/questions/"+question.getId();
		}
		return "NewQuestion.jsp";
	}
	
	
}
