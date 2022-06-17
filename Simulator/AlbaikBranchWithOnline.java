package application;

import java.util.ArrayList;
import java.util.Random;

public class AlbaikBranchWithOnline extends AlbaikBranch implements CanReceiveOnlineOnlineOrder
{
	//object
	Random gen = new Random();
	//
	ArrayList<OnlineCustomer> Online_Queue = new ArrayList<OnlineCustomer>();
	ArrayList<DeliveryCompany> Delivery_Queue = new ArrayList<DeliveryCompany>();
	//for online order
	ArrayList<AlbaikOrder>OnlineOrder = new ArrayList<AlbaikOrder>();
	//setter
	public void setOrderTag()
	{
		super.setOrderTag();
	}
	//generator for online customer

	public void genOnlineCustomers()
	{
		int work=0;//per min
		int num;
		while(work<=360)// to have online customers every two mins
		{
			if (work%2== 0)
			 {
				num = ran.nextInt(2)+1;
				double percentage = ran.nextDouble();
				if (percentage<=0.5)
				{
					for (int count=0;count<=num;count++)
					{
						Delivery_Queue.add(new DeliveryCompany());
						OnlineOrder.add(new AlbaikOrder());
					}
				}
				else
				{
					for (int count=0;count<=num;count++)
					{
						Online_Queue.add(new OnlineCustomer());
						OnlineOrder.add(new AlbaikOrder());
					}
				}
			 }
			work++;
		}
	}
    public void onlineCheck()// for interface implementation
    {
    	System.out.print("Albaik Branch with Online");
    }

}