package init.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import init.model.Pedido ;

public interface PedidosDao extends JpaRepository<Pedido, Integer>  {
	/*
	Peticion post, recibe los datos del pedido(JSON) comunica a al servicio de productos para actualizar el stock
	Recurso get que devuelva todos los pedidos registrados
	*/

	
}
