package co.edu.udea.ingweb.bl;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.ingweb.exception.MyException;

/**
 *Clase creada para realizar las pruebas de
 *los metodos del usuario 
 *
 *Se encuentra en la carpeta Test
 *
 * @author Juan Pablo Ospina Herrera
 * @since 1.8
 * @version 1.0 
 * 
 */

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations="classpath:configuration.xml")
public class UsuarioBLTest {
	
	@Autowired
	private UsuarioBL mUsuarioBL;

	/**
	 * Caso de prueba para el metodo obtener que retorna el 
	 * listado con todas los usuarios
	 */
	@Test
	public void testObtenerTodos() {
		try {
			assertTrue(mUsuarioBL.getAll().size() > 0);
		} catch (MyException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	/**
	 * Caso de prueba para el metodo obtener que retorna un
	 * usuario especifico a partir del login	
	 */
	@Test
	public void testObtener() {
		try {
			assertTrue(mUsuarioBL.get("elver") != null);
		} catch (MyException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	/**
	 * Caso de prueba para el metodo que guarda un usuario
	 * en la base de datos
	 */	
	@Test
	public void testGuardar() {
		try {
						
			mUsuarioBL.saveUser("jp", "Aquiles", "Voy", "1234jp12", "ADM");
			assertTrue(mUsuarioBL.get("jp") != null);
		} catch (MyException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	/**
	 * Caso de prueba para el metodo que verifica las credenciales
	 * de logeo de un usuario (login, password)
	 */
	@Test
	public void testLogin() {
		try {
			assertTrue(mUsuarioBL.validateLogin("elver", "1g0/KkFdhrmg1DYJWFdd2A=="));
		} catch (MyException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
}
