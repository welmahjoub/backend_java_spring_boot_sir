package entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.codehaus.jackson.annotate.JsonBackReference;

@Entity
public class DateReunion {

	@Id
	@GeneratedValue
	private long id;
	
	
	@ManyToOne
	@JsonBackReference
	private Sondage sondage;
	
	@Temporal(TemporalType.DATE)
	Date date;

	public DateReunion()
	{
		
	}
	public DateReunion(Sondage sondage, Date date) {
		super();
		this.sondage = sondage;
		this.date = date;
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
	@Override
	public String toString() {
		return "DateReunion [id=" + id + ", sondage=" + sondage + ", date=" + date + "]";
	}
	
	

}
