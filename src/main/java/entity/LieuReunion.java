package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class LieuReunion {

	@Id
	@GeneratedValue
	long id;
	
	private String lieu;
	
	@ManyToOne
	private Sondage sondage;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}



	public Sondage getSondage() {
		return sondage;
	}

	public void setSondage(Sondage sondage) {
		this.sondage = sondage;
	}

	public String getLieu() {
		return lieu;
	}

	public void setLieu(String lieu) {
		this.lieu = lieu;
	}
	
	
}
