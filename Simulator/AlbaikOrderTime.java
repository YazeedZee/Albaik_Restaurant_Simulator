package application;

public class AlbaikOrderTime
{
	//instance variable
	private int min;// for min
	//constructors
	public AlbaikOrderTime( int min)
	{
		setMin(min);
	}
	//with no-argument
	public AlbaikOrderTime()
	{
		this.min=0;
	}
	//setter
	public void setMin(int min) // sth has to be done
	{
		this.min=min;
	}
	//getter
	public int getMin()
	{
		return min;
	}
	//to return a representation as 00:00
	public String toString(int num)
	{
		int hour= (num/60);//to obtain the value of min
		int min1 = num-(min*60);
		while(min1>=60)
		{
			min1= min1-60;
		}
		return String.format("%02d:%02d",hour,min1);// 11:11
	}
}
