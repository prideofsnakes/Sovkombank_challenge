package wsdlWS;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface H2Repository extends CrudRepository<H2User, Long> {
	
	H2User findById(long id);
}
