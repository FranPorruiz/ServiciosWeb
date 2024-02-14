package init.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import init.dao.LibrosDao;
import init.exception.LibroExistenteException;
import init.model.Libro;
import init.service.interfaces.LibrosService;

@Service

public class LibrosServiceImpl implements LibrosService {
	
	@Autowired
	LibrosDao librosDao;
	
	@Override
	public List<Libro> catalogo() {
		return librosDao.findAll();
	}


	@Override
	public void alta(Libro libro) throws LibroExistenteException {
		/*
		if((librosDao.findById(libro.getIsbn()))!=null) {
			throw new LibroExistenteException();
		}
		*/
		
		librosDao.save(libro);
	
	}



	@Override
	public List<String> listaTematicas() {
		
		return librosDao.listaTematicas();
	}


	@Override
	public Libro busquedaPorIsbn(int isbn) {
		
		return librosDao.findById(isbn).orElse(null);
	}

}
