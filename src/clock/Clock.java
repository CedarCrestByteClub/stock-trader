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
	private boolean tooVolatile = false;
	/*
	 * The clock thinks in military time strings.
	 * These final references are when the market opens and closes,
	 * so the bot will not trade before or after these times.
	 */
	public final String marketOpen =  "093000";//9:30:00 AM 
	public final String marketClose = "163000";//4:30:00 PM
	//								  "012345" index references
	/*
	 * Default constructor: starts with 15 minute trade checking increments
	 * and 1 minute stoploss checking increments
	 */
	public Clock()
	{
		TRADE_INCREMENT =  "001500";//15 minutes
		STOP_INCREMENT =   "000100";//1 minute 
	}
	/*
	 * Overloaded constructor: let's the user input custom increments for 
	 * trade and stoploss checking increments
	 * USES "HHMMSS" for what the input should be
	 */
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
		while(!tooVolatile)
		{
			timeStamp = Clock.currentTime();
			System.out.println(timeStamp);
			//if(Integer.parseInt(timeStamp.substring(2)) % TRADE_INCREMENT == 0)
				
		}
	}
	// Returns the current time in a String
	public static String getCurrentTime()
	{
		return (new SimpleDateFormat("HHmmss").format(Calendar.getInstance().getTime()));
	}
	
	private boolean isSeconds(String i)//i for increment
	{
		int currentSeconds = Integer.parseInt(Clock.currentTime().substring(4));
		int incrementSeconds = Integer.parseInt(i.substring(4));
	}
}
