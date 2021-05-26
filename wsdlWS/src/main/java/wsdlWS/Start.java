package wsdlWS;

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
	      repository.save(new H2User("Jack", "Bauer"));
	      repository.save(new H2User("Chloe", "O'Brian"));
	      repository.save(new H2User("Kim", "Bauer"));
	      repository.save(new H2User("David", "Palmer"));
	      repository.save(new H2User("Michelle", "Dessler"));

	      // fetch all H2Users
	      System.out.println("H2Users found with findAll():");
	      System.out.println("-------------------------------");
	      for (H2User H2User : repository.findAll()) {
	        System.out.println(H2User.toString());
	      }
	      System.out.println("");

	      // fetch an individual H2User by ID
	      H2User H2User = repository.findById(1L);
	      System.out.println("H2User found with findById(1L):");
	      System.out.println("--------------------------------");
	      System.out.println(H2User.toString());
	      System.out.println("");

	      // fetch H2Users by last name
	      System.out.println("H2User found with findByLastName('Bauer'):");
	      System.out.println("--------------------------------------------");
	      repository.findByLastName("Bauer").forEach(bauer -> {
	        System.out.println(bauer.toString());
	      });
	      System.out.println("");
	    };
	  }
}
