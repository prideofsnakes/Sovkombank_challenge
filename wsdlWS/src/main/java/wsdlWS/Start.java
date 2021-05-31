package wsdlWS;

import javax.annotation.PostConstruct;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import h2db.H2Repository;
import h2db.H2User;
import ru.hilariousstartups.soap.gen.Gender;


@SpringBootApplication
@ComponentScan("h2db")
@EntityScan("h2db")
public class Start {
	
	public static void main(String[] args) {
		SpringApplication.run(Start.class, args);
	}
	  @Bean
	  public CommandLineRunner demo(H2Repository repository) {
	    return (args) -> {
	      // save a few H2Users
	    	repository.save(new H2User("Jack", "Bauer", Gender.MALE));
	    	repository.save(new H2User("Chloe", "O'Brian", Gender.FEMALE));
	    	repository.save(new H2User("Kim", "Bauer",Gender.MALE));
	    	repository.save(new H2User("David", "Palmer",Gender.MALE));
	    	repository.save(new H2User("Michelle", "Dessler", Gender.FEMALE));
			
			    // fetch all H2Users
			    System.out.println("H2Users found with findAll():");
			    System.out.println("-------------------------------");
			    for (H2User H2User : repository.findAll()) {
			      System.out.println("UserID: "+H2User.getId());
			    }
			    System.out.println("");
			
			    // fetch an individual H2User by ID
			    H2User H2User = repository.findById(1L);
			    System.out.println("H2User found with findById(1L):");
			    System.out.println("--------------------------------");
			    System.out.println(H2User.getFirstName());
			    System.out.println("");

	    };
	  }
}
