package service.interfaces;

import java.util.List;

import model.Resultado;

public interface BuscadorService {
	
	//metodo para implementar en el Service
	List<Resultado> buscar(String tematica);
	
	public void agregarPagina(Resultado resultado);
		
	

}
