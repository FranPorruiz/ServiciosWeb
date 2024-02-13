package init.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import init.model.Libro;


public interface LibrosDao extends JpaRepository<Libro, Integer> {
	//heredados
	//findAll ->Catalogo
	//findById->Busqueda por ISBN
	//save->dar de alta libro
	
	//lista de tematicas 
	//los precios de todos los cursos por tematica
	@Query("select l.tematica from Libro l")
	List<String> listaTematicas();
	
}
