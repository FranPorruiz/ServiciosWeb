package service.interfaces;

import java.util.List;

import model.Libro;
import model.Tema;

public interface LibrosService {
	
	List<Tema> getTemas();
	
	Libro getLibro(int isbn);
	
	Tema getTema(int idTema);
	
	List<Libro> librosTema(int idTema);
}
