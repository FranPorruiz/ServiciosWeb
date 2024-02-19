package init.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import init.service.interfaces.ProductoService;
import init.model.Producto;

//este metodo nos dice que que siempre va a haber una respuesta
@RestController
public class ProductoController {
	//con esto inyectamos la interfaz service
	/*
	 * Petiticion Get, devuleve lista de productos
		Peticion put, actualiza el stock dle producto recibiendo por URL{path variable) el codigo de producto y unidades compradas
		peticion get con el codigo de producto que devuelva el preico unitario

	 */
		@Autowired
		ProductoService ps;
		
		@GetMapping(value="productos",produces=MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity <List<Producto>> productos(){
			return  new ResponseEntity<>(ps.listaProducto(),HttpStatus.OK);

		}
		
		@PutMapping(value="actualizar/{idProducto}/{stock}")
		public ResponseEntity<Void> actualizar(@PathVariable("idProducto") int idProducto,@PathVariable("unidades") int stock ) {
			ps.actualizaStock(idProducto, stock);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		
		@GetMapping(value="precio/{idProducto}",produces=MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<String> precioUnitario (@PathVariable int idProducto) {
			return new ResponseEntity<>(ps.precioUnitario(idProducto), HttpStatus.OK);
			
		}
		
		
		
}
