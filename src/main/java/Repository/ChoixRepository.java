package Repository;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dto.UserDto;
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
	
	public static void addChoix(Choix choix)
	{

		manager.getTransaction().begin();
        manager.persist(choix);
        manager.getTransaction().commit();
		
	}
	
}
