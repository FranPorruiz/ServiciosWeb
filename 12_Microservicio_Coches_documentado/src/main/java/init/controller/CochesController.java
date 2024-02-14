package init.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import init.model.Coche;
import init.service.interfaces.CochesService;

//este metodo nos dice que que siempre va a haber una respuesta
@CrossOrigin("*")//nos permite llamadas desde cualquier origen
@RestController
public class CochesController {
	
	@Autowired
	CochesService cochesService;
	
	@PostMapping(value="alta", consumes="application/json")
	public void alta(@RequestBody Coche coche) {
		cochesService.altaCoche(coche);
			
		
	}
	
	@DeleteMapping(value="eliminar", produces="application/json")
	public void eliminar( @RequestParam("matricula") String matricula) {
		cochesService.borrarCoche(matricula);
		
	}
	
	@Operation(summary="Busqueda por marca", description="Devuelve un JSON con los datos del coche cuya matrícula")
	@GetMapping(value="buscarMarca", produces="application/json")
	public List<Coche> buscarporMarca(@Parameter(description="Marca de los coches buscados") @RequestParam("marca") String marca){
		return cochesService.buscarPorMarca(marca);
	}
	
	@GetMapping(value="buscarMax", produces="application/json")
	public List<Coche> buscarMax(@RequestParam("max") double  max){
		return cochesService.buscarPrecioMax(max);
	}
	
	@GetMapping(value="todos", produces="application/json")
	public List<Coche> todos(){
		return cochesService.todos();
	}
	
	@PutMapping(value="actualizar", consumes="application/json",produces="application/json")
	public void altaCoche(@RequestBody Coche coche) {
		cochesService.actualizarCoche(coche);
		
	}

}
