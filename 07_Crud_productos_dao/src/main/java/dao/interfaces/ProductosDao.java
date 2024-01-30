package dao.interfaces;

import java.util.List;

import modelo.Producto;

public interface ProductosDao {
	
	//metodos del crud., nombres por convencion
	void save(Producto producto);
	Producto findByNombre(String nombre);
	List<Producto> findByCategoria(String categoria);
	void update(Producto producto);
	//podriamos poner void updateByNombre(String Nombre) pero complicaria demasiaod la logica
	void delete(Producto producto);
	void deleteByNombre(String nombre);
	
	
	
}
