package h2db;


import org.springframework.data.repository.CrudRepository;

public interface H2Repository extends CrudRepository<H2User, Long> {
	
	H2User findById(long id);
}
