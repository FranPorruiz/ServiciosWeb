package service.implementations;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ClientesDao;
import dao.LibrosDao;
import dao.TemasDao;
import dao.VentasDao;
import dtos.ClienteDto;
import dtos.LibroDto;
import dtos.TemaDto;
import dtos.VentaDto;
import model.Cliente;
import model.Libro;
import model.Tema;
import model.Venta;
import service.interfaces.LibrosService;
import service.mappers.Mapeador;

@Service
public class LibrosServiceImpl implements LibrosService {
	@Autowired
	TemasDao temasDao;
	@Autowired
	LibrosDao librosDao;
	@Autowired
	VentasDao ventasDao;
	@Autowired
	Mapeador mapeador;
	@Autowired
	ClientesDao clientesDao;
	@Override
	public List<TemaDto> getTemasDto() {
		return temasDao.findAll().
				stream().
				map(e->mapeador.temaEntityToDto(e)).toList()
				;
	}

	@Override
	public List<LibroDto> librosTema(int idTema) {
		if(idTema==0) {
			return librosDao.findAll().
					stream().
					map(e->mapeador.libroEntityToDto(e)).
					toList()
					;
		}
		return librosDao.findByIdTema(idTema).
				stream().
				map(e->mapeador.libroEntityToDto(e)).
				toList()
				;
	}

	@Override
	public LibroDto getLibroDto(int isbn) {
		Optional<Libro> resultado=librosDao.findById(isbn);
		//return resultado.isPresent()?resultado.get():null;
		return resultado.map(l->mapeador.libroEntityToDto(l))
				.orElse(null);
	}

	@Override
	public TemaDto getTemaDto(int idTema) {
		return temasDao.findById(idTema).map(t->mapeador.temaEntityToDto(t))
				.orElse(null);
	}
	
	@Override
	public ClienteDto getClienteDto(int idCliente) {
		Optional <Cliente> resultado=clientesDao.findById(idCliente);
		
		return resultado.map(c->mapeador.clienteEntitytoDto(c))
				.orElse(null);
				
	}

	@Override
	public VentaDto getVentaDto(int idVenta) {
		Optional <Venta> resultado=ventasDao.findById(idVenta);
		
		return resultado.map(c->mapeador.ventaEntitytoventaDto(c))
				.orElse(null);
	}


	@Override
	public List<VentaDto> getVentasDto() {
		return ventasDao.findAll().stream().
				map(e->mapeador.ventaEntitytoventaDto(e)).toList();
	}
	
	@Override
	public List<ClienteDto> getClientesDto() {
		return clientesDao.findAll().
				stream().
				map(e->mapeador.clienteEntitytoDto(e)).toList();
	}

	@Override
	public List<Cliente> getClientes() {
		return clientesDao.findAll();
		
	}

	@Override
	public List<Venta> getVentas() {
		return ventasDao.findAll();
	}

	@Override
	public List<Libro> getLibros() {
		return librosDao.findAll();
	}

	@Override
	public List<VentaDto> informeVentasDto(ClienteDto cltDTo){
		 List <Venta> resultado=ventasDao.findByClienteUsuario(cltDTo.getUsuario()) ;
		 return resultado.stream().map(e->mapeador.ventaEntitytoventaDto(e)).toList() ;
		 
	}


}
