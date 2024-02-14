package init;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	// metodo creacion de lista de usuarios
	@Bean
	public InMemoryUserDetailsManager users() {
		List<UserDetails> usuarios=List.of(
				User.withUsername("user1").
					password("{noop}user1").//para que no encritpe usamos noop
					roles("USERS"). //los roles se ponen en mayuscula por convencion
					build(),
				User.withUsername("user2").
					password("{noop}user2").
					roles("OPERATORS"). //los roles se ponen en mayuscula por convencion
					build(),
				User.withUsername("admin").
						password("{noop}admin").
						roles("USERS", "ADMIN"). //los roles se ponen en mayuscula por convencion
						build()
					
					);
		return new InMemoryUserDetailsManager(usuarios);//devolvemos la lista
		
	}
	//este metodo es que controla los criterios de acceso, recibe un http  que nos permitira controloras
	@Bean
	public SecurityFilterChain filter(HttpSecurity http) throws Exception {
		http.csrf(c->c.disable())//desactivar una configuracion de cookis
		.authorizeHttpRequests(//con esto indicamos que direcciones están protegidas
				aut->aut.
				requestMatchers(HttpMethod.GET, "/curso").authenticated().//direcciones a asecgurar y roles que seane ncesarios en cada caso
				requestMatchers(HttpMethod.GET,"/cursos/*/*" ).hasAnyRole("OPERATORS").
				requestMatchers(HttpMethod.POST,"/alta" ).hasRole("ADMIN").
				requestMatchers(HttpMethod.DELETE,"/eliminar" ).hasAnyRole("ADMIN", "OPERATORS").
				requestMatchers(HttpMethod.PUT,"/actualizarPrecio" ).hasAnyRole("OPERATORS").
				anyRequest().permitAll()
				)
				.httpBasic(Customizer.withDefaults());//con esto indicamos como e autentiza el cliente


			return http.build();
		
		
	}
	

}
