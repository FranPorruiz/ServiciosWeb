package init.service.interfaces;

import java.util.List;

import init.model.Vehiculo;

public interface VehiculoServices {
	
	List<Vehiculo> rangoKM(int km1, int km22);
	
	List<Vehiculo> precioMax(double precioMax);
	

}
