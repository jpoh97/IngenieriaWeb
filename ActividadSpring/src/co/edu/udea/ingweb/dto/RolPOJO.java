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

public class RolPOJO {
	
	private String codigo;		
	private String nombre;
	
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}	
	
	

}
