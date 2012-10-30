
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;


public class DateParser {
	
	public static void main(String s[]) throws ParseException
	{
		DateFormat formatter ; 
		 Date date ; 
		 formatter = new SimpleDateFormat("dd-MM-yy");
		 date = formatter.parse("10-5-12");  
		 System.out.println("Today is " +date );
		 
		 formatter = new SimpleDateFormat("HH a");
		 date = (Date)formatter.parse("12 AM"); 
		 System.out.println("Today is " + date.getTime() );
		 
		 
		 System.out.println(TimeUnit.MILLISECONDS.toSeconds(10000));
	}
	
	static void log(String s)
	{
		System.out.println(s);
	}
	
	public String getTimeDiff(Date dateOne, Date dateTwo) {
        String diff = "";
        long timeDiff = Math.abs(dateOne.getTime() - dateTwo.getTime());
        diff = String.format("%d hour(s) %d min(s)", TimeUnit.MILLISECONDS.toHours(timeDiff),
                TimeUnit.MILLISECONDS.toMinutes(timeDiff) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(timeDiff)));
        return diff;
}

}
