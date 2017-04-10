package co.edu.udea.ingweb.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

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
