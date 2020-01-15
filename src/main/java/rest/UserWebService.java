package rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import Repository.UserRepository;
import entity.Utilisateur;

@Path("/users")
public class UserWebService {


	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public List<String> getUsers() {
		
		List<Utilisateur>  liste =UserRepository.getListeUser();
		List<String> names=new ArrayList<String>();
		for (Utilisateur e : liste) {
			names.add(e.getNom());
		}
		
		return names;
	}

}
