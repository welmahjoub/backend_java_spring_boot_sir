package entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.codehaus.jackson.annotate.JsonBackReference;


@Entity

public class Choix {
	
	@Id
	@GeneratedValue
	long id;
	
	private String preferenceAliments, allergies ;
	
	@Temporal(TemporalType.DATE)
	private Date datechoisie;
	
	@ManyToOne
	@JsonBackReference
	private User user;
	
	@ManyToOne
	@JsonBackReference
	private Sondage sondage;
	
	
	
	public Choix( Date datechoisie, User user, Sondage sondage) {
		
		this.datechoisie = datechoisie;
		this.user = user;
		this.sondage = sondage;
	}
	public Choix() {
		// TODO Auto-generated constructor stub
	}
	public String getPreferenceAliments() {
		return preferenceAliments;
	}
	public void setPreferenceAliments(String preferenceAliments) {
		this.preferenceAliments = preferenceAliments;
	}
	public String getAllergies() {
		return allergies;
	}
	
	public void setAllergies(String allergies) {
		this.allergies = allergies;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Sondage getSondage() {
		return sondage;
	}
	public void setSondage(Sondage sondage) {
		this.sondage = sondage;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

}
