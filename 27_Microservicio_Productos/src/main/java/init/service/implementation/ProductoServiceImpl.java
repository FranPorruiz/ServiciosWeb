package init.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import init.dao.ProductoDao;
import init.model.Producto;
import init.service.interfaces.ProductoService;
@Service
public class ProductoServiceImpl implements ProductoService {
	
	@Autowired
	ProductoDao productodao ;
	
	
	@Override
	public List<Producto> listaProducto() {
		return productodao.findAll();
	}

	@Override
	public void actualizaStock(int idProducto, int udsCompradas) {
			Producto encontrado=productodao.findById(idProducto).orElse(null);
			int nuevasUnidades=encontrado.getStock()-udsCompradas;
			encontrado.setStock(nuevasUnidades);
			productodao.save(encontrado);
			
		
			
	}

	@Override
	public String precioUnitario(int idProducto) {
		Producto encontrado=productodao.findById(idProducto).orElse(null);
		if(encontrado==null) {
			return "0";		
		}
		return Double.toString(encontrado.getPrecioUnitario());
	}

}
