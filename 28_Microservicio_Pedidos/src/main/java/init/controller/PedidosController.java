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

import init.model.Pedido;

import init.service.interfaces.PedidosService;

//este metodo nos dice que que siempre va a haber una respuesta
@RestController
public class PedidosController {
	
	/*
	Peticion post, recibe los datos del pedido(JSON)
	 comunica a al servicio de productos para actualizar el stock
	Recurso get que devuelva todos los pedidos registrados
	*/
	@Autowired
	PedidosService ps;
	
	@PutMapping(value="actualizarPedido")
	public ResponseEntity<Void> actualizar(@RequestBody Pedido pedido ) {
		ps.actualizarStock(pedido);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@GetMapping(value="pedidos",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity <List<Pedido>> productos(){
		return  new ResponseEntity<>(ps.pedidos(),HttpStatus.OK);

	}
	

}
