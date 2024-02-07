package controller.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//enambleWebMc apporta funciones, configuration define a la clase
import org.springframework.web.servlet.view.InternalResourceViewResolver;


@ComponentScan(basePackages= {"controller"})
@EnableWebMvc
@Configuration
public class MvcConfig{
	//vaciamos la vista
	
	
	
	

}
