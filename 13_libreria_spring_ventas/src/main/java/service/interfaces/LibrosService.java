package service.interfaces;

import java.util.List;

import dtos.ClienteDto;
import dtos.LibroDto;
import dtos.TemaDto;
import dtos.VentaDto;
import model.Cliente;
import model.Libro;
import model.Tema;
import model.Venta;

public interface LibrosService {

	List<TemaDto> getTemasDto();

	List<LibroDto> librosTema(int idTema);
	
	List<VentaDto> getVentasDto();
	
	List<ClienteDto> getClientesDto();
	
	List<Cliente> getClientes();
	
	List<Venta> getVentas();
	
	List<Libro> getLibros();
	
	List<VentaDto> informeVentasDto(ClienteDto clienDto);

	LibroDto getLibroDto(int isbn);

	TemaDto getTemaDto(int idTema);
	
	ClienteDto getClienteDto (int idCliente);
	
	VentaDto getVentaDto(int idVenta);
	

}