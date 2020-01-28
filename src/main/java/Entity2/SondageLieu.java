package Entity2;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class SondageLieu extends Sondage {

	
	@OneToMany(mappedBy = "sondage")
	private List<LieuReunion> lieuProposees;

	private String lieuReunion;

	

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
