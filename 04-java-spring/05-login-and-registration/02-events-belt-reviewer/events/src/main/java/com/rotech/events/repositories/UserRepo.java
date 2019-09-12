package com.rotech.events.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.rotech.events.models.Event;
import com.rotech.events.models.User;


public interface UserRepo extends CrudRepository<User, Long> {
	List<User> findAll();
	
	Optional<User> findByEmail(String email);
	
	List<User> findAllByAttending(Event event);
	
}
