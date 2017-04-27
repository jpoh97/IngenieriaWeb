package co.edu.udea.ingweb.bl;

import java.util.List;

import co.edu.udea.ingweb.dao.UsuarioFacade;
import co.edu.udea.ingweb.dao.impl.UsuarioDAO;
import co.edu.udea.ingweb.dto.RolPOJO;
import co.edu.udea.ingweb.dto.UsuarioPOJO;
import co.edu.udea.ingweb.exception.MyException;

/**
 *Clase creada para desarrollar la lógica 
 *del negocio del usuario
 *
 *Se encuentra en el paquete bl
 *
 * @author Juan Pablo Ospina Herrera
 * @since 1.8
 * @version 1.0 
 * 
 */
public class UsuarioBL {
	
	private UsuarioFacade usuarioDao;
	
	public UsuarioFacade getUsuarioDao() {
		return usuarioDao;
	}

	public void setUsuarioDao(UsuarioFacade usuarioDao) {
		this.usuarioDao = usuarioDao;
	}
	
	/**
	 * Metodo para validar el login y el password de un usuario
	 * @param login Login del usuario que intenta ingresar
	 * @param password Contasena del usuario
	 * @return Verdadero si cumple todas las restrincciones
	 * @throws MyException En caso de no cumplir las condiciones o haber un error
	 */
	public void validateLogin(String login, String password) throws MyException {

		isValidField(login, "login");
		isValidField(password, "contraseña");
		
		UsuarioPOJO mUsuario = usuarioDao.obtener(login); 
		
		if(mUsuario == null) {
			throw new MyException("No existe usuario con ese login");
		}
		
		if(!mUsuario.getContrasena().equals(password)) {
			throw new MyException("Contraseña incorrecta");
		}
		
	}
	
	/**
	 * Lógica del negocio del metodo para obtener todos los usuarios	
	 * @return List<UsuarioPOJO> listado con usuarios
	 * @throws MyException Manejo mi excepción en caso de errores
	 */
	public List<UsuarioPOJO> getAll() throws MyException {
		return usuarioDao.obtener();
	}
	
	/**
	 * Lógica del negocio del metodo para obtener un usuario apartir de su login	
	 * @return UsuarioPOJO Usuario con el login especificado
	 * @throws MyException Manejo mi excepción en caso de errores
	 */
	public UsuarioPOJO get(String login) throws MyException {
		return usuarioDao.obtener(login);
	}
	
	/**
	 * Lógica del negocio del metodo para guarda un usuario en la base de datos	 
	 * @param login Login del usuario
	 * @param nombre Nombres del usuario
	 * @param apellido Apellidos del usuario
	 * @param contrasena Contrasena del usuario
	 * @param rol Rol del usuario
	 * @throws MyException Manejo mi excepción en caso de errores
	 */
	public void saveUser(String login, String nombre, String apellido, 
			String contrasena, String rol) throws MyException {
		
		isValidField(login, "login");
		isValidField(nombre, "nombres");
		isValidField(apellido, "apellidos");
		isValidField(contrasena, "contraseña");
		isValidField(rol, "rol");
										
		if(usuarioDao.obtener(login) != null) {
			throw new MyException("El usuario ya existe");
		}
		
		if(contrasena.length() <= 5) {
			throw new MyException("La contraseña debe tener al menos 6 carateres");
		}
						
		UsuarioPOJO mUsuario = new UsuarioPOJO();
		mUsuario.setLogin(login);
		mUsuario.setNombre(nombre);
		mUsuario.setApellido(apellido);
		mUsuario.setContrasena(contrasena);
		RolPOJO mRol = new RolPOJO();
		mRol.setCodigo(rol);
		mUsuario.setRol(mRol);
				
		usuarioDao.guardar(mUsuario);
		
	}
	
	/**
	 * Metodo que permite validar si un campo es nulo o vacio
	 * @param text Texto a analizar
	 * @param field Nombre del campo a analizar
	 * @throws MyException En caso de ser nulo o vacio muestro excepcion
	 */
	public void isValidField(String text, String field) throws MyException {
		if(text == null) {
			throw new MyException("El campo " + field + " no puede ser nulo");
		}
		if(text.trim().equalsIgnoreCase("")) {
			throw new MyException("El campo " + field + " no puede estar vacio");
		}
	}
}
