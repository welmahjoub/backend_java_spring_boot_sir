package Repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import entity.Utilisateur;
import jpa.EntityManagerHelper;

public class UserRepository {

	static EntityManager manager = EntityManagerHelper.getEntityManager();
	
	public static void remplirTableUser()
	{
		
		int number = manager.createQuery("Select a From Utilisateur a", Utilisateur.class).getResultList().size();
		
		if (number == 0) {	
		
		Utilisateur user1=new Utilisateur();
		user1.setNom("Mahjoub");
		user1.setPrenom("Abdel");
		user1.setMail("Abdel@gmail.com");
		manager.persist(user1);
		
		
		Utilisateur user2=new Utilisateur();
		user2.setNom("yaya");
		user2.setPrenom("simp");
		user2.setMail("yaya@gmail.com");
		manager.persist(user2);
		
		}
	}
	

	public static List<Utilisateur> getListeUser()
	{
		
		Query q=manager.createQuery("select a from Utilisateur a");
		
		return q.getResultList();
	}
	
}
