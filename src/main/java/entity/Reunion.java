package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.codehaus.jackson.annotate.JsonBackReference;

@Entity
public class Reunion {

	@Id
	@GeneratedValue
	long id;
	
	private String intitule, resume, code, lienPad;
	
	
	@JsonBackReference
	@OneToOne
	private Sondage sondage;
	
	
	public Reunion(String intitule, String resume) {
		super();
		this.intitule = intitule;
		this.resume = resume;
		
	}
	
	public Reunion(String intitule, String resume, String code) {
		super();
		this.intitule = intitule;
		this.resume = resume;
		this.code = code;
		
	}

	public Reunion() {
		// TODO Auto-generated constructor stub
	}

	public Sondage getSondage() {
		return sondage;
	}

	public void setSondage(Sondage sondage) {
		this.sondage = sondage;
	}

	
	public String getLienPad() {
		return lienPad;
	}

	public void setLienPad(String lienPad) {
		this.lienPad = lienPad;
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	
}
