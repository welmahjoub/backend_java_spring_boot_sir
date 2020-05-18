package Utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import net.gjerull.etherpad.client.EPLiteClient;

public class ApiPadUtil {
	
	public static EPLiteClient client;
	
	static
	{
		try {
			
		 client = new EPLiteClient("http://localhost:9001", getTokenApiPad());
			
		} catch (Exception e) {
			System.err.println("echec initialisation du client pad");
//			e.printStackTrace();
		}
	}
	

	public static String getTokenApiPad()
	{
		
	      String data="";
		try {
			 File myObj = new File("config/apiPadKey.txt");
		      Scanner myReader = new Scanner(myObj);
		       data = myReader.nextLine();
		       
		      myReader.close();
		} catch (FileNotFoundException e) {
			System.err.println("error getTokenApiPad : erreur lors de la recuperation de la clé du server \n"
					+ "Verifier bien le fichier ApiPadKey dans config et que vous avez bien copier et mis le token");
//			e.printStackTrace();
		}
	      
	      
		return data;
	}
	
	public  static void createPad(String idSondage,String intutile,String resume)
	{
		try {

			
			//Create Pad
			client.createPad(idSondage, intutile+" " +resume);
			
		} catch (Exception e) {
			
		     System.err.println(" error createPad : erreur lors de la creation du pad \n"
		     		+ " Verifier que le server du pad  est bien insatllé sur port 9001");
		     e.printStackTrace();
		}
		
		
		
	}
	
	// Get pad text
				
				
	public static String getTextPad(String idPad) {
		
		
		try {

			String text = client.getText(idPad).get("text").toString();
			return text;
			
		} catch (Exception e) {
			System.err.println(" error getTextPad : erreur lors de la recuperation du resume du pad");
			e.printStackTrace();
		}
		return "";
	}
	
	public static void deletePad(String idPad) {
		
		
		try {

			client.deletePad(idPad);
			
		} catch (Exception e) {
			System.err.println("error deletePad : erreur lors de la  suppression du pad");
			e.printStackTrace();
		}
	}
	
	public static void deleteAllPad() {

		
		try {
			
			for (Object id : getListPad()) {
				client.deletePad(id.toString());
			}
		} catch (Exception e) {
			System.err.println("error deleteAllPad : erreur lors de la  suppression de tous les pads");
//			e.printStackTrace();
		}
		
		
	}
	
	
	
	public static List getListPad() {

		try {
			
			// Get list of all pad ids existing
			Map result = client.listAllPads();
			List padIds = (List) result.get("padIDs");
			return padIds;
			
		} catch (Exception e) {
			System.err.println("Error getListPad : erreur lors de la recuperation de la liste des pads");
//			e.printStackTrace();
			return new ArrayList();
		}	
					
	}
	
	public static void afficheListPad() {
		
		for (Object padId : getListPad() ) {
			System.out.println(padId);
			client.deletePad(String.valueOf(padId));
		}
	}
	
	public static void main(String[] args) {
		
//		deletePad("2");
//		deleteAllPad();
		afficheListPad();
		//createPad("1", "hi", "by");
	}
	
}
