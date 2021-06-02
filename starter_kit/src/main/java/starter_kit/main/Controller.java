package starter_kit.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Controller {
	private final String URLSOAP = "http://localhost:8091/ws/";
	private final String URLREST = "http://localhost:8090/api/v1/phones/";
	
	@GetMapping("/user/{id}")
	public Map<String, Object> getUser(@PathVariable int id) {
		
		Map<String, Object> result = new HashMap<String, Object>();
		List<Thread> threadls = new ArrayList<Thread>();
		//multithreading
		try {
			threadls.add(new Thread(new Runnable() {
	
				@Override
				public void run() {
					// TODO Auto-generated method stub
					Map<String, Object> phones = getPhoneREST(id);
					System.out.println(phones.toString());
					String[] phoneArr = (String[]) phones.get("phones");
					if (phoneArr.length > 0) result.put("phone", phoneArr[0]);
					else result.put("phone", "");
					System.out.println("Thread REST is over.");
				}
				
			}));
	
			threadls.add(new Thread(new Runnable() {
	
				@Override
				public void run() {
					// TODO Auto-generated method stub
					Map<String, String> userCredentials = getUserSOAP(id);
					//is ok case
					if (userCredentials.containsKey("firstName") && userCredentials.containsKey("lastName")) {
						result.put("name", userCredentials.get("firstName") + " " + userCredentials.get("lastName"));
						result.put("code", 0);
					}
					else result.put("code", 2);
					System.out.println("Thread WSDL is over.");
				}
				
			}));
			for (Thread thread : threadls) {
				thread.start();
				System.out.println("Thread #"+threadls.indexOf(thread)+" is started...");
			}
			
			for (Thread thread : threadls) {
				thread.join();
				System.out.println("Thread #"+threadls.indexOf(thread)+" has been joined to general thread.");
			}
		
		}
		
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}
	
	private Map<String, String> getUserSOAP(int id) {
		//request body
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
	       HttpPost httpPost = new HttpPost(URLSOAP);
	       httpPost.addHeader("Content-Type", "text/xml; charset=utf-8");
	       DefaultHttpClient httpClient = new DefaultHttpClient();
	       
	       try {
		       
		       
		       StringEntity input = new StringEntity(content);
		       httpPost.setEntity(input);   
		       HttpResponse response = httpClient.execute(httpPost);

		       Map<String, String> userCredentials = new SaxParser().parseUser(response);
		       System.out.println(userCredentials.toString());
		       httpClient.getConnectionManager().shutdown();
		       
		       return userCredentials;
		       
		       
	       }
	       
	       catch (Exception e) {
	    	   System.out.println(e.getMessage());
	    	   return new HashMap<String, String>();
	       }
	       
	}
	
	private Map<String, Object> getPhoneREST(int id) {
		Map<String, Object> result = new HashMap<String, Object>();
		//open connection
		DefaultHttpClient httpClient = new DefaultHttpClient();
		try {
			//get request
			HttpGet httpGet = new HttpGet(URLREST+id);
			HttpResponse response = httpClient.execute(httpGet);
			//parse response
		       HttpEntity entity = response.getEntity();
		       String responseString = EntityUtils.toString(entity, "UTF-8").replace("\"", "");
		       int colonInd = responseString.indexOf(":");
		       int startArrInd = responseString.indexOf("[");
		       int endArrInd = responseString.indexOf("]");
		       String mapKey = responseString.substring(1, colonInd);
		       String phones = responseString.substring(startArrInd+1, endArrInd);
		       if (phones.length() > 0) {
		    	   String[] phoneArr = phones.split(",");
		    	   result.put(mapKey, phoneArr);
		       }
		       else result.put(mapKey, new String[0]);
		       
		}
		
	    catch (Exception e) {
	    	 System.out.println(e.getMessage());
	    }
		httpClient.getConnectionManager().shutdown();
		return result;
	}
}
