package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import modelo.Producto;
import service.interfaces.ProductoService;

@Controller
public class ProductoController {
	@Autowired
	ProductoService ps;
	@PostMapping(value="alta")
	public String alta(@RequestParam("nombreNuevo") String nombreNuevo,
						@RequestParam("categoriaNuevo") String categoriaNuevo,
						@RequestParam("precioNuevo") String precioNuevo,
						Model model) {
		Producto nuevoProducto=new Producto(0,nombreNuevo, Double.parseDouble(precioNuevo), categoriaNuevo);
		ps.altaProducto(nuevoProducto);
		if(!ps.altaProducto(nuevoProducto)) {
			model.addAttribute("mensajeAlta","El producto "+nuevoProducto.getNombreProducto()+"  está repetido. No se añadió a la base de datos.");
		}
		return "inicio";
	}
	
	//gestion con Ajax, tiene que devolver un JSOn con la lista productos
	//@ResponseBody annotation tells a controller that the object returned is automatically serialized into JSON and passed back into the HttpResponse object.
	//@GetMapping(value="buscar", produces="application/json")
	//por si queremos indicarle de forma que nos devuelve algun tipo especifico
	@GetMapping(value="buscar")//por defecto, esot devuelve JSON
	public @ResponseBody List<Producto> buscar(@RequestParam("categoria") String categoria) {
		return ps.buscar(categoria); //nombre de la página a la que debe dirigirnos el FrontController
	}
	
	@PostMapping(value="modificar")
	public String modificar(@RequestParam("nombre") String nombre, @RequestParam("nuevoPrecio") double nuevoPrecio) {
		ps.modificar(nombre, nuevoPrecio);;
		return "inicio";
	}
	
	@PostMapping(value="borrar")
	public String borrar(@RequestParam("nombre") String nombre,Model model) {
		Producto productoBorrado=ps.borrar(nombre);
		if(productoBorrado!=null) {
			model.addAttribute("mensajeEliminar","Se ha eliminado el producto "+nombre+" de la categoría "+productoBorrado.getCategoriaProducto());
		}else {
			model.addAttribute("mensajeEliminar","El producto "+nombre+ " no figura en la base de datos.");
		}
		return "inicio";
	}
	
	
	

}
