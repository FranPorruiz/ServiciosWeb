package model;

import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Pais {
	@JsonAlias(value="name")//esto deserializa  de JSOna Java y viceversa
	private String nombre;
	@JsonAlias(value="region")//esto deserializa JSOna Java y viceversa
	private String continente;
	private String capital;
	@JsonAlias(value="population")//esto deserializa  JSOna Java y viceversa
	private long poblacion;
	@JsonAlias(value="flag")//esto  deserializa de JSOna Java y viceversa
	private String bandera;
	

}
