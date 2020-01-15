package entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class SondageLieu extends Sondage {



	@OneToMany(mappedBy = "sondage")
	private List<LieuReunion> lieuProposees;
}
