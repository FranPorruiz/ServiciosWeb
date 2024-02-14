package init.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import init.dao.CursosDao;
import init.exceptions.CursoExistenteException;
import init.service.interfaces.CursosService;
import init.model.Curso;

@Service
public class CursosServiceImpl implements CursosService{
	
	@Autowired
	CursosDao cursosDao;
	
	@Override
	public List<Curso> busquedaTodos() {
		return cursosDao.findAll();
	}

	@Override
	public Curso busquedaPorId(int id) {
		
		return cursosDao.findById(id).orElse(null);
	
	}

	@Override
	public List<Curso> busquedaPorRango(int precio1, int precio2) {
		return cursosDao.findByPrecioBetween(precio1, precio2);
	}

	@Override
	public List<Curso> altaCurso(Curso curso) throws CursoExistenteException {
		if(cursosDao.findByDenominacion(curso.getDenominacion())!=null) {
			//si ya hay un curso con es enombre, provocamos una excepcion
			throw new CursoExistenteException();
		}
		cursosDao.save(curso);
		
		
		return cursosDao.findAll();
	}

	@Override
	public Curso borrarCurso(String denominacion) {
		Curso cursoBorrado=cursosDao.findByDenominacion(denominacion);
		if(cursoBorrado!=null) {
			cursosDao.deleteByDenominacion(denominacion);
			return cursoBorrado;}
		return cursoBorrado;
			
	}

	@Override
	public void actualizacionPrecios(String denominacion, int precio) {
		cursosDao.subirPrecio(denominacion, precio);
	}

	@Override
	public List<Curso> mostrarPrecios(String denominacion) {
		return cursosDao.busquedaPorDenominacion(denominacion);
	}

	

}
