package Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import entity.DateReunion;

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
	
	public static  boolean isExiste(List<DateReunion> dateReunions, Date date) {
		
		for (DateReunion o : dateReunions) {
			
			if(o.getDate().equals(date)) {
				return true;
			}
		}
		return false;
	}
		

}
