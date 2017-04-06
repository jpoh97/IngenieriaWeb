package co.edu.udea.ingweb.dao.impl;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import co.edu.udea.ingweb.dao.CiudadFacade;
import co.edu.udea.ingweb.dto.CiudadPOJO;
import co.edu.udea.ingweb.exception.MyException;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations="classpath:configuration.xml")
public class CiudadDAOTest {

	@Autowired
	private CiudadFacade mCiudadDAO;
	/**
	 * Caso de prueba para el metodo obtener que retorna el 
	 * listado con todas las ciudades
	 */
	@Test
	public void testObtener() {
		List<CiudadPOJO> mList = null;
		try {
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
		CiudadPOJO mCiudad = null;
		try {
			mCiudad = mCiudadDAO.obtener(1L);
			assertTrue(mCiudad != null);
		} catch (MyException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}
