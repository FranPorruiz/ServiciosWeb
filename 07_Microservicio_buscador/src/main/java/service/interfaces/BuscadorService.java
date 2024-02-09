package service.interfaces;

import java.util.List;

import model.Resultado;

public interface BuscadorService {
	
	//metodo para implementar en el Service
	List<Resultado> buscar(String tematica);
	
	public void agregarPagina(Resultado resultado);
	
	List<Resultado> eliminarResultados(String url);
	
	Resultado actualizarDescripcion(String url, String nuevaDescripcion);

	Resultado actualizarDescripcionPorObjeto(Resultado resultado);
	
		
	

}
