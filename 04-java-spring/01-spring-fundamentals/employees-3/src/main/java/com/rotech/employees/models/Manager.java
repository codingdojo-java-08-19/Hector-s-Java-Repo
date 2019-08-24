package com.rotech.employees.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name="managers")
public class Manager {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String first_name;
	private String last_name;
	@Column(updatable=false)
	private Date createdAt;
	private Date updatedAt;
	@OneToMany(mappedBy="manager", fetch = FetchType.LAZY)
	private List<Manager> employees = new ArrayList<Manager>();
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="manager_id")
	private Manager manager;
	
	
	public Manager() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirst_name() {
//		System.out.println("GET FIRST NAME TRIGGERD");
		return first_name;
	}

	public void setFirst_name(String first_name) {
		System.out.println("SET FIRST NAME TRIGGERD");
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public List<Manager> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Manager> employees) {
		this.employees = employees;
	}
	
	public void addEmployee(Manager empolyee) {
		this.employees.add(empolyee);
	}
	
	@PrePersist
	protected void createdAt() {
		this.createdAt = new Date();
	}
	@PreUpdate
	protected void updatedAt() {
		this.updatedAt = new Date();
	}
	
}
