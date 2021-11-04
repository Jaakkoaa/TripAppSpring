package palvelinohjelmointi.trip.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="usertable")
public class User {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, unique = true, updatable = false)
	private long id;
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "username", nullable = false, unique = true)
	private String username;
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "password", nullable = false, unique = false)
	private String passwordHash;
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "role", nullable = false, unique = false)
	private String role;

	@JsonIgnore
	@ManyToMany(mappedBy = "reservatedUsers", fetch = FetchType.EAGER)
	Set<Trip> trips = new HashSet<>();
	
	


	public User() {
			
	}
	


	public User(Long id, String username, Set<Trip> trips) {
		super();
		this.id = id;
		this.username = username;
		this.trips = trips;
	}

	
	
	public User(String username, String passwordHash, String role) {
		super();
		this.username = username;
		this.passwordHash = passwordHash;
		this.role = role;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Set<Trip> getTrips() {
		return trips;
	}

	public void setTrips(Set<Trip> trips) {
		this.trips = trips;
	} 
	
	
	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
}
