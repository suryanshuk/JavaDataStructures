package Threads;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class timeStamp {
	
	
	public void getTime()
	{
		Calendar cal = Calendar.getInstance();
    	cal.getTime();
    	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
    	System.out.println( sdf.format(cal.getTime()) );
	}

}
