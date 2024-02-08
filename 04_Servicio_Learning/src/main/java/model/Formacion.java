package model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Formacion {
	@JsonProperty(value="denominacion")//esto serializa y deserializa de JSOna Java y viceversa
	//con Jsonalias le decimos el nombre que corresponde a clase del servicio originario
	//@JsonAlias(value="denominacion")
	private String nombre;
	@JsonProperty(value="duracion")//esto serializa y deserializa de JSOna Java y viceversa
	//@JsonAlias(value="duracion")
	private int horas;
	private double precio;

}
