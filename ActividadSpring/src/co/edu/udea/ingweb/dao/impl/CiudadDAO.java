package co.edu.udea.ingweb.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Transaction;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import co.edu.udea.ingweb.dao.CiudadFacade;
import co.edu.udea.ingweb.dto.CiudadPOJO;
import co.edu.udea.ingweb.exception.MyException;

public class CiudadDAO implements CiudadFacade {

	private SessionFactory mSessionFactory;
	
	
	public SessionFactory getSessionFactory() {
		return mSessionFactory;
	}

	public void setSessionFactory(SessionFactory mSessionFactory) {
		this.mSessionFactory = mSessionFactory;
	}

	/**
	 * Implemento el método para obtener un listado con todas las ciudades
	 */
	@Override
	public List<CiudadPOJO> obtener() throws MyException {
		List<CiudadPOJO> mList = new ArrayList<>(); //listado con todas las ciudades
		Session mSession = null;
		try {
			mSession = mSessionFactory.getCurrentSession();
			Criteria mCriteria = mSession.createCriteria(CiudadPOJO.class);			
			//Se guarda la lista de ciudades
			mList = mCriteria.list();
		} catch (HibernateException e) {
			throw new MyException("Error consultando ciudades", e);
		} 
		return mList;
	}

	/**
	 * Implemento el método para obtener una ciudad
	 */
	@Override
	public CiudadPOJO obtener(Long codigo) throws MyException {
		CiudadPOJO mCiudad = new CiudadPOJO(); //Ciudad que voy a retornar 
		Session mSession = null;
		try {
			mSession = mSessionFactory.getCurrentSession();
			//funciona con la clave primaria
			mCiudad = (CiudadPOJO) mSession.get(CiudadPOJO.class, codigo);
			/* Manera un poco menos eficiente
			Criteria mCriteria = mSession.createCriteria(CiudadPOJO.class);
			mCriteria.add(Restrictions.eq("codigo", codigo));
			mCiudad = (CiudadPOJO) mCriteria.uniqueResult();*/
		} catch (HibernateException e) {
			throw new MyException("Error consultando la ciudad solicitada", e);
		} 
		return mCiudad;
	}

	/**
	 * 
	 */
	@Override
	public void guardar(CiudadPOJO mCiudad) throws MyException {
		Session mSession = null;
		try {
			mSession = mSessionFactory.getCurrentSession();
			
			mSession.save(mCiudad);
			//saveOrUpdate (la agrega si no existe, en caso de existir la actualiza)
			//delete - update
		} catch (HibernateException e) {
			throw new MyException("Error agregando la ciudad", e);
		} 
	}
	
	

}
