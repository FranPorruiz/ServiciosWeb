package dao.implementation;

import java.util.List;

import org.springframework.stereotype.Repository;

import dao.interfaces.ProductosDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import modelo.Producto;
@Repository
public class ProductoDaoImplementacion implements ProductosDao{
	@PersistenceContext
	EntityManager em;
	@Transactional
	@Override
	public void save(Producto producto) {
		em.persist(producto);
		
	}

	@Override
	public Producto findByNombre(String nombre) {
		String jpql="select p from Producto p where p.nombreProducto=?1";
		TypedQuery<Producto> query=em.createQuery(jpql,Producto.class);
		query.setParameter(1, nombre);
		List<Producto> productos=query.getResultList();
		return productos.size()>0?productos.get(0):null; 
	}

	@Override
	public List<Producto> findByCategoria(String categoria) {
		String jpql="select p from Producto p where p.categoriaProducto=?1";
		TypedQuery<Producto> query=em.createQuery(jpql,Producto.class);
		query.setParameter(1, categoria);
		List<Producto> productos=query.getResultList();
		//return productos.size()>0?(List<Producto>) productos.get(0):null; 
		return productos;
	}
	@Transactional
	@Override
	public void update(Producto producto) {
		em.merge(producto);
	
	}
	
	@Transactional
	@Override
	public void delete(Producto producto) {
		//em.remove(em.merge(producto));
		em.remove(em.find(Producto.class, producto.getIdProducto()));//con esto deberia integrarse
	
	}
	@Transactional
	@Override
	public void deleteByNombre(String nombre) {
		String jpql="delete from Producto p where p.nombre=?1";
		TypedQuery<Producto> query=em.createQuery(jpql,Producto.class);
		query.setParameter(1, nombre);
		query.executeUpdate();
		
	
	}
	

}
