package h2db;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.PathResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.SimpleWsdl11Definition;


@EnableWs
@EnableJpaRepositories
@Configuration
@ComponentScan("wsdlWS")
public class SpringConfiguration {

	  
		@Bean
		public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext applicationContext) {
			MessageDispatcherServlet servlet = new MessageDispatcherServlet();
			servlet.setApplicationContext(applicationContext);
			servlet.setTransformWsdlLocations(true);
			return new ServletRegistrationBean<>(servlet, "/ws/*");
		}

		@Bean(name = "users")
		public SimpleWsdl11Definition defaultWsdl11Definition() {
			SimpleWsdl11Definition wsdl11Definition = new SimpleWsdl11Definition();
			PathResource pth = new PathResource("");
			wsdl11Definition.setWsdl(pth);
			return wsdl11Definition;
		}
}
