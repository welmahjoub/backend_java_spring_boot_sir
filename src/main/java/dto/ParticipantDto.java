package dto;

public class ParticipantDto {
	
	private String nom;
	private String prenom;
	private String mail;
	
	private String idProposition;
	
	
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getIdProposition() {
		return idProposition;
	}
	public void setIdProposition(String idProposition) {
		this.idProposition = idProposition;
	}
	
}
