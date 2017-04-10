package co.edu.udea.ingweb.dao.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

import co.edu.udea.ingweb.dao.ClienteFacade;
import co.edu.udea.ingweb.dto.CiudadPOJO;
import co.edu.udea.ingweb.dto.ClientePOJO;
import co.edu.udea.ingweb.exception.MyException;

public class ClienteDAO implements ClienteFacade {

	private SessionFactory mSessionFactory;
	
	
	public SessionFactory getSessionFactory() {
		return mSessionFactory;
	}

	public void setSessionFactory(SessionFactory mSessionFactory) {
		this.mSessionFactory = mSessionFactory;
	}
	
	@Override
	public List<ClientePOJO> obtener() throws MyException {
		List<ClientePOJO> mList = new ArrayList<>();
		Session mSession = null;
		try {
			mSession = mSessionFactory.getCurrentSession();
			Criteria mCriteria = mSession.createCriteria(ClientePOJO.class);
			//mCriteria.addOrder(Order.asc("fechaCreacion"));
			mList = mCriteria.list();
		} catch (HibernateException e) {
			throw new MyException("Error consultando clientes", e);
		} 
		return mList;
	}

	@Override
	public ClientePOJO obtener(String cedula) throws MyException {
		ClientePOJO mCliente = new ClientePOJO(); 
		Session mSession = null;
		try {
			mSession = mSessionFactory.getCurrentSession();
			mCliente = (ClientePOJO) mSession.get(ClientePOJO.class, cedula);
		} catch (HibernateException e) {
			throw new MyException("Error consultando al cliente solicitado", e);
		} 
		return mCliente;
	}

	@Override
	public void guardar(ClientePOJO mCliente) throws MyException {
		Session mSession = null;
		try {
			mSession = mSessionFactory.getCurrentSession();
			mSession.save(mCliente);
		} catch (HibernateException e) {
			throw new MyException("Error agregando al cliente", e);
		} 
		
	}

}
