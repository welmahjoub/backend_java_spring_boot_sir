package apiRest;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import Repository.ParticipantRepository;
import entity.Participant;

@Path("/participants")
public class ParticipantWebService {
	
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Participant> getParticipants(){
		return ParticipantRepository.getListParticipant();
	}
	
	@GET
	@Path("/get/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Participant getParticipant(@PathParam("id") String idParticipant){
		return ParticipantRepository.getParticipantById(idParticipant);
	}
	
	@DELETE
	@Path("/delete/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public boolean deleteParticipant(@PathParam("id") String idParticipant){
		if(ParticipantRepository.deleteParticipant(idParticipant) !=null) {
			return true;
		}
		return false;
	}
	
	

}
