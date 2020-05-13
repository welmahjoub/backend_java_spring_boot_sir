package Utils;

import java.io.File;
import java.io.FileNotFoundException;
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
			System.err.println("echec client pad ");
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
			System.err.println("getTokenApiPad");
		}
	      
	      
		return data;
	}
	
	public  static void createPad(String idSondage,String intutile,String resume)
	{
		try {

			
			//Create Pad
			client.createPad(idSondage, intutile+" " +resume);

			/*
			 * // Get pad text String text =
			 * client.getText(idSondage).get("text").toString();
			 * 
			 * System.out.println("Text du pad: \n"+ text);
			 * 
			 * // Get list of all pad ids existing Map result = client.listAllPads(); List
			 * padIds = (List) result.get("padIDs");
			 * 
			 * System.out.println("Les pads existants"); for (Object id : padIds) {
			 * System.out.println(id); }
			 */
			
		} catch (Exception e) {
			e.printStackTrace();
		//System.err.println("insatller le server de pad sur port 9001");
		}
		
		
		
	}
	
	public static void deletePad(String idPad) {
		
		//DeletePad
		client.deletePad(idPad);
	}
	
	public static void deleteAllPad() {

		
		//DeleteAllPad
		for (Object id : getListPad()) {
			client.deletePad(id.toString());
		}
		
	}
	
	
	
	public static List getListPad() {

		// Get list of all pad ids existing
		Map result = client.listAllPads();
		List padIds = (List) result.get("padIDs");
		return padIds;
					
	}
	
	public static void main(String[] args) {
		
		createPad("1", "hi", "by");
	}
	
}
