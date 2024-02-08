package service.implementation;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import model.Formacion;
import service.interfaces.FormacionService;

@Service
public class FormacionServiceImpl implements FormacionService {
	@Autowired
	RestClient restClient;//esto nos va llamar a los metodos
	
	String urlBase="http://localhost:8080/02_Servicios_Crud_Cursos/";
	

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
		
		return null;
	}

	@Override
	public void altaFormacion(Formacion formacion) {
		// TODO Auto-generated method stub
		
	}
	

}
