package apiRest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import Repository.SondageRepository;
import Repository.UserRepository;
import Utils.Util;
import dto.SondageDto;
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
		
		for (String date : data.getDates()) {
			 
			Date d=Util.convertirDate(date);
			DateReunion dr=new DateReunion(s, d);
			proposition.add(dr);
		}

		SondageRepository.addSondage(s);
		
		return "ok ajouter  effectuer";
	}

}
