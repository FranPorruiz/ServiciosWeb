package service.implementations;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.LibrosDao;
import dao.TemasDao;
import dtos.LibroDto;
import dtos.TemaDto;
import model.Libro;
import model.Tema;
import service.interfaces.LibrosService;
import service.mappers.Mapeador;

@Service
public class LibrosServiceImpl implements LibrosService {
	@Autowired
	TemasDao temasDao;
	@Autowired
	LibrosDao librosDao;
	@Autowired
	Mapeador mapeador;
	@Override
	public List<TemaDto> getTemas() {
		return temasDao.findAll().
				stream().
				map(e->mapeador.temaEntityToDto(e)).toList()
				;
	}

	@Override
	public List<LibroDto> librosTema(int idTema) {
		if(idTema==0) {
			return librosDao.findAll().
					stream().
					map(e->mapeador.libroEntityToDto(e)).
					toList()
					;
		}
		return librosDao.findByIdTema(idTema).
				stream().
				map(e->mapeador.libroEntityToDto(e)).
				toList()
				;
	}

	@Override
	public LibroDto getLibro(int isbn) {
		Optional<Libro> resultado=librosDao.findById(isbn);
		//return resultado.isPresent()?resultado.get():null;
		return resultado.map(l->mapeador.libroEntityToDto(l))
				.orElse(null);
	}

	@Override
	public TemaDto getTema(int idTema) {
		return temasDao.findById(idTema).map(t->mapeador.temaEntityToDto(t))
				.orElse(null);
	}

}
