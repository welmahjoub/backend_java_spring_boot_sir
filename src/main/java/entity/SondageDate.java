package entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class SondageDate extends Sondage {

	
	private List<Date> dateProposees;

	@Temporal(TemporalType.DATE)
	private Date datereunion;
	

	public Date getDatereunion() {
		return datereunion;
	}

	public void setDatereunion(Date datereunion) {
		this.datereunion = datereunion;
	}

	public List<Date> getDateProposees() {
		return dateProposees;
	}

	public void setDateProposees(List<Date> dateProposees) {
		this.dateProposees = dateProposees;
	}

	
	
}
