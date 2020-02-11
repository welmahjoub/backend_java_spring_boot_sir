package entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.codehaus.jackson.annotate.JsonManagedReference;

@Entity
public class User {

	@Id
	@GeneratedValue
	private long id;
	
	private String nom, prenom, mail;
	
	@OneToMany(mappedBy = "user")
	@JsonManagedReference
	private List<Sondage> sondages;
	
	@OneToMany(mappedBy = "user")
	private List<Choix> choix;
	
	public User()
	{
		
	}
	
	public User(String nom, String prenom, String mail) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
	}

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
