package dataParser;

public class Stock
{
	String date = "";
	Double open, high, low, close, average1, average2;
	
	public Stock()
	{
		
	}

	public String getDate()
	{
		return date;
	}

	public void setDate(String date)
	{
		this.date = date;
	}

	public Double getOpen()
	{
		return open;
	}

	public void setOpen(Double open)
	{
		this.open = open;
	}

	public Double getHigh()
	{
		return high;
	}

	public void setHigh(Double high)
	{
		this.high = high;
	}

	public Double getLow()
	{
		return low;
	}

	public void setLow(Double low)
	{
		this.low = low;
	}

	public Double getClose()
	{
		return close;
	}

	public void setClose(Double close)
	{
		this.close = close;
	}

	public Double getAverage1()
	{
		return average1;
	}

	public void setAverage1(Double average1)
	{
		this.average1 = average1;
	}

	public Double getAverage2()
	{
		return average2;
	}

	public void setAverage2(Double average2)
	{
		this.average2 = average2;
	}

	@Override
	public String toString()
	{
		return "Stock [date=" + date + ", open=" + open + ", high=" + high
				+ ", low=" + low + ", close=" + close + ", average1="
				+ average1 + ", average2=" + average2 + "]";
	}
	
}
