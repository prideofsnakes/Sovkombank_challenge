package restWS.main;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;


@ControllerAdvice
public class ControllerAdvicer {
	  @ResponseBody
	  @ExceptionHandler(PhoneNotFoundException.class)
	  @ResponseStatus(HttpStatus.NOT_FOUND)
	  Map<String, String> employeeNotFoundHandler(PhoneNotFoundException ex) {
		Map<String, String> res = new HashMap<String, String>();
		res.put("error", ex.getMessage());
	    return res;
	  }
}
