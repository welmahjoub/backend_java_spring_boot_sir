package Utils;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;

public class ChiffrementUtil {

	private static Key cle =getCleChifrement();
	
	public static String chiffrer(String motDePasse)
	{
		
        try {
        	
        	
            
            Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
            
            cipher.init(Cipher.ENCRYPT_MODE, cle);
            byte[] cipherText = cipher.doFinal(motDePasse.getBytes());
            
            return new String(cipherText);
        } catch (Exception e) {
			e.printStackTrace();
			
		}
            
		return "erreur";
	}
	
	public static String dechiffrer(String MotDepass)
	{
		
	    try {
	    	
			Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
			cipher.init(Cipher.DECRYPT_MODE, cle);
			byte[] newPlainText = cipher.doFinal(MotDepass.getBytes());
		
			return new String(newPlainText);
			
	    } catch (Exception e) {
			e.printStackTrace();
		} 
	    
		return "erreur";
	}
	
	public static Key getCleChifrement() 
	{
		try {
			KeyGenerator keyGen = KeyGenerator.getInstance("DES");
	        keyGen.init(56);
	        Key key = keyGen.generateKey();
	        return key;
		} catch (Exception e) {
			System.err.println("erreur generation de cle");
			return null;
		}
		
        
		
	}
	
	public static void main(String[] args) {
		String c=chiffrer("mot");
		System.err.println(c);
		String o=dechiffrer(c);
		System.err.println(o);
	}

}
