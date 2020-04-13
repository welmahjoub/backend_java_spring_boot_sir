package dto;

public class UserDto {

	private String nom;
	private String prenom;
	private String mail;
	private String password;
	
	
	public UserDto() {
		
	}
	
	public UserDto(String nom, String prenom, String mail, String password) {
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.password = password;
	}
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
