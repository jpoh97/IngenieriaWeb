package co.edu.udea.ingweb.dao;

/**
 * 
 *Interface que permite definir los métodos de la 
 *clase cliente
 *
 * @author Juan Pablo Ospina Herrera
 * @since 1.8
 * @version 1.0
 *
 */

import java.util.List;

import co.edu.udea.ingweb.dto.ClientePOJO;
import co.edu.udea.ingweb.exception.MyException;

public interface ClienteFacade {
	
	/**
	 * Firma del metodo para obtener la lista de clientes en la base de datos	
	 * @return listado con clientes
	 * @throws MyException
	 */
	public List<ClientePOJO> obtener() throws MyException;
	
	/**
	 * Firma del metodo para obtener un cliente de la base de datos
	 * a partir de su cedula
	 * @return objeto que represanta el cliente solicitado
	 * @throws MyException
	 */
	public ClientePOJO obtener(String cedula) throws MyException;

	/**
	 * Firma del metodo que permite guardar un cliente nuevo en la base de datos
	 * @param mCliente (cliente a guardar)
	 * @throws MyException
	 */
	public void guardar(ClientePOJO mCliente) throws MyException;

}
