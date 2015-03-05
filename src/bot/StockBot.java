package bot;

import java.awt.AWTException;
import java.awt.Robot;

public class StockBot extends Robot
{
	public final int welcomeX = 400, welcomeY = 350; 
	
	public StockBot() throws AWTException
	{
		super();
	}
	
	public void resetPage()
	{
		this.mouseMove(welcomeX, welcomeY);
		this.mousePress(1);
	}
}
