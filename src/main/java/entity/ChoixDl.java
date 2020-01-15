package entity;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class ChoixDl extends Choix {

	private Date datechoisie;
	private String lieuChoisie;
	
	public String getLieuChoisie() {
		return lieuChoisie;
	}
	public void setLieuChoisie(String lieuChoisie) {
		this.lieuChoisie = lieuChoisie;
	}
	public Date getDatechoisie() {
		return datechoisie;
	}
	public void setDatechoisie(Date datechoisie) {
		this.datechoisie = datechoisie;
	}
}
