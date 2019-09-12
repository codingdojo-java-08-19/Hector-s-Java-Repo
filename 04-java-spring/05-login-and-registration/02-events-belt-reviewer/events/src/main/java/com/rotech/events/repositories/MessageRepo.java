package com.rotech.events.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rotech.events.models.MessageBoard;

import antlr.debug.Event;

@Repository
public interface MessageRepo extends CrudRepository<MessageBoard, Long> {
	List<MessageBoard> findAll();
	List<MessageBoard> findAllByEvent(Event event);
}