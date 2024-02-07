package service.interfaces;

import java.util.List;

import model.Curso;

public interface CursosService {
	
	public List<Curso> busquedaTodos();
	
	public Curso busquedaPorId(int id);
	
	public List<Curso> busquedaPorRango(int precio1, int precio2);
	
	public List<Curso> altaCurso (Curso curso);
	
	public Curso borrarCurso(String denominacion);
	
	public void actualizacionPrecios(String denominacion, int precio);
	
	public List<Curso> mostrarPrecios(String denominacion );
	
	
	

}
