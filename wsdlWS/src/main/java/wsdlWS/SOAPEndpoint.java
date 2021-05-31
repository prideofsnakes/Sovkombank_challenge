package wsdlWS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import ru.hilariousstartups.soap.gen.Gender;
import ru.hilariousstartups.soap.gen.GetUserRequest;
import ru.hilariousstartups.soap.gen.GetUserResponse;
import ru.hilariousstartups.soap.gen.User;

@Endpoint
@CrossOrigin(origins = "http://localhost:8090")
public class SOAPEndpoint {
	private static final String NAMESPACE_URI = "http://hilariousstartups.ru/soap/gen";
	
	private H2Repository userRepository;

	@Autowired
	public SOAPEndpoint(H2Repository up) {
		this.userRepository = up;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getUserRequest")
	@ResponsePayload
	public GetUserResponse getUser(@RequestPayload GetUserRequest request) {
		GetUserResponse response = new GetUserResponse();
		System.out.println("UR length "+userRepository.count());
//		H2User h2 = userRepository.findById((long)request.getUserId());
//		User user = new User();
//		user.setFirstName(h2.getFirstName());
//		user.setLastName(h2.getLastName());
//		user.setGender(h2.getGender());
		response.setUser(userRepository.findById((long)request.getUserId()));
		if (!response.getUser().equals(null)) System.out.println("Return User "+response.getUser().getFirstName());
		return response;
	}
	
}
