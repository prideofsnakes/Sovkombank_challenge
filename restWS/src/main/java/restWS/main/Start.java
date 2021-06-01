package restWS.main;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class Start {
	public static void main(String[] args) {
		SpringApplication.run(Start.class, args);
	}
	
	
	  @Bean
	  public CommandLineRunner demo(H2PhoneRepository repository) {
	    return (args) -> {
		        // save a few H2Users
		    	repository.save(new H2Phone("101", 1));
		    	repository.save(new H2Phone("102", 2));
		    	repository.save(new H2Phone("103", 3));
		    	repository.save(new H2Phone("104", 4));
		    	repository.save(new H2Phone("105", 5));
			
			    // fetch all H2Users
			    System.out.println("H2Users found with findAll():");
			    System.out.println("-------------------------------");
			    for (H2Phone h2 : repository.findAll()) {
			      System.out.println("User Phone: "+ h2.getPhone());
			    }
			    System.out.println("");
			
			    // fetch an individual H2User by ID
			    H2Phone H2Phone = repository.getById(1L);
			    System.out.println("H2Phone found with getById(1L):");
			    System.out.println("--------------------------------");
			    System.out.println(H2Phone.getPhone());
			    System.out.println("");

	    };
	  }
}
