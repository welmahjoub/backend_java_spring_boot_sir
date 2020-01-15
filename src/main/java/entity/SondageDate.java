package entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class SondageDate extends Sondage {

	@OneToMany(mappedBy = "sondage")
	private List<DateReunion> dateProposees;

	@Temporal(TemporalType.DATE)
	private Date datereunion;
	

	public Date getDatereunion() {
		return datereunion;
	}

	public void setDatereunion(Date datereunion) {
		this.datereunion = datereunion;
	}

	public List<DateReunion> getDateProposees() {
		return dateProposees;
	}

	public void setDateProposees(List<DateReunion> dateProposees) {
		this.dateProposees = dateProposees;
	}

	
	
}
