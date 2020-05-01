package jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import Repository.UserRepository;

public class JpaTest {


	public static void main(String[] args) {

		EntityManager manager = EntityManagerHelper.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();


		try {
			
        UserRepository.remplirTableUser();
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();


		manager.close();
		EntityManagerHelper.closeEntityManagerFactory();
	}


}
