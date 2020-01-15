package entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class SondageDateLieu extends Sondage {

	@OneToMany(mappedBy = "sondage")
	private List<DateReunion> dateProposees;

	@OneToMany(mappedBy = "sondage")
	private List<LieuReunion> lieuProposees;
	

	@OneToOne
	private LieuReunion lieuReunion;
	

	@OneToOne
	private DateReunion datereunion;
}
