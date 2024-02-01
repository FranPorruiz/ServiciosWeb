package dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.Libro;

public interface LibrosDao extends JpaRepository<Libro, Integer> {
	Libro findByTitulo(String titulo);
	List<Libro> findByAutor(String autor);
	
	@Query("select l from Libro l where l.tema.idTema=?1")
	List<Libro> findByIdTema(int idTema);
	//heredados:
	//findById(int isbn);
	//findAll()
	
	//funcionalidad de libros por nombre de tema;
	//el primer tema es el objeto y el segundo es la propiedad
	//join implicito
	@Query("select l from Libro l where l.tema.tema=?1")
	List<Libro> findByTema(String tema);
}
