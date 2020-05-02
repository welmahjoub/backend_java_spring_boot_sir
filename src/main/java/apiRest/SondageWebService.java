package apiRest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import Repository.SondageRepository;
import Repository.UserRepository;
import Utils.Util;
import dto.ParticipantDto;
import dto.SondageDto;
import entity.Participant;
import entity.Proposition;
import entity.Reunion;
import entity.Sondage;
import entity.User;

@Path("/sondage")
public class SondageWebService {


	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Sondage> getSondage() {
		
		return SondageRepository.getListeSondage();
	}
	
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String addSondage(SondageDto  data) {
		
		
		User user=UserRepository.findById(data.getIdUser());
		List<Proposition> proposition=new ArrayList<Proposition>();
		
		Reunion reunion=new Reunion(data.getIntitule(), data.getResume()) ;
		
		Sondage sondage=new Sondage(proposition, user, reunion);
		
		reunion.setSondage(sondage);
		
		for (String date : data.getDates()) {
			 
			Date d=Util.convertirDate(date);
			Proposition dr=new Proposition(sondage, d);
			proposition.add(dr);
		}

		SondageRepository.persistSondage(sondage);
		
		return "ok ajouter  effectuer";
	}
	
	@PUT
	@Path("/edit/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public String editSondage(@PathParam("id") String idSondage,SondageDto  data) {
		
		Sondage sondage=SondageRepository.findById(idSondage);
		
		if( sondage != null)
		{
			sondage.getReunion().setIntitule(data.getIntitule()); 
			sondage.getReunion().setResume(data.getResume());
			
			List<Proposition> proposition=new ArrayList<Proposition>();
			
			for (String date : data.getDates()) {
				 
				Date d=Util.convertirDate(date);
				Proposition dr=new Proposition(sondage, d);
				proposition.add(dr);
			}
			
			sondage.setDateProposees(proposition);
			SondageRepository.persistSondage(sondage);
			
			return " modif ok";
		}
		
		return " modif not ok";
		
	}
	
	@DELETE
	@Path("/delete/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteSondage(@PathParam ("id") String idsondage) {
		
		 if(SondageRepository.deleteSondage(idsondage)!=null)
			 return " delete ok ";
		 else
			 return " delete not ok ";
	}
	
	@GET
	@Path("/get/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Sondage getSondage(@PathParam ("id") String idsondage) {
		
		return SondageRepository.findById(idsondage);
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Sondage> getSondagesByIdUser(@PathParam ("id") String idUser) {
		
	
		return SondageRepository.findByIdUser(idUser);
	}
	
	
    @POST
    @Path("/participer")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String particuper(ParticipantDto data) {
  
	  Participant part = new Participant(data.getNom(),data.getPrenom(),data.getMail());
	  
	  Proposition prop=SondageRepository.findPropositionById(data.getIdProposition());
	  
	  if(prop != null)
	  {
		  part.setProposition(prop);
		  prop.getUsers().add(part);
		  
		  SondageRepository.persistSondage(prop.getSondage()); 
		  
		  return "ok ajout participant effectuer";
	  }
	  
	  return "participation not ok";
	 
	  
	 
     }
	 
	
	 @GET
	 @Path("/valider/{id}")
	 @Produces(MediaType.TEXT_PLAIN)
	 public String validerDate(@PathParam("id") String idProposition) {
		
		
		Proposition proposition = SondageRepository.findPropositionById(idProposition);
		
		
		if( proposition != null) {
			
			Sondage sond =proposition.getSondage();
			
			sond.setDatereunion(proposition.getDate());
			
			SondageRepository.persistSondage(sond);
			
			return "Valider ok";
		}
	
		return "Valider not ok";
		
	 }

}
