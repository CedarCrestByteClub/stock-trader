package strategies;


/* This is essentially the abstract parent class
 * of all other strategy classes. Its not
 * currently abstract, but it could be made 
 * abstract later if it seemed convenient (IS 29/4/15)
 */
public class Strategy
{
	private boolean stable;
	
	public Strategy()
	{
		stable = true;
		//No idea what you need in here Andrew, your call.
	}
	
	public boolean isStable()
	{
		return stable;
	}
	
	public void trade()
	{
		//Main trading method, calls enter() or exit() accordingly
	}

	public void stopGap()
	{
		//Checks stopLoss/stopGap numbers, calling exit() if necessary
	}

	public void confirmStability()
	{
		//calls exit() as fast as possible and sets the stable value false;
	}
	
}
