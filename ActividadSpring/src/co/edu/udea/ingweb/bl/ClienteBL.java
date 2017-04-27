package co.edu.udea.ingweb.bl;

import java.util.Date;
import java.util.List;

import co.edu.udea.ingweb.dao.ClienteFacade;
import co.edu.udea.ingweb.dao.UsuarioFacade;
import co.edu.udea.ingweb.dao.impl.ClienteDAO;
import co.edu.udea.ingweb.dao.impl.UsuarioDAO;
import co.edu.udea.ingweb.dto.ClientePOJO;
import co.edu.udea.ingweb.exception.MyException;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import org.springframework.transaction.annotation.Transactional;


/**
 *Clase creada para desarrollar la lógica 
 *del negocio del cliente
 *
 *Se encuentra en el paquete bl
 *
 * @author Juan Pablo Ospina Herrera
 * @since 1.8
 * @version 1.0 
 * 
 */

@Transactional
public class ClienteBL {
	
	private ClienteFacade clienteDao;	
	private UsuarioFacade usuarioDao;
	
	public UsuarioFacade getUsuarioDao() {
		return usuarioDao;
	}

	public void setUsuarioDao(UsuarioFacade usuarioDao) {
		this.usuarioDao = usuarioDao; 
	}

	public ClienteFacade getClienteDao() {
		return clienteDao;
	}

	public void setClienteDao(ClienteFacade mClienteDao) {
		this.clienteDao = mClienteDao;
	}

	/**
	 * Lógica del negocio del metodo para obtener todos los clientes	
	 * @return List<ClientePOJO> listado con clientes
	 * @throws MyException Manejo mi excepción en caso de errores
	 */
	public List<ClientePOJO> obtener() throws MyException {
		return clienteDao.obtener();
	}
	
	/**
	 * Lógica del negocio del metodo para obtener un cliente apartir de su cedula	
	 * @return ClientePOJO Cliente con la cédula especificada
	 * @throws MyException Manejo mi excepción en caso de errores
	 */
	public ClientePOJO obtenerCliente(String cedula) throws MyException {
		return clienteDao.obtener(cedula);
	}
	
	/**
	 * Lógica del negocio del metodo para guarda un cliente en la base de datos	 * 
	 * @param cedula Identificación del cliente
	 * @param nombre Nombres del cliente
	 * @param apellido Apellidos del cliente
	 * @param email Correo electronico del cliente
	 * @param usuarioCrea Login del usuario que crea al cliente
	 * @throws MyException Manejo mi excepción en caso de errores
	 */
	public void guardar(String cedula, String nombre, String apellido, 
			String email, String usuarioCrea) throws MyException {
		
		isValidField(cedula, "cedula");
		isValidField(nombre, "nombre");
		isValidField(apellido, "apellido");
		isValidField(email, "correo electronico");
		isValidField(usuarioCrea, "usuario que crea");
		
		if(!isValidEmail(email)) {
			throw new MyException("El correo tiene un formato inválido :'c");
		}
		
		if(clienteDao.obtener(cedula) != null) {
			throw new MyException("La cédula asociada al cliente ya esta registrada");
		}
						
		if(usuarioDao.obtener(usuarioCrea) == null) {
			throw new MyException("El usuario no existe");
		}
				
		ClientePOJO mCliente = new ClientePOJO();
		mCliente.setCedula(cedula);
		mCliente.setApellidos(apellido);
		mCliente.setNombres(nombre);
		mCliente.setEmail(email);
		mCliente.setUsuarioCrea(usuarioDao.obtener(usuarioCrea));
		mCliente.setFechaCreacion(new Date());
		
		clienteDao.guardar(mCliente);
		
	}
		
	/**
	 * Metodo que me permite determinar si un correo electronico es valido.
	 * Utiliza la clase InternetAddress del jar javax.mail 
	 * @param email Correo electronico a validar
	 * @return result Booleano que especifica si el correo es valido
	 */
	public boolean isValidEmail(String email) {
	    boolean result = true;
	    try {
	        InternetAddress emailAddr = new InternetAddress(email);
	        emailAddr.validate();
	    } catch (AddressException ex) {
	        result = false;
	    }
	    System.out.println("==> "+result+" : "+email);
	    return result;
	}
	
	/**
	 * Metodo que permite validar si un campo es nulo o vacio
	 * @param text Texto a analizar
	 * @param field Nombre del campo a analizar
	 * @throws MyException En caso de ser nulo o vacio muestro excepcion
	 */
	public void isValidField(String text, String field) throws MyException {
		if(text == null) {
			throw new MyException("El campo " + field + " no puede ser nulo");
		}
		if(text.trim().equalsIgnoreCase("")) {
			throw new MyException("El campo " + field + " no puede estar vacio");
		}
	}
}
