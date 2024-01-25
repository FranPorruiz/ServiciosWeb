package controller.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//enambleWebMc apporta funciones, configuration define a la clase
import org.springframework.web.servlet.view.InternalResourceViewResolver;


@ComponentScan(basePackages= {"controller"})
@EnableWebMvc
@Configuration
public class MvcConfig {
	//lo siguiente nos define a la bean 
	//los beans se ejecutan automaticamente cuando se ejecuta spring
	@Bean
	public InternalResourceViewResolver getInternalResourceViewResolver() {
	 InternalResourceViewResolver resolver = new InternalResourceViewResolver();
	 //esto nos devuelve las url con un prefijo un sufijo
	 resolver.setPrefix("/");
	 resolver.setSuffix(".jsp");
	 return resolver;
	} 

}
