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
			System.err.println("echec client pad ");
			e.printStackTrace();
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
			e.printStackTrace();
		}
	      
	      
		return data;
	}
	
	public  static void createPad(String idSondage,String intutile,String resume)
	{
		try {

			
			//Create Pad
			client.createPad(idSondage, intutile+" " +resume);
			
		} catch (Exception e) {
			
		     System.err.println("insatller le server de pad sur port 9001");
		     e.printStackTrace();
		}
		
		
		
	}
	
	public static void deletePad(String idPad) {
		
		
		try {

			client.deletePad(idPad);
			
		} catch (Exception e) {
			System.err.println("erreur suppression pad");
			e.printStackTrace();
		}
	}
	
	public static void deleteAllPad() {

		
		try {
			
			for (Object id : getListPad()) {
				client.deletePad(id.toString());
			}
		} catch (Exception e) {
			System.err.println("erreru sup all pad");
		}
		
		
	}
	
	
	
	public static List getListPad() {

		try {
			
			// Get list of all pad ids existing
			Map result = client.listAllPads();
			List padIds = (List) result.get("padIDs");
			return padIds;
			
		} catch (Exception e) {
			
			return new ArrayList();
		}
		
					
	}
	
	public static void main(String[] args) {
		
		//createPad("1", "hi", "by");
	}
	
}
