package com.rotech.events.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rotech.events.models.Event;
import com.rotech.events.models.Location;
import com.rotech.events.models.MessageBoard;
import com.rotech.events.models.User;
import com.rotech.events.services.EventService;
import com.rotech.events.services.LocationService;
import com.rotech.events.services.UserService;

@Controller
@RequestMapping("/events")
public class EventController {
	private final EventService serv;
	private final UserService uServ;
	private final LocationService lServ;
	public EventController(EventService serv, UserService uServ, LocationService lServ) {
		this.serv = serv;
		this.uServ = uServ;
		this.lServ = lServ;
	}
	
	@GetMapping("")
	public String dashboard(
			Model model, 
			@ModelAttribute("event") Event event, 
			HttpSession session,
			RedirectAttributes flash
			) {
		boolean unauthorized = session.getAttribute("userId") == null;
		if(!unauthorized) {
			User user = uServ.findUserById((Long) session.getAttribute("userId")); 
			model.addAttribute("localEvents", serv.findByState(user.getHomeState()));
			System.out.println("here is the user's home state"+ user.getHomeState().getName());
			model.addAttribute("events", serv.findExcludingState(user.getHomeState()));
			model.addAttribute("states", lServ.findAll());
			model.addAttribute("user", user);
		}else {
			flash.addFlashAttribute("error", "unauthorized. please login or register");
		}
		
		return unauthorized ? "redirect:/" : "EventDashboard.jsp";

	}
	@PostMapping("")
	public String createEvent(
			Model model,
			@Valid @ModelAttribute("event") Event event,
			BindingResult result,
			HttpSession seesion
	) {
		boolean unauthorized = seesion.getAttribute("userId").equals(null);		
		String path = unauthorized ? "redirect:/" : "redirect:/events";

		if(!unauthorized) {
			unauthorized = result.hasErrors();
			path = unauthorized ? "EventDashboard.jsp" : "redirect:/events";
		}
		if(!unauthorized) {
			
			serv.create(event);
		}
		return path;
	}
	@GetMapping("/{id}")
	public String showEvent(
			@PathVariable("id") Long id,
			Model model,
			HttpSession session,
			RedirectAttributes flash,
			@ModelAttribute("newMessage") MessageBoard message
			) {
		boolean unauthorized = session.getAttribute("userId").equals(null);
		String path = unauthorized ? "redirect:/" : "ShowEvent.jsp";
		Event event = serv.findById(id);
		model.addAttribute("userId", session.getAttribute("userId"));
		model.addAttribute("event", event);
		model.addAttribute("attendess", uServ.findAllByAttending(event));
		model.addAttribute("howMany", serv.howManyAttendessById(id));
		return path;
		}
	
	@PutMapping("/{id}")
	public String attend(@PathVariable("id") Long id, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
		User user = uServ.findUserById(userId);
		Event event = serv.findById(id);
		event.addAttendee(user);
		serv.update(event);
		return "redirect:/events";
	}
	
	@GetMapping("/{id}/edit")
	public String renderEdit(@PathVariable("id") Long id, 
			HttpSession session,
			@ModelAttribute("updated") Event updated,
			Model model
			) {
		//authorization, check to see if id in session
		//the check if id matches event.host.id
		Long userId = (Long) session.getAttribute("userId");
		boolean unauthorized = userId.equals(null);
		String path = unauthorized? "redirect:/":"EditEvent.jsp";
		Event event = serv.findById(id);
		unauthorized = !event.getHost().getId().equals(userId);
		
		model.addAttribute("states", lServ.findAll());
		model.addAttribute("event", event);
		path = unauthorized ? "redirect:/": path;
	
		return path;
	}
	
	@PostMapping("/{id}/edit")
	public String updateEvent(
			@PathVariable("id") Long id,
			@RequestParam("name") String name,
			@RequestParam("date") String sDate,
			@RequestParam("city") String city,
			@RequestParam("state") String sState,
			HttpSession session,
			Model model
			) {
		System.out.println("I got this far");
		Long userId = (Long) session.getAttribute("userId");
		Event event = serv.findById(id);
		boolean unauthorized = !event.getHost().getId().equals(userId);
		
		if(!unauthorized) {
			System.out.println("if triggerd "+ sState);
			Date date = new Date();
			try {
				date = new SimpleDateFormat("yyyy-MM-dd").parse(sDate);
			} catch (ParseException e) {
				e.printStackTrace();
				return "redirect:/";
			}
			event.setName(name);
			event.setDate(date);
			event.setCity(city);
			event.setState(lServ.findByName(sState));
			serv.update(event);
		}
		model.addAttribute("states", lServ.findAll());
		model.addAttribute("event", event);

		return unauthorized ? "redirect:/": "redirect:/events";
	}
	
	@DeleteMapping("/{id}")
	public String deleteEvent(@PathVariable("id") Long id) {
		serv.deleteById(id);
		return "redirect:/events";
	}
}
