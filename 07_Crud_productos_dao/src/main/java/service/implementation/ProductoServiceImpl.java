package service.implementation;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import modelo.Producto;
import service.interfaces.ProductoService;

@Service
public class ProductoServiceImpl  implements ProductoService{
	@PersistenceContext //para inyectar el EntityManager
	EntityManager em;
	
	@Transactional //para que Spring inicie y confirme la tx automáticamente
	@Override
	public boolean altaProducto(Producto nuevoProducto) {
		if(busquedaNombre(nuevoProducto.getNombreProducto())==null) {
			em.persist(nuevoProducto);
			return true;
		}
		return false;
	}
	@Transactional //para que Spring inicie y confirme la tx automáticamente
	@Override
	public List<Producto> buscar(String categoria) {
		String jpql="select p from Producto p where p.categoriaProducto=?1";
		TypedQuery<Producto> query=em.createQuery(jpql, Producto.class);
		query.setParameter(1, categoria);
		return query.getResultList();
	}
	@Transactional //para que Spring inicie y confirme la tx automáticamente
	@Override
	public void modificar(String nombre, double nuevoPrecio) {
		Producto modificado=busquedaNombre(nombre);
		String jpqlUp="update Producto p set p.precioProducto=?2 where p.nombreProducto=?1";
		Query query2=em.createQuery(jpqlUp);
		query2.setParameter(1,nombre);
		query2.setParameter(2,nuevoPrecio);
		query2.executeUpdate();
		
	}
	
	@Transactional //para que Spring inicie y confirme la tx automáticamente
	@Override
	public Producto borrar(String nombre) {
		Producto borrado=busquedaNombre(nombre);
		if(borrado==null) {
			return null;
		}
		em.remove(borrado);
		return borrado;
	}
	
	private  Producto busquedaNombre(String nombre) {
		String jpql="select p from Producto p where p.nombreProducto=?1";
		Query query=em.createQuery(jpql);	
		query.setParameter(1,nombre);
		try {
			return (Producto) query.getSingleResult();
		}catch(NoResultException ex) {
			System.out.println("*****Excepcion de null****");
			return null;
		}
	}

}
