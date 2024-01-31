package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.Cliente;
import service.interfaces.ClienteService;
import service.interfaces.LibrosService;

public class ClienteController {
	@Autowired
	ClienteService cs;
	
	@Autowired
	LibrosService ls;
	
	@PostMapping(value="alta")
	public String alta(@RequestParam("clienteNuevo") String nombreNuevo,
			@RequestParam("passwordNuevo") String passwordNuevo,
			@RequestParam("emailNuevo") String emailNuevo,
			@RequestParam("telefonoNuevo") int telefonoNuevo,
			Model model) 
			{
		Cliente nuevoCliente=new Cliente(0,nombreNuevo, passwordNuevo, emailNuevo, telefonoNuevo);
		cs.altaCliente(nuevoCliente);
		if(!cs.altaCliente(nuevoCliente)) {
			model.addAttribute("mensajeAlta", "Se ha generado un usuario nuevo");
			return "inicio";
		}
		model.addAttribute("temas", ls.getTemas());
		return "visor";
	}

	@GetMapping(value="autenticar")
	public String  autenticar(@RequestParam("usuarioCliente") String usuarioCliente,
			@RequestParam("passwordCliente") String passwordCliente, Model model) {
			if(cs.autenticar(usuarioCliente, passwordCliente)!=null) {
				model.addAttribute("mensajeAcceso", "Ha iniciado la sesión correctamente");
				return "inicio";
				
			}
		model.addAttribute("mensajeAcceso", "Usuario o password incorrectos");
	
		return "visor";	
		
	}
	
	

}
