package Entity2;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class ChoixDate  extends Choix{

	@Temporal(TemporalType.DATE)
	private Date datechoisie;

	public Date getDatechoisie() {
		return datechoisie;
	}

	public void setDatechoisie(Date datechoisie) {
		this.datechoisie = datechoisie;
	}
}
