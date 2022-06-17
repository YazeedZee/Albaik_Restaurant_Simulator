package application;
import java.security.SecureRandom;

public class OnlineCustomer extends Customer
{
	//object
    AlbaikOrderTime TimeToBranch = new AlbaikOrderTime();
    SecureRandom rnd = new SecureRandom();

    public int extraOnline()//still hasn't yet
    {
    	int timeToBranch = rnd.nextInt(5)+1;// time to get to the branch in min
    	return timeToBranch;
    }

   // how far is he
   // high volume affect waiting
}