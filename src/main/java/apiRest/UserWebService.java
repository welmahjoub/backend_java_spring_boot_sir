package apiRest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import Repository.UserRepository;
import entity.User;

@Path("/users")
public class UserWebService {


	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getUsers() {
		
		return UserRepository.getListeUser();
	}
	
	/*@POST
	@Path("/addUser")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String addUser(User u) {
		UserRepository.addUser(u);
		
		return "ok ajouter effectuer";
	}*/

}
