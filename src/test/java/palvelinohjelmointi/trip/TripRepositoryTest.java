package palvelinohjelmointi.trip;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import palvelinohjelmointi.trip.domain.Trip;
import palvelinohjelmointi.trip.domain.TripRepository;

public class TripRepositoryTest {
	
	@Autowired
	private TripRepository repository;
	
	@Test
	public void createNewTrip() {
		
		repository.save(new Trip("espanjaan", "12.12.12"));
		assertThat(repository.findByDate("12.12.12")).isNotNull();
	}
	
	@Test
	public void deleteTrip() {
		Trip trip = repository.findByDate("12.12.12");
		repository.delete(trip);
		assertThat(repository.findByDate("12.12.12")).isNull();
	}
	
}