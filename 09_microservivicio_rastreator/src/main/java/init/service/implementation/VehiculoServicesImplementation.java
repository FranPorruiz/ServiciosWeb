package init.service.implementation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import init.model.Vehiculo;
import init.service.interfaces.VehiculoServices;
@Service
public class VehiculoServicesImplementation implements VehiculoServices{
	
	@Autowired
	RestClient restClient;//esto nos va llamar a los metodos
	
	  String urlBase="http://localhost:8000/";

	
	@Override
	public List<Vehiculo> rangoKM(int km1, int km2) {
		List<Vehiculo> intervalo=todos().
				stream().
				peek(v->v.setTipo("coche")).//esto nos permite aplicar cambios 
				filter(v->v.getKm()>km1 && v.getKm()<km2) .
				collect(Collectors.toList());
		
		return intervalo;
	}

	@Override
	public List<Vehiculo> precioMax(double precioMax) {
		List <Vehiculo> maxList=todos()
				.stream()
				.peek(v->v.setTipo("coche"))
				.filter(v->v.getPrecio()<precioMax)
				.collect(Collectors.toList());
		return maxList;
	}
	
	
	//metodo con llamada al metodo ya creado
	private List<Vehiculo> precioMax2(double precioMax){
		
		return Arrays.asList(
				restClient.get()
				.uri(urlBase+"buscarMax/"+precioMax)
				.retrieve()
				.body(Vehiculo[].class)
				).stream()
				.peek(v->v.setTipo("coche"))
				.toList(); 
	}
	
	
	
	private List<Vehiculo> todos(){
		
		return Arrays.asList(restClient.get().
				uri(urlBase+"todos")
				.retrieve()
				.body(Vehiculo[].class)
				);
	}
}
