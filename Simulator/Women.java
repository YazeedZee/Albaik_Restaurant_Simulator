package application;
import java.security.SecureRandom;

public class Women extends Customer
{
	AlbaikOrder order = new AlbaikOrder();
	SecureRandom rnd = new SecureRandom();
	public Women()
	{
		totalTimeWomen();
	}
	public int totalTimeWomen()
	{
		// ordering time
		int orderingTime= rnd.nextInt(3)+1;
		//payment time
		int paymentTime= rnd.nextInt(2)+1;


		return orderingTime+paymentTime+order.genOrder();
	}
	public String toString(Customer x)
	{
		//order.OrderTime.setSec(totalTimeMen());
		return String.format(super.info(x));
	}
}