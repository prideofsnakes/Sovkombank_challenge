package starter_kit;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Start {
	public static void main(String args[]) {
		SpringApplication.run(Start.class, args);
	}
	
	  @Bean
	  public CommandLineRunner demo(H2PhoneStorage storage) {
	    return (args) -> {
	      // save a few H2PhoneNumbers
	    	storage.save(new H2PhoneNumber("9182734"));
	    	storage.save(new H2PhoneNumber("123848"));
	    	storage.save(new H2PhoneNumber("8139123"));
	    	storage.save(new H2PhoneNumber("39484982"));
	    	storage.save(new H2PhoneNumber("3812312"));

	      // fetch all H2PhoneNumbers
	      System.out.println("H2PhoneNumbers found with findAll():");
	      System.out.println("-------------------------------");
	      for (H2PhoneNumber H2PhoneNumber : storage.findAll()) {
	    	  System.out.println(H2PhoneNumber.getPhoneNumber());
	      }
	      System.out.println("");

	      // fetch an individual H2PhoneNumber by ID
	      H2PhoneNumber H2PhoneNumber = storage.findById(1L);
	      System.out.println("H2PhoneNumber found with findById(1L):");
	      System.out.println("--------------------------------");
	      System.out.println(H2PhoneNumber.getPhoneNumber());
	      System.out.println("");

	      System.out.println("");
	    };
	  }
}
