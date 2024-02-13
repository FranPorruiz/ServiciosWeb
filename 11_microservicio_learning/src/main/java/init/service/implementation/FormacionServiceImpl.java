package init.service.implementation;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClient;

import init.model.Formacion;
import init.service.interfaces.FormacionService;

@Service
public class FormacionServiceImpl implements FormacionService {
	@Autowired
	RestClient restClient;//esto nos va llamar a los metodos
	
	String urlBase="http://localhost:8500/";
	

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
	public void altaFormacion(Formacion formacion) {
		try {
		restClient.post().//usando el restclient llamamos al metodo de envio
		uri(urlBase+"alta").//le pasamos la url basica y nuestro metodo
		contentType(MediaType.APPLICATION_JSON).//le pasamos el JSon SIN el value, porque el value es una cadena de caracteres
		body(formacion).//le pasamos el objeto
		retrieve(). //retrieve para enviar la peticion
		toBodilessEntity(); //response entity <void>
		}catch(HttpClientErrorException ex) {
			//tratamiento del error
			}	
		}
	
	
}
