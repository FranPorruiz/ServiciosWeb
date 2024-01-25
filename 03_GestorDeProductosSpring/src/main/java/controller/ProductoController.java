package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.Producto;
import service.interfaces.ProductosService;

@Controller
public class ProductoController {
	//con esto inyectamos la interfaz service
	@Autowired
	ProductosService ps;
	
	@GetMapping(value="buscar")
	public String buscar (@RequestParam("categoria")String categoria, Model model) {
		List<Producto> resultados=ps.buscarProducto(categoria);
		model.addAttribute("resultados", resultados);
		return "resultados";
		
	}
	

}
