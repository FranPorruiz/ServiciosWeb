package init.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
//este metodo nos dice que que siempre va a haber una respuesta

import init.service.interfaces.VehiculoServices;
import init.model.Vehiculo;

@CrossOrigin("*")//nos permite llamadas desde cualquier origen
@RestController
public class VehiculosController {
	
	@Autowired
	VehiculoServices vs;
	
	@GetMapping(value="rangoKM", produces="application/json")
	public List<Vehiculo> rangoKM(@RequestParam("km1") int km1,
								@RequestParam("km2") int km2){
		 return vs.rangoKM(km1, km2);
		
	}
	
	@GetMapping(value="precioMax", produces="application/json")
	public List<Vehiculo> precioMax(@RequestParam("preciomax") double precioMax){
		 return vs.precioMax(precioMax) ;
		
	}
	
	

}
