package entity;

import java.util.ArrayList;
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
	
	private String nom, prenom, mail, password;
	
	@OneToMany(mappedBy = "user")
	 @JsonManagedReference
	private List<Sondage> sondages;
	
	
	@OneToMany(mappedBy = "user")
	private List<Choix> choix;
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public User(String nom, String prenom, String mail,String password) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.password = password;
		sondages=new ArrayList<Sondage>();
		choix=new ArrayList<Choix>();
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
