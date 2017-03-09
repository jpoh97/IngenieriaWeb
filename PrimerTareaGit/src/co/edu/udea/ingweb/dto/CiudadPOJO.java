package co.edu.udea.ingweb.dto;

/**
 * Clase creada para realizar la transferencia 
 *de objetos a la base de datos
 *
 *Se encuentra en el paquete DTO
 *
 * @author jpoh97
 * @since 1.8
 * @version 1.0 
 * 
 */


public class CiudadPOJO {
	
	private Long codigo;		//código o identificador de la ciudad
	private String nombre;		//nombre de la ciudad
	private String codigoArea;	//identificador del area
	
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCodigoArea() {
		return codigoArea;
	}
	public void setCodigoArea(String codigoArea) {
		this.codigoArea = codigoArea;
	}
	
	
}
