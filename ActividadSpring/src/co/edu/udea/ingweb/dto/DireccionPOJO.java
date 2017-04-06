package co.edu.udea.ingweb.dto;

public class DireccionPOJO {

	private DireccionID id;
	private String direccion;
	private String telefono;
	private Long ciudad;
	private Boolean preferida;
	
	public DireccionID getId() {
		return id;
	}
	public void setId(DireccionID id) {
		this.id = id;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public Long getCiudad() {
		return ciudad;
	}
	public void setCiudad(Long ciudad) {
		this.ciudad = ciudad;
	}
	public Boolean getPreferida() {
		return preferida;
	}
	public void setPreferida(Boolean preferida) {
		this.preferida = preferida;
	}	
	
}
