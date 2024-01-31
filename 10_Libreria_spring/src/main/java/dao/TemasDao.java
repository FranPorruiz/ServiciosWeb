package dao;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Tema;



public interface TemasDao extends JpaRepository<Tema, Integer> {
	
	//metodos heredados
	//finbyAll() -> para encontrar todos

}
