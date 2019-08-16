package com.rotech.relationships.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rotech.relationships.models.License;
import com.rotech.relationships.repositories.LicenseRepository;

@Service
public class LicenseServices {
	private final LicenseRepository repo;
	
	public LicenseServices (LicenseRepository repo) {
		this.repo = repo;
	}
	public List<License> findAll(){
		return repo.findAll();
	}
	public License create(License card) {
		return repo.save(card);
	}

}
