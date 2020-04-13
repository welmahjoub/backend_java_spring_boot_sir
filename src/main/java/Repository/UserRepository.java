package Repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dto.UserDto;
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
		user1.setPassword("testtest");
		manager.persist(user1);
		
		
		User user2=new User();
		user2.setNom("yaya");
		user2.setPrenom("simp");
		user2.setMail("yaya@gmail.com");
		user2.setPassword("testtest");
		manager.persist(user2);
		
		}
	}
	

	public static List<User> getListeUser()
	{
		
		Query q=manager.createQuery("select a from User as a");
		
		return q.getResultList();
	}
	
	public static User addUser(UserDto u)
	{
		User user=new User(u.getNom(),u.getPrenom(), u.getMail(), u.getPassword());
		
		manager.getTransaction().begin();
        manager.persist(user);
        manager.getTransaction().commit();
		
        return user;
	}
	
	
	
	public static User findById(String id)
	{
		return manager.find(User.class, Long.valueOf(id));
		
	}
	
}
