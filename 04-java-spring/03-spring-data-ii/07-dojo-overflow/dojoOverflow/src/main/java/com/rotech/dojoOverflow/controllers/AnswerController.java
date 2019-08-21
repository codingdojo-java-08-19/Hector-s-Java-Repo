package com.rotech.dojoOverflow.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rotech.dojoOverflow.models.Answer;
import com.rotech.dojoOverflow.models.Question;
import com.rotech.dojoOverflow.services.AnswerService;
import com.rotech.dojoOverflow.services.QuestionService;

@Controller
@RequestMapping("/questions")
public class AnswerController {
	private final AnswerService service;
	private final QuestionService qServ;
	public AnswerController(AnswerService service, QuestionService qServ) {
		this.service = service;
		this.qServ = qServ;
	}
	@GetMapping("/{id}")
	public String displayNewAnswer(@PathVariable("id") Long id, Model model, @ModelAttribute("newAnswer") Answer answer) {
		Question question = qServ.findById(id);
		model.addAttribute("question", question);
		model.addAttribute("answers",question.getAnswers());
		
		return "NewAnswer.jsp";
	}
	
	@PostMapping("/{id}")
	public String createAnswer(@Valid @ModelAttribute("newAnswer") Answer answer, BindingResult result, @PathVariable("id") Long id) {
		if(!result.hasErrors()) {
			Answer newAnswer = service.create(answer);
			qServ.addAnswer(id, newAnswer);
			
			return "redirect:/questions/"+ id;
		}
		
		return "NewAnswer.jsp";
	}
}
