package palvelinohjelmointi.trip.domain;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Trip {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private String date;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name="reservations",
			joinColumns = @JoinColumn(name = "trip_id"),
			inverseJoinColumns = @JoinColumn(name = "user_id")
	)
	public
	Set<User> reservatedUsers = new HashSet<>();
	
	public Trip() {
		
		
	}
	
	public Trip(String date, String name) {
		super();
		
		this.name = name;
		this.date = date;
		
	}
	
	public Trip(Long id, String date) {
		super();
		this.id = id;
		this.date = date;
		
	}
	
	public Trip(Long id, String date, Set<User> reservatedUsers) {
		super();
		this.id = id;
		this.date = date;
		this.reservatedUsers = reservatedUsers;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Set<User> getReservatedUsers() {
		return reservatedUsers;
	}

	public void setUsers(Set<User> reservatedUsers) {
		this.reservatedUsers = reservatedUsers;
	}
	
	
	
}
