package service.interfaces;

import java.util.List;

import dtos.LibroDto;
import dtos.TemaDto;
import model.Libro;
import model.Tema;

public interface LibrosService {

	List<TemaDto> getTemas();

	List<LibroDto> librosTema(int idTema);

	LibroDto getLibro(int isbn);

	TemaDto getTema(int idTema);

}