package com.rotech.relationships.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.rotech.relationships.models.Person;

public interface PersonRepository extends CrudRepository<Person, Long> {
	List<Person> findAll();
	Optional<Person> findByFirstName(String name);

}
