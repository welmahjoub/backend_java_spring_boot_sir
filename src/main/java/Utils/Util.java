package Utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Scanner;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

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

        try {
        	
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(recepteur.toString())
            );
            message.setSubject("Testing Gmail for my defense");
            message.setText("Dear student,"
                    + "\n\n This is a simple test ! \n\n"
                    +"<b>"+ msg +"</b>");

            Transport.send(message);

            System.out.println("Done");
            return true;
        } 
        catch (MessagingException e) {
            e.printStackTrace();
            return false;
        }
	}
	
	public static String getMail()
	{
		  File myObj = new File("config/mailConfig.txt");
	      Scanner myReader;
	      String data="";
		try {
			  myReader = new Scanner(myObj);
		       data = myReader.nextLine();
		      
		      myReader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	      
	      
		return data;
	}
	
	public static String getPassword()
	{
		 File myObj = new File("config/mailConfig.txt");
	      Scanner myReader;
	      String data="";
		try {
			  myReader = new Scanner(myObj);
		       data = myReader.nextLine();
		       data = myReader.nextLine();
		       
		      myReader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	      
	      
		return data;
	}
	
	public static void main(String[] args) {
		
		System.err.println(getMail());
		System.err.println(getPassword());
	}

}
