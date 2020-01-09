package jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import Repository.ChoixRepository;
import Repository.DateReunionRepository;
import Repository.ReunionRepository;
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

			UserRepository.remplirTableUser();
			SondageRepository.remplirTableSondage();
			DateReunionRepository.remplirTable();
			ReunionRepository.remplirTable();
			ChoixRepository.remplirTable();
 

		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();


		manager.close();
		EntityManagerHelper.closeEntityManagerFactory();
		//		factory.close();
	}


}
