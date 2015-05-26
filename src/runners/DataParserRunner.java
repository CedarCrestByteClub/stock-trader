package runners;

import dataParser.DataParser;

public class DataParserRunner
{
	public static void main(String[] args)
	{
		DataParser d = new DataParser("C:\\Users\\Andrew Dalzon\\Desktop\\eclipse\\Java Workspace\\stock-trader\\stock.txt");
		d.parseData();
		System.out.println(d.toString());
	}
}
