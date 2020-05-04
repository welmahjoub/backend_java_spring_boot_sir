package Repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import entity.Proposition;
import entity.Sondage;
import jpa.EntityManagerHelper;

public class SondageRepository {

	static EntityManager manager = EntityManagerHelper.getEntityManager();
	

	public static List<Sondage> getListeSondage()
	{
		
		Query q=manager.createQuery("select a from Sondage as a ");
		
		return q.getResultList();
	}
	
	public static Sondage persistSondage(Sondage s)
	{
		manager.getTransaction().begin();
		manager.persist(s);
		manager.getTransaction().commit();
		
		return s;
		
	}
	
	
	
	public static Sondage deleteSondage(String id)
	{
		manager.getTransaction().begin();
		Sondage s=findById(id);
		if(s!=null)
		{
			manager.remove(s);
			manager.getTransaction().commit();
			
		}
		return s;
		
	}
	
	public static Sondage deleteAllProposition(String idSondage)
	{
		
		Sondage s=findById(idSondage);
		
		if(s!=null)
		{
			manager.getTransaction().begin();
			
			for (int i = 0; i < s.getDateProposees().size(); i++) {
				
				s.getDateProposees().remove(i);
			}
			
			manager.getTransaction().commit();
			
			
		}
		return s;
		
	}
	
	public static Sondage findById(String id)
	{
		return manager.find(Sondage.class, Long.valueOf(id));
		
	}
	
	public static List<Sondage> findByIdUser(String id)
	{
		
		Query q=manager.createQuery("select a from Sondage a join a.user u on u.id ="+id);
		
		return q.getResultList();
		
	}
	
	public static Proposition findPropositionById(String id)
	{
		return manager.find(Proposition.class, Long.valueOf(id));
		
	}
	
}
