package clock;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Tic
{
	public final String marketOpen = "093000"; 
	public final String marketClose = "043000";
	//								  "012345"
	
	private int tradeIncrement;
	
	public Tic(int i)
	{
		tradeIncrement =  i;
		//runForeverTest();
		runForever();
	}
	
	private void runForeverTest()
	{
		String timeStamp = null;
		boolean flag=true;
		while(flag)
		{
			flag = false;
			timeStamp = new SimpleDateFormat("HHmmss").format(Calendar.getInstance().getTime());
		}
		System.out.println(timeStamp);
	}
	
	private void runForever()
	{
		String timeStamp = null;
		while(true)
		{
			timeStamp = new SimpleDateFormat("HHmmss").format(Calendar.getInstance().getTime());
			if(Integer.parseInt(timeStamp.substring(2)) % tradeIncrement == 0)
				System.out.println(timeStamp);
		}
	}
}
