package wsdlWS;

import java.util.Scanner;

import org.apache.commons.codec.binary.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import starter_kit.Start;

@SpringBootApplication
public class Execution {
	public static void main(String[] args) {
		Start.main(args);
		SpringApplication.run(Execution.class, args);
		//test request
//		String content = "<x:Envelope xmlns:x=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:gen=\"http://hilariousstartups.ru/soap/gen\">\r\n"
//				+ "    <x:Header/>\r\n"
//				+ "    <x:Body>\r\n"
//				+ "        <gen:getUserRequest>\r\n"
//				+ "            <gen:userId>2</gen:userId>\r\n"
//				+ "        </gen:getUserRequest>\r\n"
//				+ "    </x:Body>\r\n"
//				+ "</x:Envelope>";
//		
//		HttpPost httpPost = new HttpPost(System.getenv().get("ws.endpoint"));
//		httpPost.addHeader("Content-Type", "text/xml; charset=utf-8");
//		DefaultHttpClient client = new DefaultHttpClient();
//		
//		try {
//			StringEntity input = new StringEntity(content);
//			httpPost.setEntity(input);
//			
//			HttpResponse resp = client.execute(httpPost);
//			Scanner s = new Scanner(resp.getEntity().getContent()).useDelimiter("\\A");
//			String result = s.hasNext() ? s.next() : "";
//			System.out.println(result);
//		}
//		
//		catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
//		client.getConnectionManager().shutdown();
}
}