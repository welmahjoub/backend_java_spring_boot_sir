package Repository;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import entity.Choix;
import entity.Sondage;
import entity.User;
import jpa.EntityManagerHelper;

public class ChoixRepository {

	static EntityManager manager = EntityManagerHelper.getEntityManager();
	
	
	public static List<User> getListeUser()
	{
		
		Query q=manager.createQuery("select a from Utilisateur");
		
		return q.getResultList();
	}
	
}
