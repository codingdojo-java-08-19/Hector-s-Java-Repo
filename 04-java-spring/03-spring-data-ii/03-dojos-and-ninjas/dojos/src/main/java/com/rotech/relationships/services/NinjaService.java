package com.rotech.relationships.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rotech.relationships.models.Ninja;
import com.rotech.relationships.repositories.NinjaRepository;

@Service
public class NinjaService {
	private final NinjaRepository repo;
	
	public NinjaService(NinjaRepository repo) {
		this.repo = repo;
	}
	public List<Ninja> getAll(){
		return repo.findAll();
	}
	public Ninja create(Ninja ninja) {
		return repo.save(ninja);
	}
}
