package dao;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import model.Cliente;


public interface ClientesDao extends JpaRepository<Cliente, Integer>  {
	Cliente findByUsuarioandPassword(String usuario, String password);
	Cliente findByUsuario(String usuario);
	
	//heredados 
	//save (Cliente cliente)->para dar de  alta
	

}
