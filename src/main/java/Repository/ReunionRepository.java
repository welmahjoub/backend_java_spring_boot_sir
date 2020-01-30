package Repository;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import entity.Reunion;
import entity.Sondage;
import entity.User;
import jpa.EntityManagerHelper;

public class ReunionRepository {

	static EntityManager manager = EntityManagerHelper.getEntityManager();
	
	
	
	public static List<Sondage> getListeSondage()
	{
		
		Query q=manager.createQuery("select a from Sondage");
		
		return q.getResultList();
	}
	
	public static void addReunion(Reunion r)
	{
		manager.getTransaction().begin();
		manager.persist(r);	
		manager.getTransaction().commit();
		
	}
}
