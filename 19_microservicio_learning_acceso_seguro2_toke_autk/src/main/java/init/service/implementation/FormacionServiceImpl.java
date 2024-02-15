package init.service.implementation;

import java.util.Arrays;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClient;

import init.model.Formacion;
import init.model.TokenResponse;
import init.service.interfaces.FormacionService;
import jakarta.annotation.PostConstruct;


@Service
public class FormacionServiceImpl implements FormacionService {
	@Autowired
	RestClient restClient;//esto nos va llamar a los metodos
	@Value("${app.urlAuth}")
	String urlAuth;//usuario para  y password para pasarse
	@Value("${app.username}")
	String username;
	@Value("${app.password}")
	String password;
	@Value("${app.client_id}")
	String clientId;
	@Value("${app.grant_type}")
	String grantType;
	String urlBase="http://localhost:8500/";
	String token;
	
	//al estar anotado con PostCOnstruct el metodo sera llamado cuando la instancia este disponible
	@PostConstruct
	public void init() {
		token=getToken();
	}
	

	

	@Override
	public List<Formacion> catalogo() {
		return Arrays.asList(restClient.get()//usamos el metodo get de restClient
				.uri(urlBase+"cursos")//la url arriba mas el metodo que recoge los cursos
				.retrieve()//esto nos devuelve objetos de tipos response
				.body(Formacion[].class)//lo que nos devuelve son objetos de la clase Formacion
				//lo que se devuelve una lista asi que lo convertimos a Arrays
				);
	}

	@Override
	public List<Formacion> catalogoporDuracionMax(int max) {
		//vamos a filtrar los catalogos y a filtrarlos con programacion funcional
		
		return catalogo().stream().
				filter(f->f.getHoras()<=max).
				toList();
	}

	@Override
	public void alta(Formacion formacion) {
		
	//try {
		restClient.post().//usando el restclient llamamos al metodo de envio
		uri(urlBase+"altaFormacion").//le pasamos la url basica y nuestro metodo
		contentType(MediaType.APPLICATION_JSON).//le pasamos el JSon SIN el value, porque el value es una cadena de caracteres
		body(formacion).//le pasamos el objeto
		header("Authorization", "Bearer"+getToken()).//metodo paraacceder a un servicio desde otro
		retrieve(). //retrieve para enviar la peticion
		toBodilessEntity(); //response entity <void>		
		/*
		}
		catch(Exception ex) {
			//si hay una excepcion porque el token ha caducado
			//lo regeneramos e intentamos el alta de nuevo
			getToken();
			alta(formacion);
		}
		*/
	
	
	
	}
	
	
	//metodo para generar el token
	private String getToken() {
		MultiValueMap<String,String> params=new LinkedMultiValueMap<>();
		params.add("client_id", clientId);
		params.add("username", username);
		params.add("password", password);
		params.add("grant_type", grantType);
		
		return restClient.post()
		.uri(urlAuth)
		.contentType(MediaType.APPLICATION_FORM_URLENCODED)
		.body(params)
		.retrieve()
		.body(TokenResponse.class) //TokenResponse
		.getAcces_token();
	} 
	
	
}
