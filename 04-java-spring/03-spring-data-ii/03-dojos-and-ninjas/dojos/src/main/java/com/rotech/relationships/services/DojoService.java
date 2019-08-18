package com.rotech.relationships.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.rotech.relationships.models.Dojo;
import com.rotech.relationships.repositories.DojoRepository;

@Service
public class DojoService {
	private final DojoRepository repo;
	public DojoService(DojoRepository repo) {
		this.repo = repo;
	}
	public List<Dojo> findAll(){
		return repo.findAll();
	}
	public Dojo findById(Long id) {
		Optional<Dojo> maybe =  repo.findById(id);
		if(maybe.isPresent()) {
			return maybe.get();
		}else {
			return null;
		}
	}
	public Dojo create(Dojo dojo) {
		return repo.save(dojo);
	}
	public Dojo findByName(String name) {
		return repo.findByName(name);
	}
}
