package service.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
//Con ComponentScan le decimos los paquetes que se van a implementar
@ComponentScan(basePackages = {"service.implementation"})
@Configuration
public class ServiceConfig {

}
