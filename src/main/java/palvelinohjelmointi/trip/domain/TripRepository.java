package palvelinohjelmointi.trip.domain;

import org.springframework.data.repository.CrudRepository;



public interface TripRepository extends CrudRepository<Trip, Long>{

	Trip findByDate(String date);
	
}
