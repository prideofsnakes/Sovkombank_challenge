package restWS.main;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PhoneController {
	private final H2PhoneRepository repo;
	
	PhoneController(H2PhoneRepository repo){
		this.repo = repo;
	}
	
	@GetMapping("/api/v1/phones/{id}")
	public H2Phone getPhoneByUserId(@PathVariable long id) {
		if (id > repo.count()) throw new PhoneNotFoundException(id);
		H2Phone phone = repo.getById(id);
		return phone;
	}
}
