package com.rotech.events.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rotech.events.models.User;
import com.rotech.events.services.LocationService;
import com.rotech.events.services.UserService;
import com.rotech.events.validations.UserValidator;

@Controller
@RequestMapping("/")
public class HomeController {
	
	private final UserValidator validator;
	private final UserService serv;
	private final LocationService lServ;
	public HomeController(UserValidator validator, UserService serv, LocationService lServ) {
		this.validator = validator;
		this.serv = serv;
		this.lServ = lServ;
	}
	
	@GetMapping("/")
	public String index(
			@ModelAttribute("user") User user,
			Model model
			) {
		model.addAttribute("states", lServ.findAll());
		return "LoginRegister.jsp";
	}
	
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("user") User user,
			BindingResult result,
			HttpSession session,
			Model model
		) {
		validator.validate(user, result);
		String path = result.hasErrors() ? "LoginRegister.jsp" : "redirect:/events";
		if(!result.hasErrors()) {
			user = serv.registerUser(user);
			session.setAttribute("userId", user.getId());
		}
		model.addAttribute("states", lServ.findAll());
		return path;
	}
	@PostMapping("/login")
	public String login( 
			@RequestParam("email") String email,
			@RequestParam("password") String password,
			HttpSession session,
			Model  model,
			@ModelAttribute("user") User from
		) {
		boolean authenticated = serv.authenticate(email, password);
		String  path = authenticated ? "redirect:/events" : "LoginRegister.jsp";
		if(authenticated) {
			User user = serv.findByEmail(email);
			session.setAttribute("userId", user.getId());
			System.out.println("successfully logged in");
				}
		model.addAttribute("states", lServ.findAll());
		return path;
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
