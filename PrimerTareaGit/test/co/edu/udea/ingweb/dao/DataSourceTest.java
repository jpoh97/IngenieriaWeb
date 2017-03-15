package co.edu.udea.ingweb.dao;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.Test;

import co.edu.udea.ingweb.exception.MyException;


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
