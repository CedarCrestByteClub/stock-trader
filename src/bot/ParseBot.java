package bot;

import java.awt.AWTException;
import java.awt.Robot;
import com.sun.glass.ui.Pixels;

public class ParseBot extends Robot
{ 
	
	public ParseBot() throws AWTException
	{
		super();
	}
	
	public void getData() throws InterruptedException
	{
		//Get focus of the window
		this.mouseMove(310, 10);
		this.mousePress(1);
		Thread.sleep(1000);
		
		//Click on the 'Export chart data' button
		this.mouseMove(416, 215);
		this.mousePress(1);
		Thread.sleep(1000);
		
		//Click on the 'Export Data' button
		this.mouseMove(303, 694);
		this.mousePress(1);
		Thread.sleep(1000);
		
		//Click on the current stock.txt
		this.mouseMove(300, 360);
		this.mousePress(1);
		Thread.sleep(1000);
		
		//Click on the save button
		this.mouseMove(800, 650);
		this.mousePress(1);
		Thread.sleep(1000);
	}

	
}
