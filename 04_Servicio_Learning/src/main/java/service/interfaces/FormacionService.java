package service.interfaces;

import java.util.List;

import model.Formacion;

public interface FormacionService {
	List <Formacion> catalogo();
	List<Formacion> catalogoporDuracionMax(int max);
	void altaFormacion(Formacion formacion);

}
