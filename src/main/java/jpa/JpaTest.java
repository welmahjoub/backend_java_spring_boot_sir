package jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import Repository.SondageRepository;
import Repository.UserRepository;
import entity.Utilisateur;

public class JpaTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		EntityManager manager = EntityManagerHelper.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();


		try {

        SondageRepository.remplirTableSondage();
        UserRepository.remplirTableUser();

		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();


		manager.close();
		EntityManagerHelper.closeEntityManagerFactory();
		//		factory.close();
	}


}
