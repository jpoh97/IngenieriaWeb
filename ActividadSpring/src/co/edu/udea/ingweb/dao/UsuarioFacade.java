package co.edu.udea.ingweb.dao;

/**
 * 
 *Interface que permite definir los métodos de la 
 *clase usuario
 *
 * @author Juan Pablo Ospina Herrera
 * @since 1.8
 * @version 1.0
 *
 */

import java.util.List;

import co.edu.udea.ingweb.dto.UsuarioPOJO;
import co.edu.udea.ingweb.exception.MyException;

public interface UsuarioFacade {
	
	/**
	 * Firma del metodo para obtener la lista de usuarios en la base de datos	
	 * @return listado con usuarios
	 * @throws MyException
	 */
	public List<UsuarioPOJO> obtener() throws MyException;
	
	/**
	 * Firma del metodo para obtene un usuario de la base de datos
	 * a partir de su identificador login
	 * @return objeto que represanta el usuario solicitado
	 * @throws MyException
	 */
	public UsuarioPOJO obtener(String mLogin) throws MyException;	
	
	/**
	 * Firma del metodo que permite guardar un usuario nuevo en la base de datos
	 * @param mUsuario (usuario a guardar)
	 * @throws MyException
	 */	
	public void guardar(UsuarioPOJO mUsuario) throws MyException;

}
