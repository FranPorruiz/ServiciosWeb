package init.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import init.exception.LibroExistenteException;
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
	@GetMapping(value="tematicas", produces="application/json")
	public ResponseEntity<List<String>> tematicas(){
		return new ResponseEntity<>(ls.listaTematicas(), HttpStatus.OK);
		
		
	}
	
	//buscador de libros por ISBN->Administrativo
	@GetMapping(value="buscarPorISBN/", produces="application/json")
	public ResponseEntity<Libro> buscarPorISBN(@RequestParam ("isbn") int isbn){
		Libro libro=ls.busquedaPorIsbn(isbn);
		
		if(libro!=null) {
			return new ResponseEntity<>(libro,HttpStatus.OK);
		}
		return new ResponseEntity<>(libro,HttpStatus.NOT_FOUND);
		
	}
	
	
	//alta de nuevos libros->rol administrativo
	@PostMapping(value="alta", consumes="application/json")
	public ResponseEntity<Void> altalibro(@RequestBody Libro libro) throws LibroExistenteException{
		ls.alta(libro);
		return new ResponseEntity<Void>(HttpStatus.OK);
		
	}
	


}
