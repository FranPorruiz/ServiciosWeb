package init;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		
		
	}
	
	//los metodos Bean son metodos de conffiguracion que Spirng inicia cuando se genera el progta,a
			//esto nos genera un objeto RestClient al inicio
			//lo generamos aqui porque lo esá usando el SErvice 
			@Bean
			public RestClient getClient() {
				return RestClient.create();
			}

}
