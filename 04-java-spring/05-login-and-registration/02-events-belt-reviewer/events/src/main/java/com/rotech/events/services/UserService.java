package com.rotech.events.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.rotech.events.models.Event;
import com.rotech.events.models.User;
import com.rotech.events.repositories.UserRepo;

@Service
public class UserService {
	private final UserRepo repo;
	
	public UserService(UserRepo repo) {
		this.repo = repo;
	}
	public List<User> findAll(){
		return repo.findAll();
	}
	public User registerUser(User user) { 
		String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		user.setPassword(hashed);
		return repo.save(user);
	}
	
	public User findUserById(Long id) {
		Optional<User> maybe = repo.findById(id);
		return maybe.isPresent() ? maybe.get() : null;
	}
	
	public User findByEmail(String email) {
		Optional<User> maybe = repo.findByEmail(email);
		return maybe.isPresent() ? maybe.get():null;
	}
	public boolean authenticate(String email, String password) {
		Optional<User>maybe = repo.findByEmail(email);
		boolean authenticated = maybe.isPresent();
		
		if(authenticated) {
			authenticated = BCrypt.checkpw(password, maybe.get().getPassword());
		}
		System.out.println("service authenticate returned "+authenticated);
		return authenticated;
	}
	public List<User> findAllByAttending(Event event){
		return repo.findAllByAttending(event);
	}
	
}
