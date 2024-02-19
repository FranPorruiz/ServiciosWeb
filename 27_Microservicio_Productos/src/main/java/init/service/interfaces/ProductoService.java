package init.service.interfaces;

import java.util.List;

import init.model.Producto;

public interface ProductoService {
	/*
	Petiticion Get, devuleve lista de productos
	Peticion put, actualiza el stock dle producto recibiendo por URL{path variable) el codigo de producto y unidades compradas
	peticion get con el codigo de producto que devuelva el preico unitario
	*/
	public List<Producto> listaProducto();
	public void actualizaStock(int idProducto, int udsCompradas);
	public String  precioUnitario(int idProducto );
	
	
	
	
	
	

}
