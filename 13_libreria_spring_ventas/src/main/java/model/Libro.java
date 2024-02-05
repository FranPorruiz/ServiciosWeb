package model;

import java.util.List;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="libros")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Libro {
	@Id
	private int isbn;
	private String titulo;
	private String autor;
	private double precio;
	private int paginas;
	//private int idTema;
	//relacion One to Many
	//recibe el tema completo
	//es la propietaria de la relacion
	@ManyToOne()
	@JoinColumn(name="idTema",
				referencedColumnName="idTema")
	private Tema tema;
	
	/*
	@OneToMany(mappedBy="libro")
	private List<Venta> ventas;
	*/
	
	
}
