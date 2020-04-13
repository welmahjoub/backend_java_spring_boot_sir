package apiRest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import Repository.ChoixRepository;
import Repository.ReunionRepository;
import Repository.SondageRepository;
import Repository.UserRepository;
import Utils.Util;
import dto.SondageDto;
import dto.UserDto;
import dto.choixDto;
import dto.valideDto;
import entity.Choix;
import entity.DateReunion;
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
		
		User user;
		Sondage s = null;
		Reunion r=null;
		List<DateReunion> proposition;
		
		user=UserRepository.findById(data.getIdUser());
		proposition=new ArrayList<DateReunion>();
		
		
		r=new Reunion(data.getIntitule(), data.getResume(), s) ;
		
		s=new Sondage(proposition, user, r);
		
//		r.setSondage(s);
		
		for (String date : data.getDates()) {
			 
			Date d=Util.convertirDate(date);
			DateReunion dr=new DateReunion(s, d);
			proposition.add(dr);
		}

		s= SondageRepository.addSondage(s);

		//ReunionRepository.addReunion(r);
		
		return "ok ajouter  effectuer";
	}
	
	@GET
	@Path("/get/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Sondage getSondage(@PathParam ("id") String idsondage) {
		
		return SondageRepository.findById(idsondage);
	}
	
	@POST
	@Path("/participer")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String particuper(choixDto c) {
		
		UserDto u = new UserDto(c.getNom(),c.getPrenom(),c.getMail(), c.getPassword());
		
		
		User user=UserRepository.addUser(u);

		Sondage sond = SondageRepository.findById(c.getIdSondage());
		
		Choix choix = new Choix(Util.convertirDate(c.getDate()), user, sond);
		
		ChoixRepository.addChoix(choix);
		
		return "ok ajout choix effectuer";
	}
	
	@POST
	@Path("/valider")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String validerDate(valideDto dateChoisie) {
		
		Date dateReunion = Util.convertirDate(dateChoisie.getDate());
		
		Sondage sond = SondageRepository.findById(dateChoisie.getId());
		
		System.err.println( sond.getDateProposees());
		
		
	if( sond != null && Util.isExiste(sond.getDateProposees(), dateReunion)) {
		
		sond.setDatereunion(dateReunion);
		SondageRepository.addSondage(sond);
		
		return "Valider ok";
	}
	
	return "Valider not ok";
		
		
	}

}
