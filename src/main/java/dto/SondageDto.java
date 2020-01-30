package dto;

import java.util.Date;
import java.util.List;

public class SondageDto {

	private String resume;
	private String intitule;
	private String idUser;
	private List<String> dates;
	
	
	public SondageDto(String resume, String intitule, String idUser, List<String> dates) {
		super();
		this.resume = resume;
		this.intitule = intitule;
		this.idUser = idUser;
		this.dates = dates;
	}
	
	public SondageDto()
	{
		
	}
	
	
	public String getResume() {
		return resume;
	}
	public void setResume(String resume) {
		this.resume = resume;
	}
	public String getIntitule() {
		return intitule;
	}
	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}
	public String getIdUser() {
		return idUser;
	}
	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}
	public List<String> getDates() {
		return dates;
	}
	public void setDates(List<String> dates) {
		this.dates = dates;
	}
	
	
}
