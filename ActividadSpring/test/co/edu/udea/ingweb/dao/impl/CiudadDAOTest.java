package co.edu.udea.ingweb.dao.impl;

/**
 *Clase creada para realizar las pruebas de
 *los metodos de la ciudad 
 *
 *Se encuentra en la carpeta Test
 *
 * @author Juan Pablo Ospina Herrera
 * @since 1.8
 * @version 1.0 
 * 
 */

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import co.edu.udea.ingweb.dao.CiudadFacade;
import co.edu.udea.ingweb.dto.CiudadPOJO;
import co.edu.udea.ingweb.dto.ClientePOJO;
import co.edu.udea.ingweb.dto.UsuarioPOJO;
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
	public void testObtenerTodos() {
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
	public void testObtener() {
		CiudadPOJO mCiudad = null;
		try {
			mCiudad = mCiudadDAO.obtener(1L);
			assertTrue(mCiudad != null);
		} catch (MyException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	/**
	 * Caso de prueba para el metodo que guarda una ciudad 
	 * en la base de datos
	 */	
	@Test
	public void testGuardar() {
		CiudadPOJO mCiudad = null;
		try {
			mCiudad = new CiudadPOJO();
			mCiudad.setCodigo(70L);
			mCiudad.setNombre("miCiudad");
			
						
			mCiudadDAO.guardar(mCiudad);
			
			assertTrue(mCiudadDAO.obtener(70L) != null);
		} catch (MyException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}


}
