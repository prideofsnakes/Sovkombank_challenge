package starter_kit;

import java.util.List;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;


@EnableJpaRepositories(basePackageClasses=H2PhoneStorage.class)
public interface H2PhoneStorage extends CrudRepository<H2PhoneNumber, Long>{
	H2PhoneNumber findById(long id);
	List<H2PhoneNumber> findAll();
}
