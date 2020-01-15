package entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Sondage {
	
	@Id
	@GeneratedValue
	private long id;
	
	private String lien; 
	
	@Temporal(TemporalType.DATE)
	private Date dateCreation;
	
	@OneToMany(mappedBy = "sondage")
	private List<Choix> choix;
	
	@ManyToOne(targetEntity=Utilisateur.class)
	private Utilisateur user;
	
	@OneToOne
	private Reunion reunion;
	
	
	public List<Choix> getChoix() {
		return choix;
	}
	
	public void setChoix(List<Choix> choix) {
		this.choix = choix;
	}
	
	public Reunion getReunion() {
		return reunion;
	}
	
	public void setReunion(Reunion reunion) {
		this.reunion = reunion;
	}
	
	public String getLien() {
		return lien;
	}
	
	public void setLien(String lien) {
		this.lien = lien;
	}
	
	public Date getDateCreation() {
		return dateCreation;
	}
	
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	
	public Utilisateur getUser() {
		return user;
	}
	
	public void setUser(Utilisateur user) {
		this.user = user;
	}
	

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
}
