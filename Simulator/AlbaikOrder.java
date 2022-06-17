package application;
import java.security.SecureRandom;
import java.util.Random;
public class AlbaikOrder
{
	//objects
	//SecureRandom rnd = new SecureRandom();
	Random rnd = new Random();
    AlbaikOrderTime OrderTime = new AlbaikOrderTime();// object from AlbaikOrderTime
    AlbaikBranch branch = new AlbaikBranch();// to get the order type and order tag
   // AlbaikBranchWithOnline onlinebranch = new AlbaikBranchWithOnline();
    Customer man= new Walk_In();
    //variables
    private int placing;
    private int arrive=660;
    private int pickUp;
    private int pickUp2;
    private int orderReady;
    public int mins = 660;
    public int num1=0;//used in max method
    //constructors
    public AlbaikOrder(AlbaikBranch x,Walk_In man)
    {
    	//0genOrder();
    	//branch.orderTag();
    	toString(x,man);
    	//genOrder();
    }
    public AlbaikOrder()
    {
    	//genOrder();
    	//branch.orderTag();
    	toString();
    }
    //setter
    public void setArriving()
    {
    	this.arrive=arrive+rnd.nextInt(7)+1;
    }
    public void generateOrder()
    {
    	placing = getArriving()+rnd.nextInt(7)+1;
    	branch.setWait(placing);
    }
    public void setReady()
    {
    	orderReady =  genOrder()+rnd.nextInt(10)+1;
    }
    public void setPickUp()
    {
    	pickUp =genOrder()+rnd.nextInt(10)+1;
    }
    public void setPickUp2()
    {
    	pickUp2 =getOrderReady()+rnd.nextInt(10)+1;
    }
    //getter
    public int getArriving()//arrive
    {
    	if(arrive>=1500)
    	{
    		return arrive-1440;
    	}
    	else
    	{
    		return arrive;
    	}
    }
    public int genOrder()//placing
    {
    	return placing;
    }
    public int getOrderReady()
    {
    	return orderReady;
    }
    public int getPickUp()//pick up
    {
    	return pickUp;
    }
    public int getPickUp2()
    {
    	return pickUp2;
    }
    public int getTime()
    {
    	placing = branch.sumOfOrders();
    	return placing;
    }

    public int getLatencyWalk()//new
    {
    	int late = Math.abs(getPickUp()-getArriving());
    	return late;
    }
    public int getWait()//new
    {
    	return Math.abs(genOrder()-getArriving());
    }
    public int getOrder()//new
    {
    	return Math.abs(getPickUp()-genOrder());
    }
    //to get max waiting
    public int getMax(int num)
    {
    	setArriving();
    	generateOrder();
    	setReady();
    	setPickUp();
    	setPickUp2();
    	if(num>num1)
    	{
    		num1= num;
    		return num;
    	}
    	else
    	{
    		return num1;
    	}
    }
    public int getmax(int a , int b)
    {
        int largest;
        if (a>b)
            largest = a;
        else
            largest = b;

        return largest;
    }
    // to check branch type
    public String onlinePrinter(AlbaikBranch x)
    {
    	if(x instanceof CanReceiveOnlineOnlineOrder)
    	{
    		return String.format(" Online Branch  ");
    	}
    	else
    	{
    		return String.format(" Regular Branch ");
    	}
    }
    // to display needed info about the order

    public String toString(AlbaikBranch x, Customer man)
    {
    //	generateOrder();// invoke the generator to be automatically used in this method
    	branch.updateLatencyMen();// to update every time used
    	branch.updateLatencyWomen();// to update every time used
    	setArriving();
    	generateOrder();
    	setReady();
    	setPickUp();
    	setPickUp2();
    	if(man instanceof Walk_In)
    	{
    		return String.format("%s | %s | %17s | %18s | %15s | %11s | %13d | %12d | %10d |",onlinePrinter(x),man.info(man),OrderTime.toString(getArriving()),OrderTime.toString(genOrder()),OrderTime.toString(getPickUp()),OrderTime.toString(getPickUp()),getLatencyWalk(),getWait(),getOrder());//to represent a order time with order tag and order type
    	}
    	else if (man instanceof Women)
    	{
    		return String.format("%s | %s | %17s | %18s | %15s | %11s | %13d | %12d | %10d |",onlinePrinter(x),man.info(man),OrderTime.toString(getArriving()),OrderTime.toString(genOrder()),OrderTime.toString(getPickUp()),OrderTime.toString(getPickUp()),getLatencyWalk(),getWait(),getOrder());//to represent a order time with order tag and order type
    	}
    	else if (man instanceof OnlineCustomer)
    	{
    		return String.format("%s | %s | %17s | %18s | %15s | %11s | %13d | %12d | %10d |",onlinePrinter(x),man.info(man),OrderTime.toString(genOrder()),OrderTime.toString(getArriving()),OrderTime.toString(getOrderReady()),OrderTime.toString(getPickUp2()),getLatencyWalk(),0,getOrder());//to represent a order time with order tag and order type
    	}
    	else
    	{
    		return String.format("%s | %s | %17s | %18s | %15s | %11s | %13d | %12d | %10d |",onlinePrinter(x),man.info(man),OrderTime.toString(genOrder()),OrderTime.toString(getArriving()),OrderTime.toString(getOrderReady()),OrderTime.toString(getPickUp2()),getLatencyWalk(),0,getOrder());//to represent a order time with order tag and order type
    	}
    }
    public String toString1()
    {
    	return String.format("%d",getWait());
    }
}