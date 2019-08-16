package com.rotech.relationships.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.rotech.relationships.models.Person;
import com.rotech.relationships.repositories.PersonRepository;

@Service
public class PersonService {
	private final PersonRepository prnRepo;
		
	public PersonService(PersonRepository prnRepo) {
		this.prnRepo = prnRepo;
	}
	
	public List<Person> findAll(){
		return prnRepo.findAll();
	}
	
	public Person findById(Long id) {
		Optional<Person> maybe = prnRepo.findById(id);
		if(maybe.isPresent()){
			return maybe.get();
		}else {
			return null;
		}
	}
	public Person create(Person person) {
		return prnRepo.save(person);
	}
	public Person findByFirstName(String firstName) {
		Optional<Person> maybe = prnRepo.findByFirstName(firstName);
		if(maybe.isPresent()) {
			return maybe.get();
		}else {
			return null;
		}
	}
	public void delete(Long id) {
		prnRepo.deleteById(id);
	}
}
