package service.interfaces;

import java.util.List;

import model.Producto;

public interface ProductosService {
	public void anadirProducto(Producto nuevoProducto); 
	
	public List<Producto> buscarProducto(String categoria);
	
	public void borrarProducto(String nombre);
}
