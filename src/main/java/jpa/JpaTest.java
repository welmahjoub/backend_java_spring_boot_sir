package jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import Repository.UserRepository;
import entity.User;

public class JpaTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		EntityManager manager = EntityManagerHelper.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();


		try {

        UserRepository.remplirTableUser();
        
        List<User> users = UserRepository.getListeUser();
        
        for (User utilisateur : users) {
			System.out.println("1" + utilisateur.getNom() +" "+utilisateur.getPrenom() );
		}

		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();


		manager.close();
		EntityManagerHelper.closeEntityManagerFactory();
	}


}
