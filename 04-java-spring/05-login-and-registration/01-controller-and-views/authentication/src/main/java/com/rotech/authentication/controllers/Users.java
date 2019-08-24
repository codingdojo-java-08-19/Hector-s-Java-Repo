package com.rotech.authentication.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.rotech.authentication.models.User;
import com.rotech.authentication.services.UserService;

// imports removed for brevity
@Controller
public class Users {
	private final UserService userService;
    
    public Users(UserService userService) {
        this.userService = userService;
    }
    
    @RequestMapping("/registration")
    public String registerForm(@ModelAttribute("user") User user) {
        return "registrationPage.jsp";
    }
    @RequestMapping("/login")
    public String login() {
        return "loginPage.jsp";
    }
    
    @RequestMapping(value="/registration", method=RequestMethod.POST)
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
    	// if result has errors, return the registration page (don't worry about validations just now)
        // else, save the user in the database, save the user id in session, and redirect them to the /home route
    	String path = result.hasErrors() ? "registrationPage.jsp" : "redirect:/home";
    	if(!result.hasErrors()) {
    		user = userService.registerUser(user);
    		session.setAttribute("userId", user.getId());
    	}
    	return path;
    }
    
    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
        // if the user is authenticated, save their user id in session
        // else, add error messages and return the login page
    	boolean authenticated = userService.authenticateUser(email, password);
    	String path = authenticated ? "redirect:/home" : "redirect:/login";
    	
    	if(authenticated) {
    		User user = userService.findByEmail(email);
    		session.setAttribute("userId", user.getId());
    	}else {
    		model.addAttribute("error", "login unsuccessful, please try again.");
    	}
    	
    	return path;
    }
    
    @RequestMapping("/home")
    public String home(HttpSession session, Model model) {
        // get user from session, save them in the model and return the home page
    	boolean notAuthenticated= session.getAttribute("userId").equals(null);
    	String path = notAuthenticated ? "redirect:/login" : "home.jsp";
    	if(notAuthenticated) {
    		model.addAttribute("error","unsuccessful login attempt. please try agin");
    	}else {
    		User user = userService.findUserById((Long) session.getAttribute("userId"));
    		model.addAttribute("user", user);
    	}
    	return path;
    }
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        // invalidate session
        // redirect to login page
    	session.invalidate();
    	return "redirect:/registration";
    }
}