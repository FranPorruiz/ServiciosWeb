package init;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	// metodo para llamar la lista de usuarios desde BBDD
	@Bean
	public JdbcUserDetailsManager users(){
		//creacion de DataSource
		DriverManagerDataSource ds =new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/springsecurity");
		ds.setUsername("root");
		ds.setPassword("root");
		//esto apunta a la BBDD de la cual spring security sacará la información
		JdbcUserDetailsManager jdbc=new JdbcUserDetailsManager(ds);
		//localizador con sql de usuario
		jdbc.setUsersByUsernameQuery("select user, pwd, enabled from users where user=?");
		//localizar con sql de la tabla de roles
		jdbc.setAuthoritiesByUsernameQuery("select user, rol, form roles where user=?");
		return jdbc;
	}
	//este metodo es que controla los criterios de acceso, recibe un http  que nos permitira controloras
	@Bean
	public SecurityFilterChain filter(HttpSecurity http) throws Exception {
		http.csrf(c->c.disable())//desactivar una configuracion de cookis
		.authorizeHttpRequests(//con esto indicamos que direcciones están protegidas
				aut->aut.
				requestMatchers(HttpMethod.GET, "/curso").authenticated().//direcciones a asecgurar y roles que seane ncesarios en cada caso
				requestMatchers(HttpMethod.GET,"/rango/*/*" ).hasAnyRole("ADMIN").
				requestMatchers(HttpMethod.POST,"/alta" ).hasRole("ADMIN").
				requestMatchers(HttpMethod.DELETE,"/eliminar" ).hasAnyRole("ADMIN", "OPERATORS").
				requestMatchers(HttpMethod.PUT,"/actualizarPrecio" ).hasAnyRole("OPERATORS").
				anyRequest().permitAll()
				)
				.httpBasic(Customizer.withDefaults());//con esto indicamos como e autentiza el cliente


			return http.build();
		
		
	}
	

}
