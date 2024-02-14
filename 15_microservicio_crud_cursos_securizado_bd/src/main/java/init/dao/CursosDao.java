package init.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import jakarta.transaction.Transactional;
import init.model.Curso;

public interface CursosDao  extends JpaRepository<Curso, Integer> {
	//heredados
	//findAll
	//findById
	//delete()
	//deleteById()
	//save
	
	//busqueda por precio entre rangos
	List<Curso> findByPrecioBetween(int precio1, int precio2);
	//sin query
	//List<Curso> findByPrecioBetween(double p1, double p2);
	
	//borrar curso
	@Transactional
	@Modifying
	void deleteByDenominacion(String denominacion);
	
	//metodo adiccional para encontrar por denominacion
	Curso  findByDenominacion(String denominacion);
	
	//actualizacion de precios
	@Transactional
	@Modifying
	@Query("update Curso c set c.precio=c.precio *(100+?2)/100 where c.denominacion=?1")
	void subirPrecio(String denominacion, int porcentaje);
	
	
	//los precios de todos los cursos por tematica
	@Query("select c from Curso c where c.denominacion=?1")
	List<Curso> busquedaPorDenominacion(String denominacion );
	
	
	
}
