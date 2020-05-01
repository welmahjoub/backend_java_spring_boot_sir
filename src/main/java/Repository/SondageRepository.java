package Repository;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import entity.Proposition;
import entity.Reunion;
import entity.Sondage;
import entity.User;
import jpa.EntityManagerHelper;

public class SondageRepository {

	static EntityManager manager = EntityManagerHelper.getEntityManager();
	
	public static void remplirTableSondage()
	{
		
		int number = manager.createQuery("Select a From Sondage a", Sondage.class).getResultList().size();
		
		if (number == 0) {	
		
		User user2=new User();
		user2.setNom("user2");
		user2.setPrenom("user2");
		user2.setMail("user2@gmail.com");
		manager.persist(user2);
		
		Sondage s=new Sondage();
		s.setUser(user2);
		s.setDateCreation(new Date());
		s.setLien("lien");
		manager.persist(s);
		
		Reunion r=  new Reunion();
//		r.setSondage(s);
		r.setIntitule("reunion import");
		r.setLienPad("www.reg.com");
		r.setResume("blalalaall");
		manager.persist(r);
		
		}
	}
	
	
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
