package restWS.main;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface H2PhoneRepository extends CrudRepository<H2Phone, Long> {
//	H2Phone getById(long id);
//	H2Phone findByUserId(long id);
//	List<H2Phone> getAllById(long id);
	List<H2Phone> getAllByuserid(long id);
}
