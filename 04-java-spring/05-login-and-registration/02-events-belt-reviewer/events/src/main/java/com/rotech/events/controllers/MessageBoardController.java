package com.rotech.events.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rotech.events.models.MessageBoard;
import com.rotech.events.services.EventService;
import com.rotech.events.services.MessageService;
import com.rotech.events.services.UserService;

@Controller
@RequestMapping("/messages")
public class MessageBoardController {
	private final MessageService serv;
	private final UserService uServ;
	private final EventService eServ;
	
	public MessageBoardController(
			MessageService serv, 
			UserService uServ,
			EventService eServ
			) {
		this.serv = serv;
		this.uServ = uServ;
		this.eServ = eServ;
	}
	
	@PostMapping("/{id}")
	public String newdMesseage(
			@PathVariable("id") Long id,
			@Valid @ModelAttribute("newMessage") MessageBoard message,
			BindingResult result,
			HttpSession session 
			) {
		boolean unauthorized = session.getAttribute("userId").equals(null);
		String path = unauthorized ? "redirect:/": "redirect:/events/"+id;
		path = result.hasErrors()? "ShowEvent.jsp": path;
		
		if(!unauthorized && !result.hasErrors()) {
			serv.create(message);
		}
		
		return path;
	}
}
