package Entity2;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class ChoixDateLieu extends Choix {

	@Temporal(TemporalType.DATE)
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
