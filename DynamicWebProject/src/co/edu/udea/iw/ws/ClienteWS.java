package co.edu.udea.iw.ws;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.edu.udea.ingweb.bl.ClienteBL;
import co.edu.udea.ingweb.dto.ClientePOJO;
import co.edu.udea.ingweb.exception.MyException;

import co.edu.udea.iw.dto.Cliente;

@Component
@Path("client")
public class ClienteWS {
	
	@Autowired
	private ClienteBL mClientBL;
	
	@POST
	@Produces(MediaType.TEXT_HTML)
	@Path("save")
	public void guardar(@QueryParam("id") String cedula, 
			@QueryParam("name") String nombres,
			@QueryParam("lastname") String apellidos,
			@QueryParam("email") String email,
			@QueryParam("user") String usuarioCrea) throws MyException {
			
		try{
			
			mClientBL.guardar(cedula, nombres, apellidos, email, usuarioCrea);			
			
		} catch (MyException e) {
			throw new MyException("Error en la operación", e);
		}		
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("getAll")
	public List<Cliente> obtener() throws MyException {
		List<Cliente> mList = new ArrayList<Cliente>();
		Cliente mClient;
		try {
			for(ClientePOJO c : mClientBL.obtener()) {
				mClient = new Cliente(c.getCedula(), 
						c.getNombres(), 
						c.getApellidos(), 
						c.getEmail());
				
				mList.add(mClient);
			}
			
		} catch (MyException e) {
			throw new MyException("Problema consultando los clientes", e);
		}
		
		return mList;
	}
	
	
}

