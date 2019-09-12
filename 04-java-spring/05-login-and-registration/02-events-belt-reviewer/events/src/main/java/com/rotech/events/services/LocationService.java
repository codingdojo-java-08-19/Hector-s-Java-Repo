package com.rotech.events.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rotech.events.models.Location;
import com.rotech.events.repositories.LocationRepo;

@Service
public class LocationService {
	private final LocationRepo repo;
	public LocationService(LocationRepo repo) {
		this.repo = repo;
	}
	
	public List<Location> findAll(){
		return repo.findAll();
	}
	
	public Location findByName(String name) {
		return repo.findByName(name).orElse(null);
	}
	
}
