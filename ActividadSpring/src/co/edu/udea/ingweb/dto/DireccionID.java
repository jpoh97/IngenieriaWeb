package co.edu.udea.ingweb.dto;

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
