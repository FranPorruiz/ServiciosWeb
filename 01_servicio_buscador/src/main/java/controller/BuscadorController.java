package controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import model.Resultado;
import service.interfaces.BuscadorService;
//este metodo nos dice que que siempre va a haber una respuesta
@RestController
public class BuscadorController {
	//con esto inyectamos la interfaz service
	@Autowired
	BuscadorService buscadorService;
	//el value es la direccion que nos va a llamar desde  la vista, el 
	//request parameter nos recoge el valor desde el front
	//el model es un objeto con cosas que le queremos pasar a la vista
	//recogemos la tematica y le devolmeos la lista de resultados
	//a esto se le llama recurso
	@GetMapping(value="buscar", produces="application/json")
	public List<Resultado> buscar(@RequestParam("tematica")String tematica){
		return buscadorService.buscar(tematica);
	}
	
	
	
	//el produces para indicar que el tipo de cuerpo de la respuesta es json
	//consumes, es el tipo de de cuerpo de la peticion
	//a esto se le llama recurso

	@PostMapping(value="registrar", consumes="application/json")
	public void registrar(@RequestBody Resultado resultado ) {
		buscadorService.agregarPagina(resultado);
		
	}
	
}
