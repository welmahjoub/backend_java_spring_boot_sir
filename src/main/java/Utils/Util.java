package Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import entity.Proposition;

public class Util {
	
	public static Date convertirDate(String date)
	{
		Date date1=null;
		try {
			 date1 = new SimpleDateFormat("yyyy-MM-dd").parse(date);
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		
		return date1;
	}
	

		

}
