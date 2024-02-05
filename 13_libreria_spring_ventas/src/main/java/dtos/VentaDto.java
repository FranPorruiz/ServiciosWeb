package dtos;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class VentaDto {
	private int idCliente;
	private int isbn;
	private Date fecha;


	

}
