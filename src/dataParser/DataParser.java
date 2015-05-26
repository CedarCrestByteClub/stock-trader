package dataParser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class DataParser
{
	private String txtFile = "";
	private BufferedReader br = null;
	private String line = "";
	private String cvsSplitBy = ",";
	private ArrayList<Stock> tick = new ArrayList<Stock>();
	
	public DataParser(String fp)
	{
		txtFile = fp;
	}
	
	public void parseData()
	{
		int junk = 1;
		
		int index = 0;
		try
		{
			br = new BufferedReader(new FileReader(txtFile));
			while ((line = br.readLine()) != null)
			{
				String[] tokens = line.split(",");
				if (junk <= 0)
				{
					
					tick.add(new Stock());
					tick.get(index).setDate(tokens[0]);
					tick.get(index).setOpen(Double.parseDouble(tokens[1]));
					tick.get(index).setHigh(Double.parseDouble(tokens[2]));
					tick.get(index).setLow(Double.parseDouble(tokens[3]));
					tick.get(index).setClose(Double.parseDouble(tokens[4]));
					if (tokens.length > 5 && !tokens[5].equalsIgnoreCase(""))
						tick.get(index).setAverage1(
								Double.parseDouble(tokens[5]));
					if (tokens.length > 6 && !tokens[6].equalsIgnoreCase(""))
						tick.get(index).setAverage2(
								Double.parseDouble(tokens[6]));
					index++;
				}
				else junk--;
			}
			
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		
	}
	
	public ArrayList<Stock> getStock()
	{
		return tick;
	}
	
	public String toString()
	{
		return tick.toString();
	}
}
