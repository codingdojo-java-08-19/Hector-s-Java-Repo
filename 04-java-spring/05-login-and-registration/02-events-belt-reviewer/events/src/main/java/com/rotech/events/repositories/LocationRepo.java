package com.rotech.events.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rotech.events.models.Location;

@Repository
public interface LocationRepo extends CrudRepository<Location, Long> {
	List<Location> findAll();
	Optional<Location> findByName(String Name);
}
