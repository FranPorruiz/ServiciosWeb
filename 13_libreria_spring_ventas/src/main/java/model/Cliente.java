package model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="clientes")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCliente;
	private String usuario;
	private String password;
	private String email;
	private int telefono;
	
	@ManyToMany()
	@JoinColumn(name="idVenta",
			referencedColumnName="idVenta")
	private Venta venta;
	
}
