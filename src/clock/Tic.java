package clock;

import java.util.TimerTask;

public class Tic extends TimerTask
{
	
	public void run(Clock c)
	{
		c.runEverySecond();
	}

	public void run()
	{
		System.out.println("Default tic constructor called.");
	}
	
}
