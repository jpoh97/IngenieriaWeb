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

import java.util.Date;
import java.util.Set;

public class ClientePOJO {
	
	private String cedula;
	private String nombres;
	private String apellidos;
	private String email;
	private UsuarioPOJO usuarioCrea;
	private Date fechaCreacion;
	private UsuarioPOJO usuarioMod;
	private Date fechaMod;
	private Boolean eliminado;
	private UsuarioPOJO usuarioElimina;
	private Date fechaEliminacion;
	private Set<DireccionPOJO> direcciones;
	
	
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public UsuarioPOJO getUsuarioCrea() {
		return usuarioCrea;
	}
	public void setUsuarioCrea(UsuarioPOJO usuarioCrea) {
		this.usuarioCrea = usuarioCrea;
	}
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public UsuarioPOJO getUsuarioMod() {
		return usuarioMod;
	}
	public void setUsuarioMod(UsuarioPOJO usuarioMod) {
		this.usuarioMod = usuarioMod;
	}
	public Date getFechaMod() {
		return fechaMod;
	}
	public void setFechaMod(Date fechaMod) {
		this.fechaMod = fechaMod;
	}
	public Boolean getEliminado() {
		return eliminado;
	}
	public void setEliminado(Boolean eliminado) {
		this.eliminado = eliminado;
	}
	public UsuarioPOJO getUsuarioElimina() {
		return usuarioElimina;
	}
	public void setUsuarioElimina(UsuarioPOJO usuarioElimina) {
		this.usuarioElimina = usuarioElimina;
	}
	public Date getFechaEliminacion() {
		return fechaEliminacion;
	}
	public void setFechaEliminacion(Date fechaEliminacion) {
		this.fechaEliminacion = fechaEliminacion;
	}
	public Set<DireccionPOJO> getDirecciones() {
		return direcciones;
	}
	public void setDirecciones(Set<DireccionPOJO> direcciones) {
		this.direcciones = direcciones;
	}
	
	

}
