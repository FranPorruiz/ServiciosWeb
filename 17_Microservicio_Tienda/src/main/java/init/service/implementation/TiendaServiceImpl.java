package init.service.implementation;

import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import init.model.Libro;
import init.service.interfaces.TiendaService;

@Service
public class TiendaServiceImpl implements TiendaService {

	@Autowired
	RestClient restClient;//esto nos va llamar a los metodos
	
	  String urlBase="http://localhost:8600/";
	  
	@Value("${app.user}")
	String usuario;//usuario para  y password para pasarse
	@Value("${app.pass}") 
	String pass;

	@Override
	public List<String> listaTematicas() {
		return  Arrays.asList(restClient.get().
				uri(urlBase+"tematicas")
				.retrieve()
				.body(String[].class)
	
				);
	}

	@Override
	public List<Libro> busquedaPorTematica(String tematica) {
		
		return todos().
				stream().
				filter(l->l.getTematica().equals(tematica)).
				toList()
				;
	}
	
	//metodo para recogerlos todos
	private List<Libro> todos(){
		return  Arrays.asList(restClient.get().
				uri(urlBase+"catalogo")
				.header("Authorization", "Basic "+getBase64(usuario, pass))
				.retrieve()
				.body(Libro[].class)
				);	
	
	}
	
	private String getBase64(String us, String pwd) {
		String cadena=us+":"+pwd;
		return Base64.getEncoder().encodeToString(cadena.getBytes());
		//este metodo convierte a base64, del stirng cogemos los bytes que a su vez se convertira en Stringpor encode
		
	}

}
