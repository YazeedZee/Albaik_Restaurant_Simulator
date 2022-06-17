package application;
import java.util.*;
import java.util.ArrayList;
import java.util.Random;

public class AlbaikBranch
{
	// objects
	AlbaikOrderTime OrderLatency = new AlbaikOrderTime();//is one element of OrdersTime Array
	AlbaikCashier Cashier= new AlbaikCashier();// create an object here
	Random ran= new Random();
	//variables
	private int OrderTag=0;
	public long latencyMen=0;
	public long latencyWomen=0;
	private int wait;
	public int total=0;
	long updatedTimeMen= getLatencyMen();
	long updatedTimeWomen= getLatencyWomen();
	//setter
	public void setOrderTag()
	{
		this.OrderTag=0;
	}
	 //getter
	public  int orderTag()// to be stored in AlbaikOrder class
	{
		OrderTag++;
	    return OrderTag;
	}
	/////////////////////////
	//constructor
	public AlbaikBranch()//BIG ISSUE HERE
	{
		//updateLatency();
		//genOrders();
		//generateCustomers();
		//toString();

	}
	//Arrays and Queues
	ArrayList<AlbaikOrder>Orders = new ArrayList<AlbaikOrder>();//to be like [order 1,order 2,...] and so on
	ArrayList<Walk_In>Men_Queue= new ArrayList<Walk_In>();// to generate as many as object and add them
	ArrayList<Women> Women_Queue = new ArrayList<Women>();// to generate as many as object and add them10
	//remover for Arrays' elements
	public ArrayList<AlbaikOrder> subOrder(AlbaikOrder x)//No need for this method
	{
	        Orders.remove(0);
	        return Orders;
	}
	public ArrayList<Walk_In> subWomen(Walk_In x)//No need for this method
    {
		Men_Queue.remove(0);
        return Men_Queue;
    }
	public ArrayList<Women> subWomen(Women x)//No need for this method
    {
		Women_Queue.remove(0);
        return Women_Queue;
    }
	//generator
	public void genWalkInCustomers()// work is for while loop on city class
	{
		int work=0;//work time per min
		int num;
		while(work<=360)// number of loops based on mins
		{
			if (work%2== 0)
			 {
				num = ran.nextInt(2)+1;// 1 to 3 number of loops
				double percentage = ran.nextDouble();
				if (percentage<=0.3)
				{
					for (int count=0;count<=num;count++)
					{
						Women_Queue.add(new Women());
						Orders.add(new AlbaikOrder());
						updateLatencyWomen();
					}
				}
				else
				{
					for (int count=0;count<=num;count++)
					{
						Men_Queue.add(new Walk_In());
						Orders.add(new AlbaikOrder());
						updateLatencyMen();
					}
				}
			 }
			work++;
		}
	}
	//summer of orders time
	public void setWait(int wait)
	{
		this.wait=wait;
	}
	public void setTotal()// to restart the waiting time
	{
		this.total=0;
	}
	public int getWait()
	{
		return wait;
	}
	public int sumOfOrders()
	{
		 total = total+getWait();
		 return total;
	}

	//Updating waiting time
	 public void updateLatencyMen()// to update the waiting time in the branch
	 {
		latencyMen = (long) (sumOfOrders()/(Cashier.getSpeed()+Men_Queue.size()+Women_Queue.size()));// extra time* the number in the queue
		Cashier.increase();
	 }
	 public long getLatencyMen()
	 {
		 return latencyMen;
	 }
	 public void updateLatencyWomen()// to update the waiting time in the branch
	 {

		 latencyWomen = (long) (sumOfOrders()/(Cashier.getSpeed()+Women_Queue.size()));// extra time* the number in the queue
		 Cashier.increase();
	 }
	 public long getLatencyWomen()
	 {
		 return latencyWomen;
	 }
	 /////////////////////////
	 // process and stuff
	 // doing the process
	 public void do_process(AlbaikOrder x)
	 {
		 OrderLatency.setMin(OrderLatency.getMin()-60);
		 //checking order ready
		 if(orderCheck(x)==true)// deletes the completed order from the array list
		 {
			 subOrder(x);
		 }
	 }
	 //create a method for cashier speed, somehow related to orders or days
	 public boolean orderCheck(AlbaikOrder x)
	 {
		 if(x.OrderTime.getMin()==0)
		 {
			 return true;
		 }
		 else
		 {
			 return false;
		 }
	 }
}
