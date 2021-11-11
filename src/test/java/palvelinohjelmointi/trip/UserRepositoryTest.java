package palvelinohjelmointi.trip;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import palvelinohjelmointi.trip.domain.User;
import palvelinohjelmointi.trip.domain.UserRepository;

public class UserRepositoryTest {
	
	@Autowired
	private UserRepository repository;
	
	@Test
	public void createNewUser() {
		
		repository.save(new User("jakko", "$2a$10$faNxzuacHR.x1XhyIZkiduKEYOR5E3TQUJz8XnWcXsD030cG2vjRW", "USER"));
		assertThat(repository.findByUsername("jakko")).isNotNull();
	}
	
	@Test
	public void deleteUser() {
		User user = repository.findByUsername("admin");
		repository.delete(user);
		assertThat(repository.findByUsername("admin")).isNull();
	}
	
}
