package restWS.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PhoneController {
	private final H2PhoneRepository repo;
	
	PhoneController(H2PhoneRepository repo){
		this.repo = repo;
	}
	
	@GetMapping("/api/v1/phones/{userid}")
	public Map<String, Object> getPriorityPhoneByUserId(@PathVariable long userid) {
		List<String> phones = new ArrayList<String>();
		Map<String, Object> res = new HashMap<String, Object>();
		//if userid doesnt exist in h2user-entity -- return empty list
		if (repo.getAllByuserid(userid).size() > 0) {
			//get all phones by userid
			List<H2Phone> h2phones = repo.getAllByuserid(userid);
			//collect phonenumbers to list
			for (H2Phone h2phone : h2phones) {
				System.out.println("Added phone: "+h2phone.getPhone());
				phones.add(h2phone.getPhone());
			}
		}
		res.put("phones", phones);
		return res;
	}
}
