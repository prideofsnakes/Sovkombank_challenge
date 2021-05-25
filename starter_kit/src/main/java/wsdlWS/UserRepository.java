package wsdlWS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import ru.hilariousstartups.soap.gen.Gender;
import ru.hilariousstartups.soap.gen.User;

@Component
public class UserRepository {
	private static final List<User> users = new ArrayList<>();

	@PostConstruct
	public void initData() {
		User user = new User();
		user.setFirstName("Vasya");
		user.setGender(Gender.MALE);
		user.setLastName("Butko");
		
		User user2 = new User();
		user2.setFirstName("Vanya");
		user2.setGender(Gender.MALE);
		user2.setLastName("Ivanov");
		
		User user3 = new User();
		user3.setFirstName("Sveta");
		user3.setGender(Gender.FEMALE);
		user3.setLastName("Sokolova");
		
		users.add(user);
		users.add(user2);
		users.add(user3);
	}
	
	
	public User findUser(int i) {
		return users.get(i);
	}
}
