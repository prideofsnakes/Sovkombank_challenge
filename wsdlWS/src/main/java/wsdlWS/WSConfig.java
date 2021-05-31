package wsdlWS;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.PathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.ws.wsdl.wsdl11.SimpleWsdl11Definition;

import ru.hilariousstartups.soap.gen.Gender;

//@EnableWs
//@Configuration
public class WSConfig {
//	@Bean
//	public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext applicationContext) {
//		MessageDispatcherServlet servlet = new MessageDispatcherServlet();
//		servlet.setApplicationContext(applicationContext);
//		servlet.setTransformWsdlLocations(true);
//		return new ServletRegistrationBean<>(servlet, "/ws/*");
//	}
//
//	@Bean(name = "users")
//	public SimpleWsdl11Definition defaultWsdl11Definition() {
//		SimpleWsdl11Definition wsdl11Definition = new SimpleWsdl11Definition();
//		wsdl11Definition.setWsdl(new PathResource("").createRelative("soapService.wsdl"));
//		return wsdl11Definition;
//	}
	
}
