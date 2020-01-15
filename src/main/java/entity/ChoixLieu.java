package entity;

import javax.persistence.Entity;

@Entity
public class ChoixLieu extends Choix {

	private String lieuChoisie;

	public String getLieuChoisie() {
		return lieuChoisie;
	}

	public void setLieuChoisie(String lieuChoisie) {
		this.lieuChoisie = lieuChoisie;
	}
}
