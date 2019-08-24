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
@RequestMapping("/employees")
public class EmployeeController {
	private final ManagerService mServ;
	public EmployeeController( ManagerService mServ) {
		this.mServ = mServ;
	}
	
	
	@GetMapping("")
	public String index(@ModelAttribute("employee") Manager employee, Model model) {
		model.addAttribute("managers", mServ.findAllManagers());
		return "NewEmployee.jsp";
	}
	
	@PostMapping("")
	public String create(
			@Valid @ModelAttribute("employee") Manager employee, 
			BindingResult result, 
			Model model
			) {
		System.out.println("employee triggerd");
		String path = result.hasErrors() ? "NewEmployee.jsp" : "redirect:/";
		
		if(result.hasErrors())
		{
			model.addAttribute("managers", mServ.findAllManagers());
		}else {
			Manager foundManager = mServ.findById(employee.getManager().getId());
//			System.out.println("here is the new employees manager's name "+ employee.getId());
			System.out.println("here is the found manager's name "+ foundManager.getFirst_name());
		
			System.out.println("here is the new employee's name "+ employee.getFirst_name());
			System.out.println("here is the new employees manager's name "+ employee.getManager().getId());
//			manager.addEmployee(employee);
			mServ.createEmpolyee(employee);
		}
		
		return path;
	}
}
