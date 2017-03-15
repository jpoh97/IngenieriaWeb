package co.edu.udea.ingweb.dao.imp;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import co.edu.udea.ingweb.dao.CiudadFacade;
import co.edu.udea.ingweb.dto.CiudadPOJO;
import co.edu.udea.ingweb.exception.MyException;

/**
 *Clase que contiene la prueba de la función obtener del
 *DAO de ciudad. Espero obtener un listado de ciudades mayores a cero
 *
 * @author jpoh97
 * @since 1.8
 * @version 1.0
 */
public class CiudadDAOTest {

	/**
	 * Caso de prueba para el metodo obtener que retorna el 
	 * listado con todas las ciudades
	 */
	@Test
	public void testObtener() {
		CiudadFacade mCiudadDAO = null;
		List<CiudadPOJO> mList = null;
		try {
			mCiudadDAO = new CiudadDAO();
			mList = mCiudadDAO.obtener();
			assertTrue(mList.size() > 0);
		} catch (MyException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	/**
	 * Caso de prueba para el metodo obtener que retorna una
	 * ciudad especifica a partir del código o ID	
	 */
	@Test
	public void testObtener2() {
		CiudadFacade mCiudadDAO = null;
		CiudadPOJO mCiudad = null;
		try {
			mCiudadDAO = new CiudadDAO();
			mCiudad = mCiudadDAO.obtener(1L);
			assertTrue(mCiudad != null);
		} catch (MyException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}
