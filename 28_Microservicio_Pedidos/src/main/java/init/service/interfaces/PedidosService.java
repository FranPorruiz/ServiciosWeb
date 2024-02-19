package init.service.interfaces;

import java.util.List;

import init.model.Pedido;

public interface PedidosService {
	/*Peticion post, recibe los datos del pedido(JSON)
	 *  comunica a al servicio de productos para actualizar el stock
	Recurso get que devuelva todos los pedidos registrados
	 */
	
	public void actualizarStock(Pedido pedido);
	
	public List<Pedido> pedidos();
	
	

}
