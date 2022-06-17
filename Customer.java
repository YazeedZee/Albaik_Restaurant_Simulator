package application;

public abstract class Customer
{

    //check son's type
	public String info(Customer x)
	{
		if (x instanceof Walk_In)
		{
			return String.format("Walk in Man      ");
		}
		else if (x instanceof Women)
		{
			return String.format("Walk in Women    ");
		}
		else if (x instanceof OnlineCustomer)
		{
			return String.format("Online Customer  ");
		}
		else
		{
			return String.format("Delivery Customer");
		}
	}

}