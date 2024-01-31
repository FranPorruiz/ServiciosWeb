package service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.LibrosDao;
import dao.TemasDao;
import model.Libro;
import model.Tema;
import service.interfaces.LibrosService;

@Service
public class LibrosServiceImpl implements LibrosService{
	@Autowired
	LibrosDao librosDao;
	
	@Autowired
	TemasDao temasDao;
	
	
	@Override
	public List<Tema> getTemas() {
		return temasDao.findAll();
	}

	@Override
	public Libro getLibro(int isbn) {	
			//esto es un optional, así que hay que decirle que nos devuelva un objeto o null
			return librosDao.findById(isbn).orElse(null);
	}

	@Override
	public Tema getTema(int idTema) {
		return temasDao.findById(idTema).orElse(null);
	}

	@Override
	public List<Libro> librosTema(int idTema) {
		if(idTema==0) {
			return librosDao.findAll();
		}
		return librosDao.findByIdTema(idTema);
	}

}
