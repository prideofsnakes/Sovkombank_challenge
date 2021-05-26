package starter_kit;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;


@EnableJpaRepositories(basePackageClasses=H2PhoneStorage.class)
public interface H2PhoneStorage extends JpaRepository<H2PhoneNumber, Long>{
	List<H2PhoneNumber> findById(long id);
	List<H2PhoneNumber> findAll();
	
}
