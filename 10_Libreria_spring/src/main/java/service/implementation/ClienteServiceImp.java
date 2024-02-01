package service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ClientesDao;
import model.Cliente;
import service.interfaces.ClienteService;

@Service
public class ClienteServiceImp implements ClienteService {
	@Autowired
	ClientesDao clientesDao;
	
	@Override
	public boolean altaCliente(Cliente nuevoCliente) {
		if(clientesDao.findByUsuario(nuevoCliente.getUsuario())==null) {
			clientesDao.save(nuevoCliente);	
			return true;
		}
		
		return false;
	}

	@Override
	public Cliente autenticar(String usuario, String password) {
		return clientesDao.findByUsuarioAndPassword(usuario, password);
		
	}

}
