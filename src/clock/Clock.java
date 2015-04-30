package clock;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/*
 * Basic controller of the entire bot. Controls
 * when the stock calculator trades and checks
 * for stopGaps. (IS 29/4/15)
 */

public class Clock
{
	private final String TRADE_INCREMENT;
	private final String STOP_INCREMENT;
	private final String FAST_INCREMENT = "000015";//15 seconds
	/*
	 * The clock thinks in military time strings.
	 * These final references are when the market opens and closes,
	 * so the bot will not trade before or after these times.
	 */
	public final String marketOpen =  "093000";//9:30:00 AM 
	public final String marketClose = "163000";//4:30:00 PM
	//								  "012345" index references
	
	public Clock()
	{
		TRADE_INCREMENT =  "001500";//15 minutes
		STOP_INCREMENT =   "000100";//1 minute 
	}
	
	public Clock(String t, String s)
	{
		TRADE_INCREMENT =  t;
		STOP_INCREMENT =  s;
	}
	
	/*
	 * run method is the main control, and contains the
	 * while(!tooVolatile) loop that runs basically forever
	 */
	public void run()
	{
		String timeStamp = null;
		while(true)
		{
			timeStamp = Clock.currentTime();
			System.out.println(timeStamp);
			//if(Integer.parseInt(timeStamp.substring(2)) % TRADE_INCREMENT == 0)
				
		}
	}
	
	public static String currentTime()
	{
		return (new SimpleDateFormat("HHmmss").format(Calendar.getInstance().getTime()));
	}
	private boolean isSeconds(String i)//i for increment
	{
		int currentSeconds = Integer.parseInt(Clock.currentTime().substring(4));
		int incrementSeconds = Integer.parseInt(i.substring(4));
	}
}
