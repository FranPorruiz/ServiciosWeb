package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
		return "inicio";
	}
	
	@GetMapping(value="buscar")
	public String buscar(@RequestParam("categoria") String categoria,Model model) {
		List<Producto> resultados=ps.buscar(categoria);
		model.addAttribute("resultados", resultados); //equivale al request.setAttribute(...)
		return "resultados"; //nombre de la página a la que debe dirigirnos el FrontController
	}
	
	@PostMapping(value="modificar")
	public String modificar(@RequestParam("nombre") String nombre, @RequestParam("nuevoPrecio") double nuevoPrecio) {
		ps.modificar(nombre, nuevoPrecio);;
		return "inicio";
	}
	
	@PostMapping(value="borrar")
	public String borrar(@RequestParam("nombre") String nombre,Model model) {
		ps.borrar(nombre);;
		return "inicio";
	}
	
	
	

}
