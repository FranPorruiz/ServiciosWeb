package service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
//Con ComponentScan le decimos los paquetes que se van a implementar
@ComponentScan(basePackages = {"services.implementation"})
@Configuration
public class ServiceConfig {
	//los metodos Bean son metodos de conffiguracion que Spirng inicia cuando se genera el progta,a
	//esto nos genera un objeto RestClient al inicio
	//lo generamos aqui porque lo esá usando el SErvice 
	@Bean
	public RestClient getClient() {
		return RestClient.create();
	}
	
}
