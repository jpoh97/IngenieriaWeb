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

	private static DataSource mDataSource; //unica instancia de esta clase
	private static Connection conn;//variable de conexión
	
	public DataSource() {
		conn = null;
	}
	

	/**
	 * Metodo que retorna la única instancia que se puede 
	 * declarar de esta clase
	 * @return objeto singleton que representa la clase 
	 */
    public static DataSource getInstance(){
	    if(mDataSource==null){
	    	mDataSource = new DataSource();
	    }
    	return mDataSource;
    }
	
	/**
	 * Método para establecer la conexión con la base de datos
	 * 
	 * @return variable de conexión
	 * @throws MyException
	 */	
	public Connection getConnection() throws MyException {		
		try {
			if(conn == null || conn.isClosed()) {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/clase", "root", "jpoh97");	
			}			
		} catch (ClassNotFoundException e) { //Capturo todas las posibles excepciones
			throw new MyException("Driver no encontrado", e);
		} catch (SQLException e) {
			throw new MyException("No puede establecer conexión", e);
		} 
		return conn;
	}

}
