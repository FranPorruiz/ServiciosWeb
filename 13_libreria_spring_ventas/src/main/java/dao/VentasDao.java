package dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.Tema;
import model.Venta;

public interface VentasDao extends JpaRepository<Venta, Integer> {
	//heredados
	//find all
	//finByID
	
	
	//findbyIsbn
	//query implicita
	List<Venta> findByLibroIsbn(int isbn);
	
	//findbyIdCliente
	//query implicita
	List<Venta>findByClienteIdCliente(int idCliente);
	
	//findbyIdCliente
	//query implicita
	List<Venta>findByClienteUsuario(String usuario);
	
	//findbyfecha, con poner between lo detecta entre dos fecha
	//query implicita
	List<Venta>findByFechaBetween(Date f1, Date f2);
	
	
	
	
}
