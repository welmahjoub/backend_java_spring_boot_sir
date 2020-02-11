package Repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import entity.User;
import jpa.EntityManagerHelper;

public class UserRepository {

	static EntityManager manager = EntityManagerHelper.getEntityManager();
	
	public static void remplirTableUser()
	{
		
		int number = manager.createQuery("Select a From User a", User.class).getResultList().size();
		System.err.println("by");
		
		if (number == 0) {	
			
			System.err.println("hi");
		
		User user1=new User();
		user1.setNom("Mahjoub");
		user1.setPrenom("Abdel");
		user1.setMail("Abdel@gmail.com");
		manager.persist(user1);
		
		
		User user2=new User();
		user2.setNom("yaya");
		user2.setPrenom("simp");
		user2.setMail("yaya@gmail.com");
		manager.persist(user2);
		
		}
	}
	

	public static List<User> getListeUser()
	{
		
		Query q=manager.createQuery("select a from User as a");
		
		return q.getResultList();
	}
	
	public static void addUser(User u)
	{
		manager.getTransaction().begin();
        manager.persist(u);
        manager.getTransaction().commit();
		
	}
	
	public static User findById(String id)
	{
		return manager.find(User.class, Long.valueOf(id));
		
	}
	
}
