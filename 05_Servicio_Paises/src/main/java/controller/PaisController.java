package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import model.Pais;
import service.interfaces.PaisService;
@CrossOrigin("*")
@RestController
public class PaisController {
	@Autowired
	PaisService ps;
	
	@GetMapping(value="continentes", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<String> continentes(){
		return ps.listaContinentes();
	}
	
	@GetMapping(value="paises/{continente}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Pais> paises(@PathVariable("continente")String continente){
		return ps.paisesPorContinente(continente);
	}
	
	@GetMapping(value="max", produces=MediaType.APPLICATION_JSON_VALUE)
	public Pais masHabitado(){
		return ps.masHabitado();
	}
	
	
}
