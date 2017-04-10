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

public class UsuarioPOJO {
	
	private String login;
	private String nombre;
	private String apellido;
	private String contrasena;
	private RolPOJO rol;
	
	public String getLogin() {
		return login;
	}	
	public void setLogin(String login) {
		this.login = login;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	public RolPOJO getRol() {
		return rol;
	}
	public void setRol(RolPOJO rol) {
		this.rol = rol;
	}
	
}
