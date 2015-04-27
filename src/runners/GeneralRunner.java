package runners;

import java.awt.AWTException;

import bot.StockBot;

public class GeneralRunner 
{
	public static void main(String[] args) throws AWTException 
	{
		StockBot bob = new StockBot();
		System.out.println(bob);
	}

}
