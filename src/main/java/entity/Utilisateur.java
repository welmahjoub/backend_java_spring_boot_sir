package entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Utilisateur {

	private String nom, prenom, mail;
	
	@OneToMany(targetEntity=Sondage.class, mappedBy = "user")
	private List<Sondage> sondages;
	
	@OneToMany(mappedBy = "user")
	private List<Choix> choix;
	
	@Id
	@GeneratedValue
	private long id;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getPrenom() {
		return prenom;
	}
	
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public String getMail() {
		return mail;
	}
	
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	public List<Sondage> getSondages() {
		return sondages;
	}
	
	public void setSondages(List<Sondage> sondages) {
		this.sondages = sondages;
	}
	
	public List<Choix> getChoix() {
		return choix;
	}
	
	public void setChoix(List<Choix> choix) {
		this.choix = choix;
	}
	
	

}
