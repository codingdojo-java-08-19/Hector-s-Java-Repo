package com.rotech.relationships.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.rotech.relationships.models.Dojo;

public interface DojoRepository extends CrudRepository<Dojo, Long> {
	List<Dojo>findAll();
	Dojo findByName(String name);
}
