package entity;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class ChoixDate  extends Choix{

	private Date datechoisie;

	public Date getDatechoisie() {
		return datechoisie;
	}

	public void setDatechoisie(Date datechoisie) {
		this.datechoisie = datechoisie;
	}
}
