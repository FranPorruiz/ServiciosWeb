package init.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import init.exceptions.CursoExistenteException;
import init.model.Curso;
import init.service.interfaces.CursosService;

//este metodo nos dice que que siempre va a haber una respuesta
@RestController
public class CursoController {
	//con esto inyectamos la interfaz service
	@Autowired
	CursosService cs;
	
	//metodo para recoger todos los cursos
	@GetMapping(value="cursos", produces="application/json")
	public ResponseEntity<List<Curso>> buscarTodos(){
		 return  new ResponseEntity<>(cs.busquedaTodos(), HttpStatus.OK);
	}

	//metodo para recoger por id
	@GetMapping(value="curso", produces="application/json")
	public ResponseEntity<Curso> buscarPorId(@RequestParam("id")int id){
		
		Curso curso=cs.busquedaPorId(id);
		
		if(curso!=null) {
			return new ResponseEntity<>(curso,HttpStatus.OK);
		}
		return  new ResponseEntity<>(curso, HttpStatus.NOT_FOUND) ;
	} 
	
	//metodo para recoger por tango de precios
	//le incluimos las Path Variables para que pase la informacion por url
	@GetMapping(value="rango/{min}/{max}", produces="application/json")
	public ResponseEntity<List<Curso>>buscarTodos(@PathVariable("min")int precio1, @PathVariable("max")int precio2 ){
		 return new ResponseEntity<>( cs.busquedaPorRango(precio1, precio2), HttpStatus.OK);
	}
	
	//metodo para dar de alta a traves de JSON
	@PostMapping(value="alta", consumes="application/json")
	public ResponseEntity<Void> altaCurso(@RequestBody Curso curso ) throws CursoExistenteException {
			  return new ResponseEntity(HttpStatus.OK);
		
	}
	
	//eliminar por denominacion
	@DeleteMapping(value="eliminar", produces="application/json")
	public  ResponseEntity<Curso> eliminar (@RequestParam("denominacion") String denominacion){
		return new ResponseEntity<>(cs.borrarCurso(denominacion), HttpStatus.OK);
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
