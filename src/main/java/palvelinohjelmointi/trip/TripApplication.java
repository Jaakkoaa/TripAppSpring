package palvelinohjelmointi.trip;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import palvelinohjelmointi.trip.domain.User;
import palvelinohjelmointi.trip.domain.*;

@SpringBootApplication
@RestController
public class TripApplication {
	
	

	public static void main(String[] args) {
		SpringApplication.run(TripApplication.class, args);
	}
	
	

	@Bean
	public CommandLineRunner studentDemo(TripRepository trepository,
			UserRepository urepository) {
		return (args) -> {
			System.out.println("luodaan käyttäjiä");
			urepository.save(new User("admin", "$2a$10$fMKk86JHMeM0n963Lsz4Jux4e.uj8HDeQvEYLfHczJsyWRAD8zzFO", "ADMIN"));
			urepository.save(new User("user", "$2a$10$FQOYjvd8h5N0j0eXl8pNJeCIVjfRQZ9sPY1T5pdbwvLXRg9JCuzAa", "USER"));
			urepository.save(new User("jakko", "$2a$10$faNxzuacHR.x1XhyIZkiduKEYOR5E3TQUJz8XnWcXsD030cG2vjRW", "USER"));
			
			trepository.save(new Trip("12.12.12", "pikkujoulut"));
			
			Trip trip = trepository.findByDate("12.12.12");
			trip.reservatedUsers.add(urepository.findByUsername("jakko"));
			trip.reservatedUsers.add(urepository.findByUsername("pekka"));
			trepository.save(trip);
		
			System.out.println(trepository.findAll());
		};
		
		
}}
