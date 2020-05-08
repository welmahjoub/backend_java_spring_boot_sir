package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.codehaus.jackson.annotate.JsonBackReference;

@Entity
public class Participant {

	@Id
	@GeneratedValue
	private long id;
	
	private String nom, prenom, mail, preferences, allergies;
	
	@JsonBackReference
	@ManyToOne
	private Proposition proposition;
	
	

	public Participant() {
		// TODO Auto-generated constructor stub
	}
	
	public Participant(String nom, String prenom, String mail) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;

		
	}
	
	public Participant(String nom, String prenom, String mail, String preferences, String allergies) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.preferences = preferences;
		this.allergies = allergies;

		
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


	public String getPreferences() {
		return preferences;
	}

	public void setPreferences(String preferences) {
		this.preferences = preferences;
	}

	public String getAllergies() {
		return allergies;
	}

	public void setAllergies(String allergies) {
		this.allergies = allergies;
	}

	public Proposition getProposition() {
		return proposition;
	}

	public void setProposition(Proposition proposition) {
		this.proposition = proposition;
	}
	

}
