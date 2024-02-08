package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import model.Formacion;
import service.interfaces.FormacionService;

@RestController
public class FormacionController {
	@Autowired
	FormacionService service;
	@GetMapping(value="catalogo",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Formacion> catalogo(){
		return service.catalogo();
	} 

}
