package palvelinohjelmointi.trip.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import palvelinohjelmointi.trip.domain.Trip;
import palvelinohjelmointi.trip.domain.TripRepository;
import palvelinohjelmointi.trip.domain.User;
import palvelinohjelmointi.trip.domain.UserRepository;


@Controller
public class UserController {
	@Autowired
	TripRepository trepository;
	
	@Autowired
	UserRepository urepository;
	
	@RequestMapping(value="/api/users", method = RequestMethod.GET)
	 public @ResponseBody Optional<Iterable<User>> findAllUsersRest() {	
    	return Optional.ofNullable(urepository.findAll());
  }    
	
	@RequestMapping(value="/api/users", method = RequestMethod.POST)
	public @ResponseBody User createUser(@ModelAttribute User user) {
        return urepository.save(user);
    }
	
	@RequestMapping("/api/users/{id}")
	@ResponseBody Optional<User> getUserById(@PathVariable("id") Long id) {
		return urepository.findById(id);
	}
	
	@RequestMapping(value = "api/users/delete/{id}", method = RequestMethod.DELETE) 
	@ResponseBody Iterable<User> deleteUser(@PathVariable("id") Long id) {
		urepository.deleteById(id);
		return urepository.findAll();
	}
	
	@RequestMapping(value = "api/users/modify/{id}", method = RequestMethod.PUT)
	@ResponseBody User modifyuser(@PathVariable("id") Long id, @ModelAttribute User user) {
		user.setId(id);
		return urepository.save(user);
	
	}
	
}
