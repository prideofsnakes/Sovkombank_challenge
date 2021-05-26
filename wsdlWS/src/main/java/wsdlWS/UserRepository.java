package wsdlWS;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import ru.hilariousstartups.soap.gen.Gender;
import ru.hilariousstartups.soap.gen.User;


@Component
public class UserRepository {
	private static final Map<Integer, User> users = new HashMap<>();

	@PostConstruct
	public void initData() {
		User user = new User();
		user.setFirstName("Vasa");
		user.setLastName("Nevasa");
		user.setGender(Gender.MALE);

		users.put(0, user);
	}

	public User findUser(int id) {
		Assert.notNull(id, "The country's name must not be null");
		return users.get(id);
	}
}
