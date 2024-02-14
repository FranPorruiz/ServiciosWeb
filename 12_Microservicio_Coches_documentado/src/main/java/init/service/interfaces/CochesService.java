package init.service.interfaces;

import java.util.List;

import init.model.Coche;

public interface CochesService {
	
	public void altaCoche(Coche coche);
	
	public Coche borrarCoche(String matricula);
	
	public List<Coche> buscarPorMarca(String marca);
	
	public List<Coche> buscarPrecioMax(double precio);
	
	public List<Coche> todos();
	
	
	public void actualizarCoche(Coche coche);
	
	
	
	

}
