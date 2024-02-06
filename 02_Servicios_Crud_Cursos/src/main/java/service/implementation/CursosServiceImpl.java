package service.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import model.Curso;
import service.interfaces.CursosService;

@Service
public class CursosServiceImpl implements CursosService{

	@Override
	public List<Curso> busquedaTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Curso busquedaPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Curso> busquedaPorRango(int precio1, int precio2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Curso> altaCurso(Curso curso) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Curso borrarCurso(String denominacion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizacionPrecios(String denominacion, int precio) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Integer> mostrarPrecios(String denominacion) {
		// TODO Auto-generated method stub
		return null;
	}

}
