package com.rotech.events.models;

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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Entity
@Table(name="users")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(updatable=false)
	private Date createdAt;
	private Date updatedAt;
	@Email(message="email must be vaild")
	private String email;
	@Size(min=2, message="first name must be at least 2 characters long")
	private String first_name;
	@Size(min=2, message="last name must be at least 2 characters long")
	private String last_name;
	@Transient
	private String confirmPWord;
	private String password;
	@OneToMany(mappedBy="host", fetch = FetchType.LAZY)
	private List<Event> hosting = new ArrayList<Event>();
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name = "attendance",
			joinColumns = @JoinColumn(name="attendee_id"),
			inverseJoinColumns = @JoinColumn(name="attending_id")
			)
	private List<Event> attending = new ArrayList<Event>();
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="location_id")
	private Location homeState;
	
	public User() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getConfirmPWord() { 
		return confirmPWord;
	}

	public void setConfirmPWord(String confrimPWord) {
		this.confirmPWord = confrimPWord;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Event> getHosting() {
		return hosting;
	}

	public void setHosting(List<Event> hosting) {
		this.hosting = hosting;
	}
	
	public void addEventToHosting(Event newEvent) {
		this.hosting.add(newEvent);
	}

	public List<Event> getAttending() {
		return attending;
	}

	public void setAttending(List<Event> attending) {
		this.attending = attending;
	}
	
	public void addAttending(Event event) {
		this.attending.add(event);
	}

	public Location getHomeState() {
		return homeState;
	}

	public void setHomeState(Location homeState) {
		this.homeState = homeState;
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
