package application;
import java.security.SecureRandom;

public class DeliveryCompany extends Customer
{

	SecureRandom rnd = new SecureRandom();
    public int extraOnline()
    {
    	int timeToBranch = rnd.nextInt(300)+60;// time to get to the branch

    	return timeToBranch;
    }
    	//check latency
	  // how far is he
	   // high volume affect waiting
}