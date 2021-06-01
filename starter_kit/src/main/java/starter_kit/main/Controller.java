package starter_kit.main;

import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	@GetMapping("/user/{id}")
	public int getUser(@PathVariable int id) {
		getUserSOAP(id);
		return 1;
	}
	
	private void getUserSOAP(int id) {
		
       	   String content = 
	           "<x:Envelope xmlns:x=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:gen=\"http://hilariousstartups.ru/soap/gen\">\r\n"
	           + "    <x:Header/>\r\n"
	           + "    <x:Body>\r\n"
	           + "        <gen:getUserRequest>\r\n"
	           + "            <gen:userId>"+id+"</gen:userId>\r\n"
	           + "        </gen:getUserRequest>\r\n"
	           + "    </x:Body>\r\n"
	           + "</x:Envelope>";
	       // Create the POST object and add the parameters
	       HttpPost httpPost = new HttpPost("http://localhost:8091/ws/");//"http://192.168.9.6:12080/d21778203/ws/SchedulePort"
	       httpPost.addHeader("Content-Type", "text/xml; charset=utf-8");
	  
	       try {
		       DefaultHttpClient httpClient = new DefaultHttpClient();
		       
		       StringEntity input = new StringEntity(content);
		       httpPost.setEntity(input);   
		       HttpResponse response = httpClient.execute(httpPost);
//		       HttpEntity entity = response.getEntity();
//		       String responseString = EntityUtils.toString(entity, "UTF-8");
//		       System.out.println(responseString);
		       Map<String, String> userCredentials = new SaxParser().parseUser(response);
		       System.out.println(userCredentials.toString());
	       }
	       
	       catch (Exception e) {
	    	   System.out.println(e.getMessage());
	       }
	}
	
	private void getPhoneREST() {
		
	}
}
