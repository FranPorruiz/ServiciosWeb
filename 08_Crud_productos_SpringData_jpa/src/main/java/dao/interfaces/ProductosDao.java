package dao.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import jakarta.transaction.Transactional;
import modelo.Producto;

//le decimos a la interfaz que nos implemente el JPa Repository, hay que pasarle 
//el objeto y el tipo de la primary key
public interface ProductosDao extends JpaRepository<Producto, Integer> {
	
	
	Producto findBynombreProducto(String nombre);//como findBy es reservada de JPA ya cogera el nombre
	List<Producto> findBycategoriaProducto(String categoria);
	
	//Anotacion transact
	//Anotacion Modifyng, se va a a modificar la tabla
	@Transactional
	@Modifying
	void deleteBynombreProducto(String nombre);
	
	
	
}
