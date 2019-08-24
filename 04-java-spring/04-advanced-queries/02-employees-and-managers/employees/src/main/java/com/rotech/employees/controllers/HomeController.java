//package com.rotech.employees.controllers;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import com.rotech.employees.models.Manager;
//import com.rotech.employees.services.ManagerService;
//
//@Controller
//@RequestMapping("/")
//public class HomeController {
//	private final ManagerService mServ;
//
//	public HomeController( ManagerService mServ) {
//		this.mServ = mServ;
//	}
//	
//	@GetMapping("")
//	public String index(
//			@ModelAttribute("manager") Manager manager,
//			@ModelAttribute("employee") Manager employee,
//			Model model
//			) {
//		model.addAttribute("managers", mServ.findAllMtoENames());
//		model.addAttribute("employees", mServ.findAllEtoMNames());
//		return "Index.jsp";
//	}
//}
