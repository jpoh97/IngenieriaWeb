package co.edu.udea.ingweb.dao;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.Test;

import co.edu.udea.ingweb.exception.MyException;

/**
 * 
 * Clase para realizar las pruebas en el DataSource
 * 
 * @author jpoh97
 * @since 1.8
 * @version 1.0
 *
 */
public class DataSourceTest {
	
	/**
	 * Metodo en el cual testeo que solo se cree una conexión a la
	 * base de datos.
	 */
	@Test
	public void test() {

		Connection conn1 = null;
		Connection conn2 = null;
		
		try {
			conn1 = DataSource.getInstance().getConnection();
			conn2 = DataSource.getInstance().getConnection();
			assertTrue( conn1 == conn2 );
		} catch (MyException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
}
