package entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class SondageDateLieu extends Sondage {



	private List<Date> dateProposees;

	private List<String> lieuProposees;
	
	private String lieuReunion;
	
	@Temporal(TemporalType.DATE)
	private Date datereunion;


	public List<Date> getDateProposees() {
		return dateProposees;
	}

	public void setDateProposees(List<Date> dateProposees) {
		this.dateProposees = dateProposees;
	}

	public Date getDatereunion() {
		return datereunion;
	}

	public void setDatereunion(Date datereunion) {
		this.datereunion = datereunion;
	}

	public List<String> getLieuProposees() {
		return lieuProposees;
	}

	public void setLieuProposees(List<String> lieuProposees) {
		this.lieuProposees = lieuProposees;
	}

	public String getLieuReunion() {
		return lieuReunion;
	}

	public void setLieuReunion(String lieuReunion) {
		this.lieuReunion = lieuReunion;
	}
	
	
}
