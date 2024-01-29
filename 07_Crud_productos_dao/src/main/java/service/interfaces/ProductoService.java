package service.interfaces;

import java.util.List;

import modelo.Producto;

public interface ProductoService {
	
	/*Altas de productos, evitando duplicar nombres de productos
	Buscar producto por categoria
	Modificar precios a partir del nombre
	Elimnar productos a partir del nombre
	 */
	
	//lo ponemos booleano porque mas adelante querremos comprobar si ya estaba o no
	public boolean altaProducto (Producto nuevoProducto);
	
	public List<Producto> buscar(String categoria);

	public void modificar(String nombre, double nuevoprecio);
	
	//devolvemos el objeto producto que ha sido eliminado
	public Producto borrar(String nombre);
	
	
	

}
