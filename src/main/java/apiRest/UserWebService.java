package apiRest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
	
	@GET
	@Path("/get/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public User getUser(@PathParam ("id") String idUser) {
		return UserRepository.findById(idUser);
	}
	

	@POST
	@Path("/add2")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String add(String nom, String prenom,String mail) {
		
		User u=new User(nom, prenom, mail);
		System.out.println(u.getNom()+" "+u.getMail()+" " + u.getPrenom());
		UserRepository.addUser(u);
		
		return "ok ajouter effectuer";
	}
	
	
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String addUser(User u) {
		
		System.out.println(u.getNom()+" "+u.getMail()+" " + u.getPrenom());
		UserRepository.addUser(u);
		
		return "ok ajouter effectuer";
	}

}
