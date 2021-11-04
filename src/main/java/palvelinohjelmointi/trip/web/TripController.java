package palvelinohjelmointi.trip.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import palvelinohjelmointi.trip.domain.Trip;
import palvelinohjelmointi.trip.domain.TripRepository;
import palvelinohjelmointi.trip.domain.User;
import palvelinohjelmointi.trip.domain.UserRepository;


@RestController
public class TripController {

	@Autowired
	TripRepository trepository;
	
	@Autowired
	UserRepository urepository;
	
	@RequestMapping(value="/api/trips", method = RequestMethod.GET)
	 public @ResponseBody Optional<Iterable<Trip>> findAllTripsRest() {	
    	return Optional.ofNullable(trepository.findAll());
  }    
	
	@RequestMapping("/api/trips")
	@PostMapping
	@ResponseBody Trip createTrip(@RequestBody Trip trip) {
		System.out.println(trip.getName());
        return trepository.save(trip);
    }
	
	@PutMapping("api/{tripId}/users/{userId}")
	@ResponseBody Trip reserveUserToTrip(@PathVariable Long tripId,
			@PathVariable Long userId) {
		
		Trip trip = trepository.findById(tripId).get();
		User user = urepository.findById(userId).get();
	
		trip.reservatedUsers.add(user);
		
		return trepository.save(trip);
	}
	
	@PutMapping("api/{tripId}/users/remove/{userId}")
	@ResponseBody Trip removeUserfromTrip(@PathVariable Long tripId,
			@PathVariable Long userId) {
		
		Trip trip = trepository.findById(tripId).get();
		User user = urepository.findById(userId).get();
	
		trip.reservatedUsers.remove(user);
		
		return trepository.save(trip);
	}
	
	
	@RequestMapping("/api/trips/{id}")
	@ResponseBody Optional<Trip> getTripById(@PathVariable("id") Long id) {
		return trepository.findById(id);
	}
	
	@RequestMapping(value = "api/trips/{id}", method = RequestMethod.DELETE) 
	@ResponseBody Iterable<Trip> deleteTrip(@PathVariable("id") Long id) {
		trepository.deleteById(id);
		return trepository.findAll();
	}
	
	@RequestMapping(value = "api/trips/modify/{id}", method = RequestMethod.PUT)
	@ResponseBody Trip modifyTrip(@PathVariable("id") Long id, @ModelAttribute Trip trip) {
		trip.setId(id);
		return trepository.save(trip);
	
	}
	
}
