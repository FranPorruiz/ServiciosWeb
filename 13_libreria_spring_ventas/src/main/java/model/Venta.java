package model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="ventas")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Venta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idVenta;
	//Date java.util
	private Date fecha;
	
	@ManyToMany()
	@JoinColumn(name="idTema",
			referencedColumnName="idTema")
	private Cliente cliente;
	
	@OneToMany()
	private List <Libro> libros;
	
	
	
	
	
	
	
	

}
