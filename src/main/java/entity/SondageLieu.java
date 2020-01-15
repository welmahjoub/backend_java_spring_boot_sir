package entity;

import java.util.List;

import javax.persistence.Entity;

@Entity
public class SondageLieu extends Sondage {

	
	private List<String> lieuProposees;

	private String lieuReunion;

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
