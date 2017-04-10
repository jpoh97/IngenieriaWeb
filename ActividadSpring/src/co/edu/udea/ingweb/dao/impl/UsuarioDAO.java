package co.edu.udea.ingweb.dao.impl;

/**
 *Clase creada para implementar todos los metodos
 *del usuario en la base de Datos
 *
 *Se encuentra en el paquete DAO.Impl
 *
 * @author Juan Pablo Ospina Herrera
 * @since 1.8
 * @version 1.0 
 * 
 */

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import co.edu.udea.ingweb.dao.UsuarioFacade;
import co.edu.udea.ingweb.dto.UsuarioPOJO;
import co.edu.udea.ingweb.exception.MyException;

public class UsuarioDAO implements UsuarioFacade {
	
	private SessionFactory mSessionFactory;
	
	
	public SessionFactory getSessionFactory() {
		return mSessionFactory;
	}

	public void setSessionFactory(SessionFactory mSessionFactory) {
		this.mSessionFactory = mSessionFactory;
	}

	/**
	 * Implementación del metodo para obtener la lista de usuarios en la base de datos	
	 * @return listado con usuarios
	 * @throws MyException
	 */
	@Override
	public List<UsuarioPOJO> obtener() throws MyException {
		List<UsuarioPOJO> mList = new ArrayList<>(); 
		Session mSession = null;
		try {
			mSession = mSessionFactory.getCurrentSession();
			Criteria mCriteria = mSession.createCriteria(UsuarioPOJO.class);
			mList = mCriteria.list();
		} catch (HibernateException e) {
			throw new MyException("Error consultando usuarios", e);
		} 
		return mList;
	}

	/**
	 * Implementación del metodo para obtene un usuario de la base de datos
	 * a partir de su identificador login
	 * @return objeto que represanta el usuario solicitado
	 * @throws MyException
	 */
	@Override
	public UsuarioPOJO obtener(String mLogin) throws MyException {
		UsuarioPOJO mUsuario = new UsuarioPOJO();  
		Session mSession = null;
		try {
			mSession = mSessionFactory.getCurrentSession();
			mUsuario = (UsuarioPOJO) mSession.get(UsuarioPOJO.class, mLogin);
		} catch (HibernateException e) {
			throw new MyException("Error consultando el usuario solicitado", e);
		}
		return mUsuario;
	}

	/**
	 * Implementación del metodo que permite guardar un usuario nuevo en la base de datos
	 * @param mUsuario (usuario a guardar)
	 * @throws MyException
	 */
	@Override
	public void guardar(UsuarioPOJO mUsuario) throws MyException {
		Session mSession = null;
		try {
			mSession = mSessionFactory.getCurrentSession();
			mSession.save(mUsuario);
		} catch (HibernateException e) {
			throw new MyException("Error agregando el usuario", e);
		} 	
		
	}

}
