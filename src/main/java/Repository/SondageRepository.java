package Repository;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import entity.Sondage;
import entity.User;
import jpa.EntityManagerHelper;

public class SondageRepository {

	static EntityManager manager = EntityManagerHelper.getEntityManager();
	
	
	
	public static List<Sondage> getListeSondage()
	{
		
		Query q=manager.createQuery("select a from Sondage");
		
		return q.getResultList();
	}
	
	public static void addSondage(Sondage s)
	{
		manager.getTransaction().begin();
		manager.persist(s);	
		manager.getTransaction().commit();
		
	}
	
}
