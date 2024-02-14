package init.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import init.model.Libro;
import init.service.interfaces.TiendaService;

@RestController
public class TiendaController {
	@Autowired
	TiendaService service;
	@GetMapping(value="tematicas", produces=MediaType.APPLICATION_JSON_VALUE)
	public  ResponseEntity <List<String>> tematicas(){
		return new ResponseEntity<>( service.listaTematicas(), HttpStatus.OK);
		
	}

	@GetMapping(value="libros/{tematica}", produces=MediaType.APPLICATION_JSON_VALUE)
	public  ResponseEntity <List<Libro>> librostematicas(@PathVariable("tematica")String tematica){
		return new ResponseEntity<>( service.busquedaPorTematica(tematica), HttpStatus.OK);
		
	}
	
	
}
