package h2db;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface H2Repository extends CrudRepository<H2User, Long> {
	
	List<H2User> findByLastName(String lastName);
	H2User findById(long id);
}
