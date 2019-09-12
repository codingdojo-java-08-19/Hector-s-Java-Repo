package com.rotech.events.services;

import org.springframework.stereotype.Service;

import com.rotech.events.models.MessageBoard;
import com.rotech.events.repositories.MessageRepo;

@Service
public class MessageService {
	private final MessageRepo repo;
	public  MessageService(MessageRepo repo) {
		this.repo = repo;
	}
	
	public MessageBoard create(MessageBoard message) {
		return this.repo.save(message);
	}
	public MessageBoard update(MessageBoard message) {
		return this.repo.save(message);
	}
	public void deleteById(Long id) {
		this.repo.deleteById(id);
	}
}
