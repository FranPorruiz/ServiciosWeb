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
public class MvcConfig  implements WebMvcConfigurer{
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
	//el metodo WevcConfigurer es Default, 
	//nosotros vamos a sobreescribirlo, podemos hacerlo con el boton derecho Source, override
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		//estos metodos hacen que nso permite dirigir a paginas estaticas
		registry.addViewController("/").setViewName("menu");
		registry.addViewController("toMenu").setViewName("menu");
		registry.addViewController("toBuscar").setViewName("buscar");
		registry.addViewController("toRegistrar").setViewName("registro");


		
	} 
	
	
	

}
