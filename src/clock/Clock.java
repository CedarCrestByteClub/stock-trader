package clock;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

import strategies.Strategy;

/*
 * Basic controller of the entire bot. Controls
 * when the stock calculator trades and checks
 * for stopGaps. (IS 29/4/15)
 */

public class Clock
{
	/*
	 * The clock thinks in military time strings.
	 * These final references are timings for various
	 * times or increments the bot should know.
	 * FAST_INCREMENT has no use as of this being written,
	 * it is intended for testing to make sure the bot could
	 * trade faster that 1 minute if it was desired.(IS 05/2/15)
	 * 
	 * The minimum value of each unit in an increment is 1, 
	 * because if it were 0 then the isTime methods would divide
	 * the time by 0. The only numbers in an increment that matter
	 * are the ones that are != to 1.
	 */
	private final String TRADE_INCREMENT;
	private final String STOP_INCREMENT;
	private static final String MILLIS_INCREMENT = "010101999";//1 second
	private static final String MARKET_OPEN =  "093000";//9:30:00 AM 
	private static final String MARKET_CLOSE = "163000";//4:30:00 PM
	//								   		   "012345678" index references
	
	private Strategy strat;

	public Clock()
	{
		TRADE_INCREMENT =  "011501";//15 minutes
		STOP_INCREMENT =   "010101";//1 minute 
		strat = new Strategy();
		Timer t = new Timer();
		t.schedule(new Tic(), 0, 1000);
	}
	
	public Clock(String ti, String si, Strategy str)
	{
		TRADE_INCREMENT =  ti;
		STOP_INCREMENT =  si;
		strat = str;
		Timer t = new Timer();
		t.schedule(new Tic(), 0, 1000);
	}
	
	// Returns the current time in a String
	public static String time()
	{
		return (new SimpleDateFormat("HHmmssSSS").format(Calendar.getInstance().getTime()));
	}
	
	class Tic extends TimerTask
	{

		public void run()
		{
			runEverySecond();
		}
	}
	/*
	 * run method is the main control, and contains the
	 * while(!tooVolatile) loop that runs basically forever
	 */
	public void runEverySecond()
	{
		System.out.println("78 Time was: " + this.time());
		if(strat.isStable())//if market is stable
		{
			if(fitsMillis(MILLIS_INCREMENT))//if time is not a fractional second
			{
				
				if(fitsTiming(TRADE_INCREMENT))
				{
					System.out.println("Trade increment called, time was: " + Clock.time());
					strat.trade();
				}
				
				if(fitsTiming(STOP_INCREMENT))
				{
					System.out.println("Stop increment called, time was: " + Clock.time());
					strat.confirmStability();
					strat.stopGap();
				}
			}
		}
			
	}
	
	//Simple helper method that cleans up the look of the run method
	private boolean fitsTiming(String inc)
	{
		boolean flag = false;
		
		if(fitsHours(inc))
			if(fitsMinutes(inc))
				if(fitsSeconds(inc))
					return true;
			
		return flag;
	}
	
	/*
	 * Takes in the increment to be used, usually either trade or stop
	 * increment, parses out only the seconds/minutes etc, and then converts to an 
	 * integer. The same is done for the current time. Then, if the time
	 * is divisible by the increment, which is calculated using modulo,
	 * true is returned. Otherwise, false. 
	 * 
	 * All of the "fitsTime" methods are essentially identical, with
	 * the only difference being naming and the substring parameters,
	 * but I think they make the run and fitsTiming method easier to read 
	 * (IS 05/2/15)
	 */
	
	private boolean fitsMillis(String inc)
	{
		int currentSeconds = Integer.parseInt(Clock.time().substring(6));
		int incrementSeconds = Integer.parseInt(inc.substring(6));
		if(currentSeconds % incrementSeconds == 0)
			return true;
		else
			return false;
	}
	
	private boolean fitsSeconds(String inc)
	{
		int currentSeconds = Integer.parseInt(Clock.time().substring(4, 6));
		int incrementSeconds = Integer.parseInt(inc.substring(4, 6));
		if(currentSeconds % incrementSeconds == 0)
			return true;
		else
			return false;
	}
	
	private boolean fitsMinutes(String inc)
	{
		int currentMinutes = Integer.parseInt(Clock.time().substring(2,4));
		int incrementMinutes = Integer.parseInt(inc.substring(2,4));
		if(currentMinutes % incrementMinutes == 0)
			return true;
		else
			return false;
	}
	
	private boolean fitsHours(String inc)
	{
		int currentHours = Integer.parseInt(Clock.time().substring(0,2));
		int incrementHours = Integer.parseInt(inc.substring(0,2));
		if(currentHours % incrementHours == 0)
			return true;
		else
			return false;
	}
}
