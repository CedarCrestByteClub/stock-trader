package strategies;

import java.awt.AWTException;
import java.util.ArrayList;

import bot.StockBot;
import dataParser.DataParser;
import dataParser.Stock;

/* This is essentially the abstract parent class
 * of all other strategy classes. Its not
 * currently abstract, but it could be made 
 * abstract later if it seemed convenient (IS 29/4/15)
 */
public class Strategy
{
	private double boughtAt;
	private boolean stable;
	private boolean currentlyTrading;
	private StockBot trader;
	private DataParser d;
	private ArrayList<Stock> stock;
	
	public Strategy()
	{
		try
		{
			trader = new StockBot();
		}
		catch (AWTException e)
		{
			System.out.println(e);
		}
		stable = true;
		currentlyTrading = false;
		
	}
	
	// Make sure that you change your path to whatever it is on your computer
	public void parseData()
	{
		d = new DataParser(
				"C:\\Users\\Andrew Dalzon\\Desktop\\eclipse\\Java Workspace\\stock-trader\\stock.txt");
		d.parseData();
		stock = d.getStock();
	}
	
	public boolean isStable()
	{
		return stable;
	}
	
	public void trade()
	{
		// Main trading method, calls enter() or exit() accordingly
		if (stock.get(stock.size() - 1).getAverage1() < stock.get(
				stock.size() - 1).getAverage2()
				&& !currentlyTrading)
		{
			boughtAt = stock.get(stock.size() - 1).getOpen();
			trader.enter();
			currentlyTrading = true;
		}
		else if (stock.get(stock.size() - 1).getAverage1() < stock.get(
				stock.size() - 1).getAverage2()
				&& currentlyTrading)
		{
			trader.exit();
			currentlyTrading = false;
		}
		
	}
	
	public void stopGap()
	{
		if (stock.get(stock.size() - 1).getOpen() < (stock
				.get(stock.size() - 1).getOpen() * .97) && currentlyTrading)
		{
			trader.exit();
			currentlyTrading = false;
		}
		
	}
	
	public void confirmStability()
	{
		// calls exit() as fast as possible and sets the stable value false;
	}
	
}
