//package com.rotech.employees.controllers;
//
//import javax.validation.Valid;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import com.rotech.employees.models.Manager;
//import com.rotech.employees.services.ManagerService;
//
//
//@Controller
//@RequestMapping("/employees")
//public class EmployeeController {
//	private final ManagerService mServ;
//	public EmployeeController( ManagerService mServ) {
//		this.mServ = mServ;
//	}
//	
//	@PostMapping("")
//	public String create(
//			@Valid @ModelAttribute("employee") Manager employee, 
//			BindingResult result, 
//			@ModelAttribute("manager") Manager manager,
//			Model model
//			) {
//		String path = result.hasErrors() ? "Index.jsp" : "redirect:/";
//		
//		if(result.hasErrors())
//		{
//			model.addAttribute("managers", mServ.findAllMtoENames());
//			model.addAttribute("employees", mServ.findAllEtoMNames());
//		}else {
////			manager = mServ.findById(employee.getManager().getId());
////			manager.addEmployee(employee);
//			mServ.createEmpolyee(employee);
//		}
//		
//		return path;
//	}
//}
