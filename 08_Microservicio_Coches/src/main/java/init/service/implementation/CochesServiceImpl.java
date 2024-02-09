package init.service.implementation;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;

import java.util.Date;

import init.model.Coche;
import init.service.interfaces.CochesService;

@Service
public class CochesServiceImpl implements CochesService {
	
	
	static SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
	static List<Coche> listCoches = new ArrayList<>(cargarCoches());
	
	static List<Coche> cargarCoches() {
		try {
			return List.of( new Coche("1111AAA", "Marca1", "Modelo1,1", 1000, 10000, "01/01/2001"),
							  new Coche("1111BBB", "Marca1", "Modelo1,2", 1200, 12000, "02/01/2001"),
							  new Coche("2222AAA", "Marca2", "Modelo2,1", 2000, 20000, "02/02/2002"),
							  new Coche("2222BBB", "Marca2", "Modelo2,2", 2200, 22000, "02/02/2002"),
							  new Coche("3333AAA", "Marca3", "Modelo3,1", 3000, 30000, "03/03/2003"),
							  new Coche("4444AAA", "Marca4", "Modelo4,1", 4000, 40000, "04/04/2004"),
							  new Coche("5555AAA", "Marca5", "Modelo5,1", 5000, 50000, "05/05/2005"),
							  new Coche("6666AAA", "Marca6", "Modelo6,1", 6000, 60000, "06/06/2006"),
							  new Coche("7777AAA", "Marca7", "Modelo7,1", 7000, 70000, "07/07/2007"),
							  new Coche("8888AAA", "Marca8", "Modelo8,1", 8000, 80000, "08/08/2008"),
							  new Coche("9999AAA", "Marca9", "Modelo9,1", 9000, 90000, "09/09/2009"));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	} 
	
	
	@Override
	public void altaCoche(Coche coche) {
		if(listCoches.stream().filter(c->c.getMatricula().equals(coche.getMatricula()))!=null) {
			listCoches.add(coche);

		}
		
	}

	@Override
	public Coche borrarCoche(String matricula) {
		Coche cocheBorrado=listCoches.stream().
						filter(c->c.getMatricula().
						equals(matricula)).
						findFirst().
						orElse(null);
		listCoches.remove(cocheBorrado);
		
		return cocheBorrado;
	}

	@Override
	public List<Coche> buscarPorMarca(String marca) {
			 List<Coche> listadoMarca=listCoches.stream().filter(c->c.getMarca().equals(marca)).toList();

			return listadoMarca;
	}

	@Override
	public List<Coche> buscarPrecioMax(double precio) {
		 List<Coche> listadoMax=listCoches.
				 stream().
				 filter(f->f.getPrecio()<=precio).
				 toList();
		return listadoMax;
	}

	@Override
	public List<Coche> todos() {
		return listCoches;
	}

	@Override
	public void actualizarCoche(Coche cocheActualizado) {
		for (Coche coche : listCoches) {
			if (coche.getMatricula().equals(cocheActualizado.getMatricula())) {
				coche.setKm(cocheActualizado.getKm());
				coche.setPrecio(cocheActualizado.getPrecio());
				
			}
		}

	}

}
