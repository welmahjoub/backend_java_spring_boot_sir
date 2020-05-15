package entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;

import org.codehaus.jackson.annotate.JsonManagedReference;

import Utils.ChiffrementUtil;

@Entity
public class User {

	@Id
	@GeneratedValue
	private long id;
	
	private String nom, prenom, mail, password;
	
	
	@JsonManagedReference
	@OneToMany(mappedBy = "user")
	private List<Sondage> sondages;
	
	
	public User() {

	}
	
	public User(String nom, String prenom, String mail,String password) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.password = password;
		sondages=new ArrayList<Sondage>();
	
	}
	
    @PrePersist
    private void prePersistFunction(){

      this.setPassword(ChiffrementUtil.chiffrer(this.password));
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
	


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
