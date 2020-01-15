package Repository;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import entity.Choix;
import entity.Sondage;
import entity.Utilisateur;
import jpa.EntityManagerHelper;

public class ChoixRepository {

	static EntityManager manager = EntityManagerHelper.getEntityManager();
	
	public static void remplirTable()
	{
		
		int number = manager.createQuery("Select c From Choix c", Choix.class).getResultList().size();
		
		if (number == 0) {	
		

			Utilisateur user2=new Utilisateur();
			user2.setNom("user2");
			user2.setPrenom("user2");
			user2.setMail("user2@gmail.com");
			manager.persist(user2);
			
			Sondage s=new Sondage();
			s.setUser(user2);
			s.setDateCreation(new Date());
			s.setLien("lien");
			manager.persist(s);
			
			Choix choix = new Choix();
			choix.setPreferenceAliments("Pizza, creme fraiche");
			choix.setSondage(s);
			choix.setUser(user2);
			choix.setAllergies("gluten");
			//choix.setDatechoisie(new Date());
			manager.persist(choix);
			
		
		}
	}
	

	public static List<Utilisateur> getListeUser()
	{
		
		Query q=manager.createQuery("select a from Utilisateur");
		
		return q.getResultList();
	}
	
}
