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
import Utils.ApiPadUtil;
import Utils.DateUtil;
import Utils.sendMailUtil;
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
	@Produces(MediaType.APPLICATION_JSON)
	public boolean addSondage(SondageDto  data) {
		
		
		User user=UserRepository.findById(data.getIdUser());
		List<Proposition> proposition=new ArrayList<Proposition>();
		
		Reunion reunion=new Reunion(data.getIntitule(), data.getResume()) ;
		
		
		
		Sondage sondage=new Sondage(proposition, user, reunion);
		
		reunion.setSondage(sondage);
		
		for (String date : data.getDates()) {
			 
			Date d=DateUtil.convertirDate(date);
			Proposition dr=new Proposition(sondage, d);
			proposition.add(dr);
		}

		SondageRepository.persistSondage(sondage);
		
		sondage.getReunion().setLienPad("localhost:9001/p/"+sondage.getId());
		sondage.setLien("participe/"+sondage.getId());
	
		
		ApiPadUtil.createPad(String.valueOf(sondage.getId()), data.getIntitule(), data.getResume());
		
		
		SondageRepository.persistSondage(sondage);
		
		return true;
	}
	
	@PUT
	@Path("/edit/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public boolean editSondage(@PathParam("id") String idSondage,SondageDto  data) {
		
		Sondage sondage=SondageRepository.findById(idSondage);
		
		if( sondage != null)
		{
			
			
			sondage.getReunion().setIntitule(data.getIntitule()); 
			sondage.getReunion().setResume(data.getResume());
			
			
			
			for (String date : data.getDates()) {
				 
				Date d=DateUtil.convertirDate(date);
				Proposition dr=new Proposition(sondage, d);
				
				sondage.getDateProposees().add(dr);			}
			
			SondageRepository.persistSondage(sondage);
			
			return true;
		}
		
		return false;
		
	}
	
	@DELETE
	@Path("/delete/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public boolean deleteSondage(@PathParam ("id") String idsondage) {
		
		 if(SondageRepository.deleteSondage(idsondage)!=null) {
			 ApiPadUtil.deletePad(idsondage);
			 return true;
		 }
		 else {
			 return false;
			 }
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
    @Produces(MediaType.APPLICATION_JSON)
    public boolean particuper(ParticipantDto data) {
  

	  Participant part = new Participant(data.getNom(),data.getPrenom(),data.getMail(), 
			  							 data.getPreferences(), data.getAllergies());
	  
	  Proposition prop=SondageRepository.findPropositionById(data.getIdProposition());
	  
	  if(prop != null)
	  {
		  part.setProposition(prop);
		  prop.getUsers().add(part);
		  
		  SondageRepository.persistSondage(prop.getSondage()); 
		  
		  return true;
	  }
	  
	  return false;
	 
	  
	 
     }
	 
	
	 @POST
	 @Path("/valider/{id}")
	 @Produces(MediaType.APPLICATION_JSON)
	 public boolean validerDate(@PathParam("id") String idProposition) {
		 
		 StringBuilder corpsMsg = new StringBuilder("La date final de la reunion est fixée au ");
		 StringBuilder addresses = new StringBuilder("");
		Proposition proposition = SondageRepository.findPropositionById(idProposition);
		
		corpsMsg.append(proposition.getDate())	;
		corpsMsg.append(" lien pad :"+proposition.getSondage().getReunion().getLienPad());
		
		if( proposition != null) {
			
			Sondage sond =proposition.getSondage();
			
			sond.setDatereunion(proposition.getDate());
			sond.setClos(true);
			
			SondageRepository.persistSondage(sond);
			

			 int i = 0;
			 
			for( Participant participant: proposition.getUsers()) {
				
				addresses.append(participant.getMail());
				
				if(i++ == proposition.getUsers().size() - 1){
			        // Last iteration
			    }
				{
					addresses.append(",");
				}
			}
			
			
			sendMailUtil.sendMail(corpsMsg, addresses);
			
			return true;
		}
	
		return false;
		
	 }

}
