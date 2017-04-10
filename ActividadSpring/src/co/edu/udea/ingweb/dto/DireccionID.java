package co.edu.udea.ingweb.dto;

/**
 *Clase creada para realizar la transferencia 
 *de objetos a la base de datos
 *
 *Se encuentra en el paquete DTO
 *
 * @author Juan Pablo Ospina Herrera
 * @since 1.8
 * @version 1.0 
 * 
 */

import java.io.Serializable;

public class DireccionID implements Serializable {

	private Long codigo;
	private ClientePOJO cliente;
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public ClientePOJO getCliente() {
		return cliente;
	}
	public void setCliente(ClientePOJO cliente) {
		this.cliente = cliente;
	}	
	
}
