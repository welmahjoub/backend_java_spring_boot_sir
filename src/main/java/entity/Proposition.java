package entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonManagedReference;

@Entity
public class Proposition {

	@Id
	@GeneratedValue
	private long id;
	
	@Temporal(TemporalType.DATE)
	Date date;
	
	@JsonBackReference
	@ManyToOne
	private Sondage sondage;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "proposition",cascade = CascadeType.ALL)
	private List<Participant> users;

	public Proposition()
	{
		
	}
	
	public Proposition(Sondage sondage, Date date) {
		super();
		this.sondage = sondage;
		this.date = date;
		users=new ArrayList<Participant>();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Sondage getSondage() {
		return sondage;
	}

	public void setSondage(Sondage sondage) {
		this.sondage = sondage;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public List<Participant> getUsers() {
		return users;
	}
	public void setUsers(List<Participant> users) {
		this.users = users;
	}
	
	

}
