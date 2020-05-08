package Repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import entity.Participant;
import entity.Sondage;
import jpa.EntityManagerHelper;

public class ParticipantRepository {
	
	static EntityManager manager = EntityManagerHelper.getEntityManager();
	
	//Recuperation de liste des participants
	
	public static List<Participant> getListParticipant() {
		
		Query query = manager.createQuery("select p from Participant as p");
		
		return query.getResultList();
		
	}
	
	public static Participant getParticipantById(String id) {
		
		return manager.find(Participant.class, Long.valueOf(id));
	}
	
	public static Participant deleteParticipant(String id) {
		
		Participant p = getParticipantById(id);
		
		if(p!=null) {
			manager.getTransaction().begin();
			
			manager.remove(p);
			
			manager.getTransaction().commit();
		}
		return p;
	}
	


}
