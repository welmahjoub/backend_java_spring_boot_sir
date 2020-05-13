package Utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import net.gjerull.etherpad.client.EPLiteClient;

public class Util {
	
	public static Date convertirDate(String date)
	{
		Date date1=null;
		try {
			 date1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm").parse(date);
		} catch (ParseException e) {
			
			date1=new Date();
			Calendar calendar = Calendar.getInstance();
			calendar.setTimeInMillis(Long.valueOf(date));
			
			date1=calendar.getTime();
		}
		
		return date1;
	}
	
	public static boolean sendMail(StringBuilder msg, StringBuilder recepteur) {
		
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
            message.setSubject("Testing Gmail for my defense");
            String texte = "Dear student, <br/>"+ 
                    		"<b>"+ msg +"</b>";
            message.setContent(texte, "text/html");
//            message.setText("Dear student,"
//                    + "\n\n This is a simple test ! \n\n"
//                    +"<b>"+ msg +"</b>");

            Transport.send(message);

            System.out.println("Done");
            return true;
        } 
        catch (Exception e) {
        	
           System.err.println("echec envoie email ");
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
			System.err.println("getmail");
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
			System.err.println("getpassword");
		}
	      
	      
		return data;
	}
	
	public  static void createPad(String idSondage,String intutile,String resume)
	{
		try {
			//For mahjoub
//			EPLiteClient client = new EPLiteClient("http://localhost:9001", "025cc67775838849d7b92c4a4c3d6e36df2477386fa11f10ce01a0f2ed1c4797");
			
			//For Yaya
			EPLiteClient client = new EPLiteClient("http://localhost:9001", "20d57a3bfd9e4cdff8ba3575abd0066367aeb62025ebf343b9fdf109b7eed628");
			
			//Create Pad
			client.createPad(idSondage, intutile+" " +resume);
			
			
			// Get pad text
			String text = client.getText(idSondage).get("text").toString();
			
			System.out.println("Text du pad: \n"+ text);
			
			// Get list of all pad ids existing
			Map result = client.listAllPads();
			List padIds = (List) result.get("padIDs");
			
			System.out.println("Les pads existants");
			for (Object id : padIds) {
				System.out.println(id);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		//System.err.println("insatller le server de pad sur port 9001");
		}
		
		
		
	}
	
	public static void deletePad(String idPad) {
		//For mahjoub
//		EPLiteClient client = new EPLiteClient("http://localhost:9001", "025cc67775838849d7b92c4a4c3d6e36df2477386fa11f10ce01a0f2ed1c4797");
		
		//For Yaya
		EPLiteClient client = new EPLiteClient("http://localhost:9001", "20d57a3bfd9e4cdff8ba3575abd0066367aeb62025ebf343b9fdf109b7eed628");
		
		
		//DeletePad
		client.deletePad(idPad);
	}
	
	public static void deleteAllPad() {
		//For mahjoub
//		EPLiteClient client = new EPLiteClient("http://localhost:9001", "025cc67775838849d7b92c4a4c3d6e36df2477386fa11f10ce01a0f2ed1c4797");
		
		//For Yaya
		EPLiteClient client = new EPLiteClient("http://localhost:9001", "20d57a3bfd9e4cdff8ba3575abd0066367aeb62025ebf343b9fdf109b7eed628");
		
		
		//DeleteAllPad
		for (Object id : getListPad()) {
			client.deletePad(id.toString());
		}
		
	}
	
	
	
	public static List getListPad() {
		//For mahjoub
//		EPLiteClient client = new EPLiteClient("http://localhost:9001", "025cc67775838849d7b92c4a4c3d6e36df2477386fa11f10ce01a0f2ed1c4797");
		
		//For Yaya
		EPLiteClient client = new EPLiteClient("http://localhost:9001", "20d57a3bfd9e4cdff8ba3575abd0066367aeb62025ebf343b9fdf109b7eed628");
		
		// Get list of all pad ids existing
					Map result = client.listAllPads();
					List padIds = (List) result.get("padIDs");
					return padIds;
					
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		System.err.println(getMail());
		System.err.println(getPassword());
		
		
		deleteAllPad();
		
		createPad("test", "hi", "hi2");
		//To access on pad : http://localhost:9001/p/test
	}

}
