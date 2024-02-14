package init.service.interfaces;

import java.util.List;

import init.model.Libro;

public interface TiendaService {
	
	List<String> listaTematicas();
	List<Libro>  busquedaPorTematica(String tematica);


}
