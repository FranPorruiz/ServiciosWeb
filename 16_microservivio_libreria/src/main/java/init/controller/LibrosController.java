package init.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import init.model.Libro;
import init.service.interfaces.LibrosService;

//este metodo nos dice que que siempre va a haber una respuesta
@RestController
public class LibrosController {
	@Autowired
	LibrosService ls;
	
	//Acceso libre
	@GetMapping(value="catalogo", produces="application/json")
	public ResponseEntity<List<Libro>> catalogo(){
		return new ResponseEntity<>(ls.catalogo(), HttpStatus.OK);
		
	}
	
	
	//lista de tematicas->acceso libre
	
	//buscador de libros por ISBN->Administrativo
	
	//alta de nuevos libros->rol administrativo


}
