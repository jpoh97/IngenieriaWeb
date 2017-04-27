package co.edu.udea.iw.ws;

import javax.ws.rs.PathParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;;

@Path("saludo")
public class PrimerEjemplo {

	@GET
	@Produces(MediaType.TEXT_HTML)	
	public String saludar() {
		return "Ciao";
	}
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	@Path("despedir/{name}")
	public String despedir(@PathParam("name") String name) {
		return "Buona sera " + name;
	}
	
	@POST
	@Produces(MediaType.TEXT_HTML)
	@Path("guardar")
	public String guardar(@QueryParam("name") String name) {
		return "guardando " + name; 
	}
}
