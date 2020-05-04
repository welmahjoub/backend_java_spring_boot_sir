package Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
	

		

}
