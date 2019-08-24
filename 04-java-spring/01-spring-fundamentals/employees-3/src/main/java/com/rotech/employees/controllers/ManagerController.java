package com.rotech.employees.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rotech.employees.models.Manager;
import com.rotech.employees.services.ManagerService;


@Controller
@RequestMapping("/managers")
public class ManagerController {
	private final ManagerService mServ;
	public ManagerController( ManagerService mServ) {
		this.mServ = mServ;
	}
	
	@GetMapping("")
	public String index(@ModelAttribute("manager") Manager manager) {
		return "NewManager.jsp";
	}
	
	@PostMapping("")
	public String create(
			@Valid @ModelAttribute("employee") Manager manager, 
			BindingResult result, 
			Model model
			) {
		System.out.println("manager triggerd");
		String path = result.hasErrors() ? "NewManager.jsp" : "redirect:/";
		
		if(!result.hasErrors())
		{
			mServ.createManager(manager);
		}
		
		return path;
	}
}
