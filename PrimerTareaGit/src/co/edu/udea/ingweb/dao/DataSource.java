package co.edu.udea.ingweb.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import co.edu.udea.ingweb.exception.MyException;

/**
 * 
 *Clase que permite establecer la conexión con 
 *la base de Datos utilizando JDBC
 *
 * @author jpoh97
 * @since 1.8
 * @version 1.0
 * 
 */

public class DataSource {

	/**
	 * Método para establecer la conexión con la base de datos
	 * 
	 * @return variable de conexión
	 * @throws MyException
	 */
	public static Connection getConnection() throws MyException {
		Connection conn = null; //variable de conexión
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/clase", "root", "jpoh97");			
		} catch (ClassNotFoundException e) { //Capturo todas las posibles excepciones
			throw new MyException("Driver no encontrado", e);
		} catch (SQLException e) {
			throw new MyException("No puede establecer conexión", e);
		} 
		return conn;
	}

}
