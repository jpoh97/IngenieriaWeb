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
	
	public List<CiudadPOJO> obtener() throws MyException;
	
	public CiudadPOJO obtener(Long codigo) throws MyException;
	
}
