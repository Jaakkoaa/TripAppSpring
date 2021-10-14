package palvelinohjelmointi.trip.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class User {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String username;

	@JsonIgnore
	@ManyToMany(mappedBy = "reservatedUsers", fetch = FetchType.EAGER)
	Set<Trip> trips = new HashSet<>();
	
	public User() {
			
	}
	
	public User(String username) {
		
		this.username = username;
		
	}
	
	public User(Long id, String username) {
		super();
		this.id = id;
		this.username = username;
		
	}

	public User(Long id, String username, Set<Trip> trips) {
		super();
		this.id = id;
		this.username = username;
		this.trips = trips;
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
	
	
}
