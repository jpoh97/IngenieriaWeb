package co.edu.udea.ingweb.bl;

/**
 *Clase creada para realizar las pruebas de
 *los metodos del cliente 
 *
 *Se encuentra en la carpeta Test
 *
 * @author Juan Pablo Ospina Herrera
 * @since 1.8
 * @version 1.0 
 * 
 */


import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.ingweb.dao.CiudadFacade;
import co.edu.udea.ingweb.dto.CiudadPOJO;
import co.edu.udea.ingweb.dto.ClientePOJO;
import co.edu.udea.ingweb.dto.UsuarioPOJO;
import co.edu.udea.ingweb.exception.MyException;


@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations="classpath:configuration.xml")
public class ClienteBLTest {

	@Autowired
	private ClienteBL mClienteBL;
	
	/**
	 * Caso de prueba para el metodo obtener que retorna el 
	 * listado con todas las ciudades
	 */
	@Test
	public void testObtenerTodos() {
		try {
			assertTrue(mClienteBL.obtener().size() > 0);
		} catch (MyException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	/**
	 * Caso de prueba para el metodo obtener que retorna un
	 * cliente especifico a partir de la cedula	
	 */
	@Test
	public void testObtener() {
		try {
			assertTrue(mClienteBL.obtenerCliente("1111") != null);
		} catch (MyException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	/**
	 * Caso de prueba para el metodo que guarda un cliente 
	 * en la base de datos
	 */	
	@Test
	public void testGuardar() {
		try {
						
			mClienteBL.guardar("9876", "neyder", "yesid morantes"
					, "elneyder@gmail.com", "elver");
			assertTrue(mClienteBL.obtenerCliente("9876") != null);
		} catch (MyException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}
