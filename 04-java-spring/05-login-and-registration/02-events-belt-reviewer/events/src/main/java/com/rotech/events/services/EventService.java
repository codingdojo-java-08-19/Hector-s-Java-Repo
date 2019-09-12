package com.rotech.events.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rotech.events.models.Event;
import com.rotech.events.models.Location;
import com.rotech.events.repositories.EventRepo;


@Service
public class EventService {
	private final EventRepo repo;
	public EventService(EventRepo repo) {
		this.repo = repo;
	}
	
	public List<Event> findByState(Location state){
		return repo.findByState(state);
	}
	public List<Event> findExcludingState(Location state){
		return repo.findByStateNotLike(state);
	}
	public List<Event> findAll(){
		return repo.findAll();	
	}
	public Event create(Event event) {
		return repo.save(event);
	}
	public Event update(Event event) {
		return repo.save(event);
	}
	public Event findById(Long id) {
		return repo.findById(id).orElse(null);
	}
	public Integer howManyAttendessById(Long id) {
		return repo.howManyAttendees(id);
	}
	public void deleteById(Long id) {
		repo.deleteById(id);
	}
}
