package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.Resultado;
import service.interfaces.BuscadorService;

@Controller
public class BuscadorController {
	//con esto inyectamos la interfaz service
	@Autowired
	BuscadorService buscadorService;
	//el value es la direccion que nos va a llamar desde  la vista, el 
	//request parameter nos recoge el valor desde el front
	//el model es un objeto con cosas que le queremos pasar a la vista
	@GetMapping(value="buscar")
	public String buscar(@RequestParam("tematica")String tematica, Model model){
		List<Resultado> resultados=buscadorService.buscar(tematica);
		//esto equivale al request set attribute
		//le añade al modeloel arributo
		model.addAttribute("resultados", resultados);
		
		//le devolvemos la pagina
		return "resultados";
	}
	
	
	@PostMapping(value="registrar")
	public String registrar(@RequestParam("url")String url,
							@RequestParam("tematica")String tematica,
							@RequestParam("description")String description,
							Model model) {
		//al nuevo objeto que vamos a meter en la arraylist le pasamos los parametros desde arriba
		Resultado nuevoResultado=new Resultado(url, 
								tematica,
								description);
		buscadorService.agregarPagina(nuevoResultado);
		
		
		return "menu";
	}
	//la inyeccion del modelattribute te envia el objeto
	@PostMapping(value="registrarModel")
	public String registrar(@ModelAttribute Resultado nuevoResultado) {
		//al nuevo objeto que vamos a meter en la arraylist le pasamos los parametros desde arriba
		buscadorService.agregarPagina(nuevoResultado);
		return "menu";
	}
}
