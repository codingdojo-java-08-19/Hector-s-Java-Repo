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
import javax.validation.constraints.Future;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="events")
public class Event {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Size(min=2,message="city must be at least two characters long!")
	private String city;
	@Size(min=2,message="name must be at least two characters long!")
	private String name;
	@Column(updatable=false)
	private Date createdAt;
	private Date updatedAt;
	@Future
	@DateTimeFormat(pattern = "yy-MM-dd")
	private Date date;
	@ManyToMany( fetch = FetchType.LAZY)
	@JoinTable(
			name = "attendance",
			joinColumns = @JoinColumn(name="attending_id"),
			inverseJoinColumns = @JoinColumn(name="attendee_id")
			)
	private List<User> attendees = new ArrayList<User>();
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="host_id")
	private User host;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="state_id")
	private Location state;
	@OneToMany(mappedBy="event", fetch=FetchType.LAZY)
	private List<MessageBoard> messages = new ArrayList<MessageBoard>();
	public Event() {}

	public Long getId() {
		return id;
	}
	

	public List<MessageBoard> getMessages() {
		return messages;
	}

	public void setMessages(List<MessageBoard> messages) {
		this.messages = messages;
	}
	
	public void addMessage(MessageBoard message) {
		this.messages.add(message);
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<User> getAttendees() {
		return attendees;
	}

	public void setAttendees(List<User> attendees) {
		this.attendees = attendees;
	}
	 
	public void addAttendee(User attendee) {
		this.attendees.add(attendee);
	}

	public User getHost() {
		return host;
	}

	public void setHost(User host) {
		this.host = host;
	}

	public Location getState() {
		return state;
	}

	public void setState(Location state) {
		this.state = state;
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
