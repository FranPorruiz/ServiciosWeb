package service.interfaces;

import java.util.List;

import model.Pais;

public interface PaisService {
	//lista de continentes
	//Lista de paises por continente
	//Datos del pais más poblado

	List<String> listaContinentes();
	List<Pais> paisesPorContinente(String continente);
	Pais masHabitado();
	
	

}
