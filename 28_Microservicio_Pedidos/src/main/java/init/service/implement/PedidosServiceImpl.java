package init.service.implement;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import init.dao.PedidosDao;
import init.model.Pedido;
import init.service.interfaces.PedidosService;
@Service
public class PedidosServiceImpl implements PedidosService {
	/*
	Peticion post, recibe los datos del pedido(JSON)
	 comunica a al servicio de productos para actualizar el stock
	Recurso get que devuelva todos los pedidos registrados
	*/
	
	@Autowired
	PedidosDao pd;
	
	@Autowired
	RestClient restClient;
	
	static String url="http://servicio-productos/";
	

	@Override
	public void actualizarStock(Pedido pedido) {
		
		pedido.setFechaPedido(new Date());
		double precio=Double.parseDouble(
				restClient.get().
				uri(url+"precio/"+pedido.getCodigoProducto())
				.retrieve()
				.body(String.class));
		pedido.setTotal(pedido.getUnidades()*precio);
		pd.save(pedido);
		
		
		restClient.put().uri(url+"actualizar/"+pedido.getIdPedido()+"/"+pedido.getUnidades()).retrieve();

		}
	

	@Override
	public List<Pedido> pedidos() {
		return pd.findAll();
	}

}
