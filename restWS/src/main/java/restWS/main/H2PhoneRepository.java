package restWS.main;

import org.springframework.data.repository.CrudRepository;

public interface H2PhoneRepository extends CrudRepository<H2Phone, Long> {
	H2Phone getById(long id);
}
