package init.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import init.model.Producto;



public interface ProductoDao  extends JpaRepository<Producto, Integer> {
	/*
	Petiticion Get, devuleve lista de productos ->findAll
	Peticion put, actualiza el stock dle producto recibiendo por URL{path variable) el codigo de producto y unidades compradas
	peticion get con el codigo de producto que devuelva el preico unitario
	*/
	/*
	@Transactional
	@Modifying
	@Query ("update Producto p set p.stock=p.stock-?2) where p.codigoProducto=?1")
	void actualizarStock(int codigoProducto, int stock);
	*/
	
}
