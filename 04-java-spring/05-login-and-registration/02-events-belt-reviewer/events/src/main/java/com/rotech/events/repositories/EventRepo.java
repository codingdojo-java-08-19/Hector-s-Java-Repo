package com.rotech.events.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.rotech.events.models.Event;
import com.rotech.events.models.Location;

public interface EventRepo extends CrudRepository<Event, Long> {
	List<Event> findAll();
	List<Event> findByState(Location state);
	List<Event> findByStateNotLike(Location state);
	@Query("SELECT COUNT(u) FROM Event e JOIN e.attendees u WHERE e.id = ?1")
	Integer howManyAttendees(Long id);
}
