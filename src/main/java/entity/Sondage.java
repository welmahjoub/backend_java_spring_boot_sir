package entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Sondage {
	
	@Id
	@GeneratedValue
	private long id;
	
	private String lien;
	
	private boolean clos;
	
	@OneToMany(mappedBy = "sondage",fetch = FetchType.LAZY)
	private List<DateReunion> dateProposees;
	
	@OneToMany(mappedBy = "sondage",fetch = FetchType.LAZY)
	private List<Choix> choix;
	
	@Temporal(TemporalType.DATE)
	private Date datereunion;
	
	@Temporal(TemporalType.DATE)
	private Date dateCreation;
	
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	private User user;
	
	@OneToOne(mappedBy = "sondage",fetch = FetchType.LAZY)
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
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
}
