package service.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import model.Producto;
import service.interfaces.ProductosService;
@Service
public class ProductosServiceImpl implements ProductosService {
	
	static List<Producto>listProductos=new ArrayList<Producto>(List.of(
			new Producto("tomate", 5, "fruta"),
			new Producto("leche", 3, "lacteos"),
			new Producto("pasta de dientes", 2, "higiene"),
			new Producto("sandia", 4, "fruta"),
			new Producto("mantequilla", 3, "lacteos")
			));
	@Override
	public void anadirProducto(Producto nuevoProducto) {
		listProductos.add(nuevoProducto);
		
	}

	@Override
	public List<Producto> buscarProducto(String categoria) {
		List<Producto> auxProducto=new ArrayList<Producto>();
		for (Producto producto : listProductos) {
			if (producto.getCategoria().equals(categoria)) {
				auxProducto.add(producto);
			}
		}
		return auxProducto;
	}

	@Override
	public void borrarProducto(String nombre) {
		List<Producto> auxProducto=new ArrayList<Producto>();
		//metodo funcional de borrado
		listProductos.removeIf(p -> p.getNombre().equals(nombre));   
		
	}

}
