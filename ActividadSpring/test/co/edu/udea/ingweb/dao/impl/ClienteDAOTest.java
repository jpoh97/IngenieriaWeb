package co.edu.udea.ingweb.dao.impl;


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

import co.edu.udea.ingweb.dao.ClienteFacade;
import co.edu.udea.ingweb.dao.UsuarioFacade;
import co.edu.udea.ingweb.dto.ClientePOJO;
import co.edu.udea.ingweb.dto.RolPOJO;
import co.edu.udea.ingweb.dto.UsuarioPOJO;
import co.edu.udea.ingweb.exception.MyException;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations="classpath:configuration.xml")
public class ClienteDAOTest {

	@Autowired
	private ClienteFacade mClienteDAO;
	
	/**
	 * Caso de prueba para el metodo obtener que retorna el 
	 * listado con todos los clientes
	 */
	@Test
	public void testObtenerTodos() {
		List<ClientePOJO> mList = null;
		try {
			mList = mClienteDAO.obtener();
			assertTrue(mList.size() > 0);
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
		ClientePOJO mCliente = null;
		try {
			mCliente = mClienteDAO.obtener("1111");
			assertTrue(mCliente != null);
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
		ClientePOJO mCliente = null;
		UsuarioPOJO mUsuario = null;
		try {
			mCliente = new ClientePOJO();
			mCliente.setCedula("202010");
			mCliente.setNombres("neyder");
			mCliente.setApellidos("yesid morantes");
			mCliente.setEmail("elneyder@gmail.com");
			mCliente.setFechaCreacion(new Date());
			
			mUsuario = new UsuarioPOJO();
			mUsuario.setLogin("elver");
			
			mCliente.setUsuarioCrea(mUsuario);
						
			mClienteDAO.guardar(mCliente);
			
			assertTrue(mClienteDAO.obtener("202010") != null);
		} catch (MyException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}
