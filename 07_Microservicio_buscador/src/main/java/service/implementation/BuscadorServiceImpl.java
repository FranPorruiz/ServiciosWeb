package service.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import model.Resultado;
import service.interfaces.BuscadorService;
//hemos añadido la anotacion y la hemos importado
@Service
public class BuscadorServiceImpl implements BuscadorService {
	 static List<Resultado> resultados=new ArrayList<>(List.of(
			new Resultado("http://www.fnac.es/","libros","Libros y más"),
			new Resultado("http://www.mybook.com/","libros","librería de temas varios"),			
			new Resultado("http://www.game.es/","juegos","Juegos variados"),
			new Resultado("http://www.music.es/","música","Lamejor música"),
			new Resultado("http://www.tech.com/","libros","Libros técnicos"),
			new Resultado("http://www.eljuego.es/","juegos","Juegos on-line")
			)); 
	

	@Override
	public List<Resultado> buscar(String tematica) {
		//programacion funcional
		return resultados.stream().filter(r->r.getTematica().equals(tematica))
				.toList();
		/*
		 * Mi metodo
		List<Resultado> filtrados=new ArrayList<>();
		for (Resultado resultado : resultados) {
			if (resultado.getTematica().equals(tematica)) {
				filtrados.add(resultado);				
			}*/
		}


	@Override
	public void agregarPagina(Resultado resultado) {
		resultados.add(resultado);
		
	}


	@Override
	public List<Resultado> eliminarResultados(String url) {
		for (Resultado resultado : resultados) {
			if(resultado.getUrl().equals(url)) {
				resultados.remove(resultado);
			}	
		}
		return resultados;
	}

	


	@Override
	public Resultado actualizarDescripcion(String url, String nuevaDescripcion) {
		Resultado resultado=resultados.stream()//te recorre la arrays
				.filter(r->r.getUrl()//te coge y la url del elemento
				.equals(url))//lo compara ocn la url 
				.findFirst()//para coger solo el primero
				.orElse(null);//es un optional, hay que darle otra posibilidad
		if(resultado!=null) {
		//para asegurarnos que no es null
			resultado.setDescription(nuevaDescripcion);
		}
		
		return resultado;
	}
	
	@Override
	public Resultado actualizarDescripcionPorObjeto( Resultado resultado) {
		Resultado resultadoNew=resultados.stream()//te recorre la arrays
				.filter(r->r.getUrl()//te coge y la url del elemento
				.equals(resultado.getUrl()))//lo compara ocn la url 
				.findFirst()//para coger solo el primero
				.orElse(null);//es un optional, hay que darle otra posibilidad
		if(resultado!=null) {
		//para asegurarnos que no es null
			resultadoNew.setDescription(resultado.getDescription());
		}
		
		return resultadoNew;
	}

}




