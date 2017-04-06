package co.edu.udea.ingweb.dao;

import java.util.List;

import co.edu.udea.ingweb.exception.MyException;
import co.edu.udea.ingweb.dto.CiudadPOJO;

/**
 * 
 *Interface que permite definir los métodos de la 
 *clase ciudad
 *
 * @author jpoh97
 * @since 1.8
 * @version 1.0
 *
 */
public interface CiudadFacade {
	
	/**
	 * Firma del metodo para obtener la lista de ciudades en la base de datos	
	 * @return listado con ciudades
	 * @throws MyException
	 */
	public List<CiudadPOJO> obtener() throws MyException;
	
	/**
	 * Firma del metodo para obtene una ciudad de la base de datos
	 * a partir del código de esta
	 * @return objeto que represanta la ciudad solicitada
	 * @throws MyException
	 */
	public CiudadPOJO obtener(Long mCodigo) throws MyException;
	
	/**
	 * 
	 * @param mCiudad
	 * @throws MyException
	 */
	public void guardar(CiudadPOJO mCiudad) throws MyException;
	
}