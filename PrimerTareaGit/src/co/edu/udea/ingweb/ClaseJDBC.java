package co.edu.udea.ingweb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 
 * @author jpoh97
 *
 *Clase para realizar la conexión a la base de datos
 *a través de JDBC. Contiene el método para consultar 
 *las ciudades de la base de datos clase
 */
public class ClaseJDBC {

	public static void main(String[] args) {
		
		consultarCiudades();
	}
	
	/**
	 * Método para consultar todas las ciudades de la tabla
	 */
	
	public static void consultarCiudades() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/clase", "root", "root");
			ps = conn.prepareStatement("select * from ciudades");
			rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString("codigo") + ": " + rs.getString("Nombre"));
			}
			conn.close();
		} catch (ClassNotFoundException e) { //Capturo todas las posibles excepciones
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				conn.close(); 
				//Cierro las conexiones a la BD
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
