package init.service.interfaces;

import java.util.List;

import init.exception.LibroExistenteException;
import init.model.Libro;

public interface LibrosService {
	
	List<Libro> catalogo();
	List<String> listaTematicas();
	Libro  busquedaPorIsbn(int isbn);
	void alta(Libro libro) throws LibroExistenteException;
	

	
	

}
