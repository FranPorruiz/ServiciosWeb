package service.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import dtos.ClienteDto;
import dtos.LibroDto;
import dtos.TemaDto;
import dtos.VentaDto;
import model.Cliente;
import model.Libro;
import model.Tema;
import model.Venta;
import service.implementations.LibrosServiceImpl;
import service.interfaces.LibrosService;

//le ponemos component porque no es logica de negocio (service) o controller
//es un component 
@Component
public class Mapeador {

	@Autowired	
	LibrosService service;
	public static TemaDto temaEntityToDto(Tema tema) {
		return new TemaDto(tema.getIdTema(),tema.getTema());
	}
	
	public  LibroDto libroEntityToDto(Libro libro) {
		return new LibroDto(libro.getIsbn(),
				libro.getTitulo(),
				libro.getAutor(),
				libro.getPrecio(),
				libro.getPaginas(),
				//esto ultimo recoge el id del tema que correspone al libro
				//llamado por el tema
				service.getTemaDto(libro.getTema().getIdTema() ));
	}
	
	public  Cliente clienteDtotoEntity(ClienteDto clientedto) {
		
		//return new Cliente (0, clientedto.getUsuario(), clientedto.getEmail(), clientedto.getPassword(), clientedto.getTelefono(), service.getVentas());
		//no necesitamo0s devolver las ventas
		return new Cliente (0, clientedto.getUsuario(), clientedto.getEmail(), clientedto.getPassword(), clientedto.getTelefono(), null);

	}
	
	public  ClienteDto clienteEntitytoDto(Cliente cliente) {
		
		return new ClienteDto(cliente.getUsuario(), cliente.getEmail(), cliente.getPassword(), cliente.getTelefono());
		
	}
	
	public VentaDto ventaEntitytoventaDto(Venta venta) {
		
		return new VentaDto( venta.getCliente().getIdCliente(),venta.getLibro().getIsbn(), venta.getFecha() );
		
	}
	
	
	public Venta ventaDtotoEntity(VentaDto ventaDto) {
		//return new Venta(0, ventaDto.getIdCliente(), ventaDto.getIsbn(),ventaDto.getFecha() );
		return null;
	}
	//Date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(); 

}
