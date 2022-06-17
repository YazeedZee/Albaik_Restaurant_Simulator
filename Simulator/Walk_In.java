package application;
import java.security.SecureRandom;

public class Walk_In extends Customer
{
	//object
	SecureRandom rnd = new SecureRandom();
	//constructor
	public Walk_In()
	{
		toString();
	}
	public int totalTimeMen()// special type of customer
	{
		// ordering time 60-180 min
		int orderingTime= rnd.nextInt(3)+1;
		//payment time 15-65 min
		int paymentTime= rnd.nextInt(2)+1;

		return orderingTime+paymentTime;
	}
	public String toString(Customer x)
	{
		return String.format(super.info(x));
	}
}