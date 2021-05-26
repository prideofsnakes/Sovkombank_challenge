package starter_kit;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Start {
	
	public static void main(String args[]) {
		SpringApplication app = new SpringApplication(Start.class);
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("server.port", "8083");
		app.setDefaultProperties(m);
		
		app.run(args);
	}
}
