package co.edu.udea.iw.ws;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.edu.udea.ingweb.bl.UsuarioBL;
import co.edu.udea.ingweb.exception.MyException;

@Path("user")
@Component
public class UsuarioWS {
	
	@Autowired
	private UsuarioBL mUserBL;
	
	@POST
	@Produces(MediaType.TEXT_HTML)
	@Path("auth")
	public String autenticar(@QueryParam("login") String login, @QueryParam("password") String password) throws MyException {
			
		try{			
			
			mUserBL.validateLogin(login, password);			
			
		} catch (MyException e) {
			throw new MyException("Error en la operación", e);
		}
		
		return "Usuario logueado exitosamente";
	}
}
