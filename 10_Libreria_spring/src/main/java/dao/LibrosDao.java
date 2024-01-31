package dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Libro;

public interface LibrosDao extends JpaRepository<Libro, Integer> {

	List<Libro> findByIdTema(int idTema);
	
	//heredados
	//findById(int isbn)->para buscar por la clave primaria
	

}
