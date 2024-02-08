package model;

import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Formacion {
	//con Jsonalias le decimos el nombre que corresponde a clase del servicio originario
	@JsonAlias(value="denominacion")
	private String nombre;
	@JsonAlias(value="duracion")
	private int horas;
	private double precio;

}
