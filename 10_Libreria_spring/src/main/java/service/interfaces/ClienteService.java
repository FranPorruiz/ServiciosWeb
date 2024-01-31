package service.interfaces;

import model.Cliente;

public interface ClienteService {
	
	public boolean altaCliente(Cliente cliente);
	
	public Cliente autenticar(String usuario, String password);

	

}
