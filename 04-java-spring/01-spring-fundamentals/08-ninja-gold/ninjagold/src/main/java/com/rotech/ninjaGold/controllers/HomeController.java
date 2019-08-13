package com.rotech.ninjaGold.controllers;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String index(HttpSession session, Model model) {
		if(session.getAttribute("gold")==null) {
			session.setAttribute("gold", "0");
			session.setAttribute("activities", new ArrayList<String>());
		}
		String gold = (String) session.getAttribute("gold");
		ArrayList<String> activities = (ArrayList<String>) session.getAttribute("activities");
		
		model.addAttribute("gold", gold);
		model.addAttribute("activities", activities);
		return "index.jsp";
	}
	@RequestMapping(value="/gold", method = RequestMethod.POST)
	public String processGold(HttpSession session, @RequestParam("local") String local, @RequestParam("goldMax") String stringmax, @RequestParam("goldMin") String stringmin) {
		Integer max = Integer.parseInt(stringmax);
		Integer min = Integer.parseInt(stringmin);
		Integer newGold = ThreadLocalRandom.current().nextInt(min,max+1);
		String stringgold = (String) session.getAttribute("gold");
		Integer gold = Integer.parseInt(stringgold);
		ArrayList<String> activities = (ArrayList<String>) session.getAttribute("activities");
		
		String newActivitie = "You found " + newGold.toString() + "at the " + local;
		activities.add(0,newActivitie);
		gold += newGold;
		
		session.setAttribute("activites", activities);
		session.setAttribute("gold", gold.toString());
		return "redirect:/";
	}
	

}
