package co.edu.udea.ingweb.dao;

import java.util.List;

import co.edu.udea.ingweb.dto.ClientePOJO;
import co.edu.udea.ingweb.exception.MyException;

public interface ClienteFacade {
	
	public List<ClientePOJO> obtener() throws MyException;
	
	public ClientePOJO obtener(String cedula) throws MyException;
	
	public void guardar(ClientePOJO mCliente) throws MyException;

}
