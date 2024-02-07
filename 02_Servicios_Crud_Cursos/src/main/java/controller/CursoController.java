package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import model.Curso;
import service.interfaces.CursosService;

//este metodo nos dice que que siempre va a haber una respuesta
@RestController
public class CursoController {
	//con esto inyectamos la interfaz service
	@Autowired
	CursosService cs;
	
	//metodo para recoger todos los cursos
	@GetMapping(value="cursos", produces="application/json")
	public List<Curso> buscarTodos(){
		 return cs.busquedaTodos();
	}

	//metodo para recoger por id
	@GetMapping(value="curso", produces="application/json")
	public Curso buscarPorId(@RequestParam("id")int id){
		return cs.busquedaPorId(id);
	} 
	
	//metodo para recoger por tango de precios
	//le incluimos las Path Variables para que pase la informacion por url
	@GetMapping(value="rango/{min}/{max}", produces="application/json")
	public List<Curso> buscarTodos(@PathVariable("min")int precio1, @PathVariable("max")int precio2 ){
		 return cs.busquedaPorRango(precio1, precio2);
	}
	
	//metodo para dar de alta a traves de JSON
	@PostMapping(value="alta", consumes="application/json")
	public void altaCurso(@RequestBody Curso curso ) {
		cs.altaCurso(curso);
		
	}
	
	//eliminar por denominacion
	@DeleteMapping(value="eliminar", produces="application/json")
	public Curso eliminar (@RequestParam("denominacion") String denominacion){
		return cs.borrarCurso(denominacion);
	}

	//actualizacion por precios
	//no recibe o emite JSOn,m por lo que no se pone consumes o produces
	@PutMapping(value="actualizarPrecio")
	public void actualizarPrecio(@RequestParam("denominacion") String denominacion,@RequestParam("precio") int precio ) {
		cs.actualizacionPrecios(denominacion, precio);	
	}	

	//precios por tematica
	@GetMapping(value="buscarporPrecios", produces="application/json")
	public List<Curso> mostrarPrecios(@RequestParam("denominacion") String denominacion){
		
		return cs.mostrarPrecios(denominacion);
	}
	
}
