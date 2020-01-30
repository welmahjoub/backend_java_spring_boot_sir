package entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
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
	
	@ManyToOne()
	private User user;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	private Reunion reunion;
	
	@OneToMany(mappedBy = "sondage",cascade = CascadeType.PERSIST)
	private List<DateReunion> dateProposees;
	
	@OneToMany(mappedBy = "sondage")
	private List<Choix> choix;
	
	@Temporal(TemporalType.DATE)
	private Date dateReunion;
	
	@Temporal(TemporalType.DATE)
	private Date dateCreation;
	
	
	public Sondage(List<DateReunion> dateProposees, User user, Reunion reunion) {
		super();
		this.dateProposees = dateProposees;
		this.user = user;
		this.reunion = reunion;
		this.clos=false;
		this.dateCreation=new Date();
		this.dateReunion=null;
		
	}

	public Sondage() {
		// TODO Auto-generated constructor stub
	}

	public boolean isClos() {
		return clos;
	}

	public void setClos(boolean clos) {
		this.clos = clos;
	}

	public List<DateReunion> getDateProposees() {
		return dateProposees;
	}

	public void setDateProposees(List<DateReunion> dateProposees) {
		this.dateProposees = dateProposees;
	}

	public Date getDatereunion() {
		return dateReunion;
	}

	public void setDatereunion(Date datereunion) {
		this.dateReunion = datereunion;
	}

	
	
	
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
