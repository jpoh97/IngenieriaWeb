package co.edu.udea.ingweb.dao.impl;

/**
 *Clase creada para implementar todos los metodos
 *del cliente en la base de Datos
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

import co.edu.udea.ingweb.dao.ClienteFacade;
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
	
	/**
	 * Implementacion del metodo para obtener la lista de clientes en la base de datos	
	 * @return listado con clientes
	 * @throws MyException
	 */
	@Override
	public List<ClientePOJO> obtener() throws MyException {
		List<ClientePOJO> mList = new ArrayList<ClientePOJO>();
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

	/**
	 * Implementacion del metodo para obtener un cliente de la base de datos
	 * a partir de su cedula
	 * @return objeto que represanta el cliente solicitado
	 * @throws MyException
	 */
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

	/**
	 * Implementacion del metodo que permite guardar un cliente nuevo en la base de datos
	 * @param mCliente (cliente a guardar)
	 * @throws MyException
	 */
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
