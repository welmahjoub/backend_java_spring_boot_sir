package apiRest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import entity.Choix;

@Path("/hello")
public class SampleWebService {
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayHello() {
		return "Hello, how are you?";
	}


@GET
@Path("/home")
@Produces(MediaType.APPLICATION_JSON)
public Choix getHome() {
	Choix h = new Choix();
	h.setPreferenceAliments("Steak");
	return h;
}

}
