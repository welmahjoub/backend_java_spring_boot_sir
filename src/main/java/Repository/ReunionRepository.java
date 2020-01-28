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
	
	public static void remplirTable()
	{
		
		int number = manager.createQuery("Select r From Reunion r", Reunion.class).getResultList().size();
		
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
		
		
		
		Reunion reun = new Reunion();
		reun.setCode("proporeunion123456");
		reun.setResume("blabla");
		reun.setIntitule("balalala");
		reun.setLienPad("www.framepad.org");
		
		
		manager.persist(reun);
		
		}
	}
	
	public static List<Sondage> getListeSondage()
	{
		
		Query q=manager.createQuery("select a from Sondage");
		
		return q.getResultList();
	}
}
