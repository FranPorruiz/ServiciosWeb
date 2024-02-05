package controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import dtos.ClienteDto;
import dtos.LibroDto;
import dtos.VentaDto;
import jakarta.servlet.http.HttpSession;
import model.Cliente;
import model.Libro;
import service.interfaces.ClientesService;
import service.interfaces.LibrosService;

@Controller
public class LibreriaController {
	@Autowired
	LibrosService librosService;
	@Autowired
	ClientesService clientesService;
	
	@PostMapping(value="alta")
	public String altaCliente(@ModelAttribute ClienteDto cliente, Model model) {
		if(!clientesService.altaCliente(cliente)) {
			model.addAttribute("mensaje","Usuario repetido, no se pudo registrar");
			return "nuevo";
		}
		return "login";
	}
	@GetMapping(value="login")
	public String login(@RequestParam("usuario") String usuario,
			@RequestParam("password") String password, Model model,
			HttpSession sesion) {
		
		if(clientesService.autenticarCliente(usuario, password)==null) {
			model.addAttribute("mensaje", "Usuario no existente, registrese");
			return "login";
		}
		model.addAttribute("temas", librosService.getTemasDto());
		//guardamos el cliente completo en un atributo de sesión
		sesion.setAttribute("cliente", clientesService.autenticarCliente(usuario, password));
		
		return "menu";
	}
	
	@GetMapping(value="compras")
	public String mostrarCompras( Model model, HttpSession sesion) {
		ClienteDto cltDTO=clientesService.encontrarCliente(sesion.getAttribute("usuario").toString());

		model.addAttribute("compras", librosService.informeVentasDto(cltDTO));

		return "compras";
	}
	/*
	@GetMapping(value="ventas")
	public String ventas(HttpSession sesion, Model model) {
		ClienteDto dto=(ClienteDto)sesion.getAttribute("cliente");
		model.addAttribute("ventas",ventasService.informeVentasCliente(dto.getUsuario()));
		return "ventas";
	}
	*/
	
	
	@GetMapping(value="libros",produces="application/json")
	public @ResponseBody List<LibroDto> librosTema(@RequestParam("idTema") int idTema){
		return librosService.librosTema(idTema);
	}
	@GetMapping(value="agregarCarrito",produces="application/json")
	public @ResponseBody List<LibroDto> agregarCarrito(@RequestParam("isbn") int isbn,HttpSession sesion){
		LibroDto libro=librosService.getLibroDto(isbn);
		List<LibroDto> carrito=new ArrayList<>();
		if(sesion.getAttribute("carrito")!=null) {
				carrito=(List<LibroDto>)sesion.getAttribute("carrito");
		}
		carrito.add(libro);
		sesion.setAttribute("carrito", carrito);
		return carrito;
	}
	@GetMapping(value="quitarCarrito",produces="application/json")
	public @ResponseBody List<LibroDto> quitarCarrito(@RequestParam("pos") int pos,HttpSession sesion){
		List<LibroDto> carrito=new ArrayList<>();
		if(sesion.getAttribute("carrito")!=null) {
				carrito=(List<LibroDto>)sesion.getAttribute("carrito");
				carrito.remove(pos);
		}
		
		sesion.setAttribute("carrito", carrito);
		return carrito;
	}
	
}
