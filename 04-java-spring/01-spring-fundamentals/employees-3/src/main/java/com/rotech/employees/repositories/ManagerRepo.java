package com.rotech.employees.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rotech.employees.models.Manager;

@Repository
public interface ManagerRepo extends CrudRepository<Manager, Long> {
	List<Manager> findAll();
	@Query("SELECT m FROM Manager m WHERE m.manager IS null")
	List<Manager> findAllManagers();
	@Query("SELECT m FROM Manager m WHERE m.manager IS NOT null")
	List<Manager> findAllEmployees();
	
}
