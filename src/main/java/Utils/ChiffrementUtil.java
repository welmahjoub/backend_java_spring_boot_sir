package Utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.security.Key;
import java.util.Scanner;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class ChiffrementUtil {


	public static String getCleChifrement() 
	{
		
		String data="";
		try {
			File myObj = new File("config/keyChiffrement.txt");
		      Scanner myReader = new Scanner(myObj);
		       data = myReader.nextLine();
		      
		      myReader.close();
		} catch (FileNotFoundException e) {
			System.err.println("getCleChifrement");
		}
	      
	      
		return data;
		
	}
	
	public static String chiffrer(String str) {
		
		try {
			
			Cipher ecipher = Cipher.getInstance("AES");
			 Key aeskey = new SecretKeySpec(getCleChifrement().getBytes(),"AES");
			 byte[] utf8 = str.getBytes("UTF8");
			 ecipher.init(ecipher.ENCRYPT_MODE, aeskey );

			 byte[] enc = ecipher.doFinal(utf8);

			 return new sun.misc.BASE64Encoder().encode(enc);
			
		} catch (Exception e) {
			System.err.println("chifrement");
			return "";
		}
		 

		}
	
	public static String dechiffrer(String str)  {
		
		try {
			
			Cipher  dcipher = Cipher.getInstance("AES");
			 Key aesKey = new SecretKeySpec(getCleChifrement().getBytes(), "AES");
			 dcipher.init(dcipher.DECRYPT_MODE, aesKey);
			byte[] dec = new sun.misc.BASE64Decoder().decodeBuffer(str);
			byte[] utf8 = dcipher.doFinal(dec);

			 return new String(utf8, "UTF8");
			
		} catch (Exception e) {
			System.err.println("dechifrement");
			return "";
		}	
		
		 
		 }

	public static void main(String[] args) throws Exception {
		
		
		String c=chiffrer("mot");
		System.err.println(c);
		String o=dechiffrer(c);
		System.err.println(o);
	}

}
