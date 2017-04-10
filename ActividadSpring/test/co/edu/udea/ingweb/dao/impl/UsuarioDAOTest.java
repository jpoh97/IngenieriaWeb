package co.edu.udea.ingweb.dao.impl;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.ingweb.dao.CiudadFacade;
import co.edu.udea.ingweb.dao.UsuarioFacade;
import co.edu.udea.ingweb.dto.CiudadPOJO;
import co.edu.udea.ingweb.dto.ClientePOJO;
import co.edu.udea.ingweb.dto.RolPOJO;
import co.edu.udea.ingweb.dto.UsuarioPOJO;
import co.edu.udea.ingweb.exception.MyException;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations="classpath:configuration.xml")
public class UsuarioDAOTest {

	@Autowired
	private UsuarioFacade mUsuarioDAO;
	
	@Test
	public void testObtenerTodos() {
		List<UsuarioPOJO> mList = null;
		try {
			mList = mUsuarioDAO.obtener();
			assertTrue(mList.size() > 0);
		} catch (MyException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testObtener() {
		UsuarioPOJO mUsuario = null;
		try {
			mUsuario = mUsuarioDAO.obtener("juan");
			assertTrue(mUsuario != null);
			System.out.println(mUsuario.getLogin() + " posee un rol "
					+ "de " + mUsuario.getRol().getNombre());
		} catch (MyException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testGuardar() {
		UsuarioPOJO mUsuario = null;
		RolPOJO mRol = null;
		try {
			mUsuario  = new UsuarioPOJO();
			mRol  = new RolPOJO();
			mUsuario.setNombre("nombre");
			mUsuario.setLogin("logintest");
			mUsuario.setContrasena("contraseña");
			mUsuario.setApellido("apellido");
			mRol .setCodigo("ADM");
			mUsuario.setRol(mRol);

			mUsuarioDAO.guardar(mUsuario);
			assertTrue(null != mUsuarioDAO.obtener("logintest"));
		} catch (MyException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
}
