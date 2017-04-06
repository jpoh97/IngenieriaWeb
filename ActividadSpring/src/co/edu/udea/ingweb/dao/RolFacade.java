package co.edu.udea.ingweb.dao;

import java.util.List;

import co.edu.udea.ingweb.dto.RolPOJO;
import co.edu.udea.ingweb.exception.MyException;

public interface RolFacade {

	public List<RolPOJO> obtener() throws MyException;
	
	public RolPOJO obtener(String mCodigo) throws MyException;	
	
	public void guardar(RolPOJO mRol) throws MyException;
}
