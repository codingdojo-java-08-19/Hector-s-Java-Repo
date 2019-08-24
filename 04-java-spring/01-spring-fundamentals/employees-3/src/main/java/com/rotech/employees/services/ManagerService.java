package com.rotech.employees.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.rotech.employees.models.Manager;
import com.rotech.employees.repositories.ManagerRepo;

@Service
public class ManagerService {
	private final ManagerRepo repo;
	public ManagerService(ManagerRepo repo) {
		this.repo = repo;
	}
	public Manager createManager(Manager manager) {
		return repo.save(manager);
	}
	public Manager createEmpolyee(Manager manager) {
		return repo.save(manager);
	}
	public Manager findById(Long id) {
		Optional<Manager> maybe = repo.findById(id);
		System.out.println("service manager's name"+maybe.get().getFirst_name());
		return maybe.isPresent() ? maybe.get() : null;
	}
	public List<Manager> findAllManagers(){
		return repo.findAllManagers();
	}
	public List<Manager> findAllEmployees(){
		return repo.findAllEmployees();
	}
}
