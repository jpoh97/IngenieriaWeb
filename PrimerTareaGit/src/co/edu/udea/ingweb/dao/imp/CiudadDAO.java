package co.edu.udea.ingweb.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.edu.udea.ingweb.dao.CiudadFacade;
import co.edu.udea.ingweb.dao.DataSource;
import co.edu.udea.ingweb.dto.CiudadPOJO;
import co.edu.udea.ingweb.exception.MyException;

/**
 *
 *Clase DAO que permite implementar la lógica de la aplicación
 *
 * @author jpoh97
 * @since 1.8
 * @version 1.0
 *
 */

public class CiudadDAO implements CiudadFacade {
	
	/**
	 * Método para obtener el listado de ciudades 
	 * almacenadas en la base de datos
	 * 
	 * @return listado de ciudades
	 * @throws Manejo mis excepciones en el meto  
	 */
	@Override
	public List<CiudadPOJO> obtener() throws MyException {
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<CiudadPOJO> mList = new ArrayList<>(); //listado con todas las ciudades
		
		try {			
			conn = DataSource.getInstance().getConnection();
			ps = conn.prepareStatement("select * from ciudades");
			rs = ps.executeQuery();
			while (rs.next()) {
				CiudadPOJO mMyCiudad = new CiudadPOJO();
				mMyCiudad.setCodigo(rs.getLong("codigo"));
				mMyCiudad.setNombre(rs.getString("Nombre"));
				mMyCiudad.setCodigoArea(rs.getString("codigoArea"));
				mList.add(mMyCiudad);
			}					
		} catch (SQLException e) {
			throw new MyException("Error consultando", e);
		} finally {
			try {
				//Cierro las conexiones a la BD
				if(rs != null) {
					rs.close();
				}
				if(ps != null) {
					ps.close();
				}
				if(conn != null) {
					conn.close(); 
				}
			} catch (SQLException e) {
				throw new MyException("Error cerrando las conexiones", e);
			}
		}
		
		return mList;
	}
	
	/**
	 * Método para obtener una ciudad especifica
	 * almacenadas en la base de datos a través de su codigo o ID
	 * 
	 * @return objeto de la clase ciudad
	 * @throws Manejo mis excepciones en el metodo  
	 */
	@Override
	public CiudadPOJO obtener(Long codigo) throws MyException {
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		CiudadPOJO mCiudad = new CiudadPOJO(); //Ciudad que voy a retornar
		
		try {			
			conn = DataSource.getInstance().getConnection();
			ps = conn.prepareStatement("select * from ciudades where codigo=?");
			ps.setLong(1, codigo);
			rs = ps.executeQuery();
			if(rs.next()) {
				mCiudad = new CiudadPOJO();
				mCiudad.setCodigo(rs.getLong("codigo"));
				mCiudad.setNombre(rs.getString("Nombre"));
				mCiudad.setCodigoArea(rs.getString("codigoArea"));
			}					
		} catch (SQLException e) {
			throw new MyException("Error consultando", e);
		} finally {
			try {
				//Cierro las conexiones a la BD
				if(rs != null) {
					rs.close();
				}
				if(ps != null) {
					ps.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				throw new MyException("Error cerrando las conexiones", e);
			}
		}
		
		return mCiudad;
		
	
	}
	
}
