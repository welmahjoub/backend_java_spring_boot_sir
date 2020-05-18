package Utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Scanner;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class sendMailUtil {
	
	public static boolean sendMail(StringBuilder objet,StringBuilder msg, StringBuilder recepteur) {
		
		final String username = getMail();
        final String password = getPassword();
        
        try {
        	
        	Properties prop = new Properties();
    		prop.put("mail.smtp.host", "smtp.gmail.com");
            prop.put("mail.smtp.port", "587");
            prop.put("mail.smtp.auth", "true");
            prop.put("mail.smtp.starttls.enable", "true"); //TLS

        	
        	Session session = Session.getInstance(prop,
                    new javax.mail.Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(username, password);
                        }
                    });
        	
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(recepteur.toString())
            );
            message.setSubject("Confirmation de la date reunion" + objet);
            String texte = "Cher  Participant, <br/> <br/>"+ 
                    		""+ msg +"<br/>";
            message.setContent(texte, "text/html");

            Transport.send(message);

            System.out.println("Done");
            return true;
        } 
        catch (Exception e) {
        	
           System.err.println("echec envoie email : une erreur est survenue lors de l'envoie du mail ");
//           e.printStackTrace();
            return false;
        }
	}
	
	public static String getMail()
	{
		  
	      String data="";
		try {
			File myObj = new File("config/mailConfig.txt");
		      Scanner myReader = new Scanner(myObj);
		       data = myReader.nextLine();
		      
		      myReader.close();
		} catch (FileNotFoundException e) {
			System.err.println("error getmail : erreur lors de la recuperation du login \n"
					+ "Verifier le fichier mailconfig dans le dans le dossier config");
//			e.printStackTrace();
		}
	      
	      
		return data;
	}
	
	public static String getPassword()
	{
		
	      String data="";
		try {
			 File myObj = new File("config/mailConfig.txt");
		      Scanner myReader = new Scanner(myObj);
		       data = myReader.nextLine();
		       data = myReader.nextLine();
		       
		      myReader.close();
		} catch (FileNotFoundException e) {
			System.err.println("error getpassword : erreur lors de la recuperation du mot de passe \n"
					+ "Verifier le fichier mailconfig dans le dans le dossier config");
			//			e.printStackTrace();
		}
	      
	      
		return data;
	}
}
