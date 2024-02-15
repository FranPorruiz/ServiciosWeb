package init.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Formacion {
	//con Jsonalias le decimos el nombre que corresponde a clase del servicio originario
	//@JsonAlias(value="denominacion")
	@JsonProperty(value="denominacion")//esto serializa y deserializa de JSOna Java y viceversa
	private String nombre;
	//@JsonAlias(value="duracion")
	@JsonProperty(value="duracion")//esto serializa y deserializa de JSOna Java y viceversa
	private int horas;
	private double precio;

}
