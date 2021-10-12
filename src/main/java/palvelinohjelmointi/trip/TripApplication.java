package palvelinohjelmointi.trip;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import palvelinohjelmointi.trip.domain.*;

@SpringBootApplication
public class TripApplication {

	public static void main(String[] args) {
		SpringApplication.run(TripApplication.class, args);
	}

	@Bean
	public CommandLineRunner studentDemo(TripRepository trepository,
			UserRepository urepository) {
		return (args) -> {
			System.out.println("luodaan käyttäjiä");
			urepository.save(new User("jakko"));
			urepository.save(new User("pekka"));
			
			trepository.save(new Trip("12.12.12", "pikkujoulut"));
			
			Trip trip = trepository.findByDate("12.12.12");
			trip.reservatedUsers.add(urepository.findByUsername("jakko"));
			trip.reservatedUsers.add(urepository.findByUsername("pekka"));
			trepository.save(trip);
		
			System.out.println(trepository.findAll());
		};
}}
