package service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.interfaces.ProductosDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import modelo.Producto;
import service.interfaces.ProductoService;

@Service
public class ProductoServiceImpl  implements ProductoService{
	@Autowired
	ProductosDao productosDao;
	
	@Override
	public boolean altaProducto(Producto nuevoProducto) {
		if(!(nuevoProducto==null)) {
			productosDao.save(nuevoProducto);
			return true;
		}
		
		return false;
		
	}
	
	@Override
	public List<Producto> buscar(String categoria) {
		List<Producto> busqueda=productosDao.findBycategoriaProducto(categoria);
		return busqueda;
	}

	@Override
	public void modificar(String nombre, double nuevoPrecio) {
		Producto productoModificado=productosDao.findBynombreProducto(nombre);
		if(productoModificado!=null) {
			productoModificado.setPrecioProducto(nuevoPrecio);
			productosDao.save(productoModificado);
		}
		
		
	}
	
	
	@Override
	public Producto borrar(String nombre) {
		Producto productoBorrado=productosDao.findBynombreProducto(nombre);
		
		if(productoBorrado!=null) {
			productosDao.delete(productoBorrado);
			return productoBorrado;
		}
		
		return null;
	}
	
	//metodo para devolverlos todos
	@Override
	public List<Producto> todos() {
		return productosDao.findAll();
	}
	


}
