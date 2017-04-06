package co.edu.udea.ingweb.dao;

import java.util.List;

import co.edu.udea.ingweb.dto.UsuarioPOJO;
import co.edu.udea.ingweb.exception.MyException;

public interface UsuarioFacade {
	
	public List<UsuarioPOJO> obtener() throws MyException;
	
	public UsuarioPOJO obtener(String mLogin) throws MyException;	
	
	public void guardar(UsuarioPOJO mUsuario) throws MyException;

}
