package services.implementation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import model.Pais;
import service.interfaces.PaisService;

@Service
public class PaisServiceImp implements PaisService {
	
	@Autowired
	RestClient restClient;//esto nos va llamar a los metodos
	
	String url="https://restcountries.com/v2/all/";
	
	
	public List<Pais> todos() {
		
		return Arrays.asList(restClient.get()//usamos el metodo get de restClient
				.uri(url)//la url arriba mas el metodo que recoge los cursos
				.retrieve()//esto nos devuelve objetos de tipos response
				.body(Pais[].class)//lo que nos devuelve son objetos de la clase Formacion
				//lo que se devuelve una lista asi que lo convertimos a Arrays
				);
	}

	@Override
	public List<String> listaContinentes() {
		List<String> continentes=new ArrayList<String>();
		for (Pais pais : todos()) {
			continentes.add(pais.getContinente());
		}
		continentes=continentes.stream()
                .distinct()
                .collect(Collectors.toList());
		return continentes;
		//Con funcional
		//todos().stream().map(p->p.getContinente()).distinct().toList()
	}

	@Override
	public List<Pais> paisesPorContinente(String continente) {
		return todos().
				stream().
				filter(p->p.getContinente().equals(continente)).
				toList();
	}

	@Override
	public Pais masHabitado() {
		Pais max=todos().get(0);
		for (Pais pais : todos()) {
			if(pais.getPoblacion()>max.getPoblacion()) {
				max=pais;
			}
		}
		//funcional
		//todos().stream().max(Comparator.comparingLong(p->p.getPoblacion())).orElse(null)
		
		return max;
	}

}
