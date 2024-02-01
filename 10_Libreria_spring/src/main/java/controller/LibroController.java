package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Libro;
import model.Tema;
import service.interfaces.LibrosService;

@Controller
public class LibroController {
	@Autowired
	LibrosService ls;
	
	static List<Libro> carrito=new ArrayList<>();
	
	//filrar por categoria
	@GetMapping(value="buscarCategoria")
	public @ResponseBody List<Libro> busquedaTema(@RequestParam("idTema") int idTema){
		return ls.librosTema(idTema);
	}
	
	//agregar al carrito
	//podemos usar los HTP Session como parametro para guardar atributos
	@GetMapping(value="agregarCarrito")
	public  @ResponseBody List<Libro> agregarCarrito(@RequestParam("isbn") int isbn, HttpSession session) {
		if(session.getAttribute("carrito")!=null) {
			carrito=(List<Libro>) session.getAttribute("carrito");
		}
		carrito.add(ls.getLibro(isbn));
		session.setAttribute("carrito", carrito);
		return carrito;
	
	}
	
	//quitar del carrito
	//podemos usar los HTP Session como parametro para guardar atributos
	@GetMapping(value="borrarCarrito")
	public  @ResponseBody List<Libro> quitarCarrito(@RequestParam("pos") int pos, HttpSession session) {
		if(session.getAttribute("carrito")!=null) {
			carrito=(List<Libro>) session.getAttribute("carrito");
			carrito.remove(pos);
		}
	
		session.setAttribute("carrito", carrito);
		return carrito;
	}	
	

}
