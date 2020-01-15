package entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class SondageDateLieu extends Sondage {



	@OneToMany(mappedBy = "sondage")
	private List<DateReunion> dateProposees;

	@OneToMany(mappedBy = "sondage")
	private List<LieuReunion> lieuProposees;
	
	private String lieuReunion;
	
	@Temporal(TemporalType.DATE)
	private Date datereunion;


	

	public List<DateReunion> getDateProposees() {
		return dateProposees;
	}

	public void setDateProposees(List<DateReunion> dateProposees) {
		this.dateProposees = dateProposees;
	}

	public Date getDatereunion() {
		return datereunion;
	}

	public void setDatereunion(Date datereunion) {
		this.datereunion = datereunion;
	}



	public List<LieuReunion> getLieuProposees() {
		return lieuProposees;
	}

	public void setLieuProposees(List<LieuReunion> lieuProposees) {
		this.lieuProposees = lieuProposees;
	}

	public String getLieuReunion() {
		return lieuReunion;
	}

	public void setLieuReunion(String lieuReunion) {
		this.lieuReunion = lieuReunion;
	}
	
	
}
